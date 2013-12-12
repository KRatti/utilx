/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/12/13
*/

package utilx.sql;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Scanner;

/** Run SQL statements in a file! */
public class RunFile
{
	/**
	* Runs the SQL in the specified file on the specified database connection
	*
	* @param strFile The sql file to run
	* @param objConnection The database connection to send queries to
	*/
	public static void run(String strFile, Connection objConnection)
	{
		File objFile = new File(strFile);

		if(objFile.exists())
		{
			for(String strQuery : RunFile.getQueries(objFile))
			{
				try
				{
					objConnection.createStatement().executeQuery(strQuery);
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		else
		{
			System.out.println("File not found!");
		}
	}

	/**
	* Gets an array of all queries in the file
	*
	* @return An <code>ArrayList</code> of queries
	*/
	private static ArrayList<String> getQueries(File objFile)
	{
		try
		{
			Scanner objScanner = new Scanner(objFile);
			objScanner.useDelimiter(";");

			ArrayList<String> objQueries = new ArrayList<String>();

			while(objScanner.hasNext())
			{
				String strQuery = (objScanner.next() + ";").replace("\n", "").replace("\r", "");

				if(strQuery.length() > 1)
				{
					System.out.println(strQuery);
					objQueries.add(strQuery);
				}
			}

			return objQueries;
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}

		return new ArrayList<String>();
	}
}