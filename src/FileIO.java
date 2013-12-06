/**
* @author Kyle Ratti (PC18)
* @version 1.1, 10/09/13
*/

package utilx;

import java.util.Iterator;
import java.util.Scanner;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
* Enables interfacing with files with simplicity for reading, writing/appending, and retrieving file information
*
* @deprecated This is a mess and needs replacing ASAP
*/
public class FileIO implements Iterator<String>
{
	/** The file to manipulate */
	private File targetFile;
	private Scanner lineScanner;

	private int lines = -1;
	private PrintWriter writer = null;

	/**
	* Creates a FileIO object with the specified path
	*
	* @param strFile Path to the file
	*/
	public FileIO(String strFile)
	{
		this(new File(strFile));
	}

	/**
	* Creates a FileIO object with the specified File
	*
	* @param objFile The file object
	*/
	public FileIO(File objFile)
	{
		this.targetFile = objFile;

		if(this.exists())
		{
			try
			{
				this.lineScanner = new Scanner(this.targetFile);
			}
			catch(FileNotFoundException e){}
		}
	}

	/**
	* Returns true if the iteration has more elements
	*
	* @return Does the file have more lines
	*/
	public boolean hasNext()
	{
		return this.lineScanner.hasNext();
	}
	
	/**
	* Gets the next set of data in the file, split by a space
	*
	* @return The next set of data in the file
	*/
	public String next()
	{
		return this.lineScanner.next();
	}

	/**
	* Gets the next int in the file, split by a space
	*
	* @return The next int in the file
	*/
	public int nextInt()
	{
		return this.lineScanner.nextInt();
	}

	/**
	* Gets the next line in the file
	*
	* @return The next line in the file
	*/
	public String nextLine()
	{
		return this.lineScanner.nextLine();
	}

	/** Not implemented */
	public void remove(){}

	/** Resets the scanner */
	public void reset()
	{
		this.lineScanner.close();

		try
		{
			this.lineScanner = new Scanner(this.targetFile);
		}
		catch(FileNotFoundException e){}
	}

	/**
	* Gets the number of lines in the file
	*
	* @return The number of lines
	*/
	public int getNumLines()
	{
		if(this.lines == -1)
		{
			this.lines = 0;

			if(this.isFile())
			{
				while(this.lineScanner.hasNextLine())
				{
					this.lines++;
					this.lineScanner.nextLine();
				}

				this.reset();
			}
		}

		return this.lines;
	}

	/**
	* Gets the name of the file without the extension
	*
	* @return The file name
	*/
	public String getFilename()
	{
		return this.getFilename(false);
	}

	/**
	* Gets the name of the file
	*
	* @param bExtension Append the extension to the filename
	* @return The file name
	*/
	public String getFilename(boolean bExtension)
	{
		if(!bExtension)
		{
			String strFilename = this.targetFile.getName();

			return strFilename.substring(0, strFilename.lastIndexOf("."));
		}

		return this.targetFile.getName();
	}

	/**
	* Gets the extension of the file (ex ".zip")
	*
	* @return The file's extension
	*/
	public String getExtension()
	{
		if(!this.targetFile.isFile())
		{
			return "";
		}

		String strFilename = this.targetFile.getName();

		if(strFilename.indexOf(".") > 0)
		{
			return strFilename.substring(strFilename.lastIndexOf("."));
		}

		return "";
	}

	public String getAbsolutePath()
	{
		return this.targetFile.getAbsolutePath();
	}

	/**
	* Gets if the file is a file (and not a directory)
	*
	* @return Is the file a file (and not a directory)
	*/
	public boolean isFile()
	{
		return this.targetFile.isFile();
	}

	/**
	* Checks if the file exists (ignores directories)
	*
	* @return Does the file exist
	*/
	public boolean exists()
	{
		return this.exists(false);
	}

	/**
	* Checks if the file exists
	*
	* @param bAllowDir Allow checking of existance of directories
	* @return Does the file/directory exist
	*/
	public boolean exists(boolean bAllowDir)
	{
		if(this.targetFile.exists())
		{
			return (!this.targetFile.isFile() && !bAllowDir) ? false : true;
			/*if(!this.targetFile.isFile() && !bAllowDir)
			{
				return false;
			}

			return true;*/
		}

		return false;
	}

	/**
	* Attempts to create a new PrintWriter
	*/
	private void makeWriter()
	{
		if(this.writer == null)
		{
			try
			{
				this.writer = new PrintWriter(this.targetFile);
			}
			catch(IOException e)
			{
				System.out.println("!! Unable to make new writer");
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	* Writes text to a file
	*
	* @param strData The text to write
	*/
	public void write(String strData)
	{
		this.makeWriter();

		this.writer.write(strData);
		this.writer.flush();
		//this.writer = null;
	}

	/**
	* Appends text to a file
	*
	* @param strData The text to append
	*/
	public void append(String strData)
	{
		this.makeWriter();

		this.writer.append(strData);
		this.writer.flush();
	}

	/**
	* Attempts to close the file handle
	*/
	public void close()
	{
		if(this.writer != null)
		{
			this.writer.close();
		}
	}

	/**
	* Attempts to get the contents of the file
	*
	* @return A String of the file contents
	*/
	public String getContents()
	{
		StringBuilder objOutput = new StringBuilder();
		String strData = null;

		try
		{
			FileInputStream objInStream = new FileInputStream(this.targetFile);
			DataInputStream objIn = new DataInputStream(objInStream);
			BufferedReader objReader = new BufferedReader(new InputStreamReader(objIn));

			while((strData = objReader.readLine()) != null)
			{
				objOutput.append(strData);
				objOutput.append('\n');
			}

			objIn.close();
		}
		catch(Exception e) {}

		return objOutput.toString();
	}
}