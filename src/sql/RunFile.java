/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/12/13
*/

package utilx.sql;

import java.io.File;
import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;

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
		try
		{
			File objFile = new File(strFile);

			if(objFile.exists())
			{
				Scanner objScanner = new Scanner(objFile);

				while(objScanner.hasNextLine())
				{
					try
					{
						objConnection.createStatement().executeQuery(objScanner.nextLine());
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
		catch(IOException e)
		{
			System.out.println("Unable to read file (?!)");
		}
	}
}