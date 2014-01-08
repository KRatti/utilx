/**
* @author Kyle Ratti (PC18)
* @version 1.0, 01/08/14
*/

package utilx.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/** Provides an interface for Derby databases with the Derpy class */
public class DBInterface
{
	private static Derpy database = null;

	/**
	* Sets up DBInterface with the specified database
	*
	* @param strDatabase The database to set up with
	*/
	public static void setup(String strDatabase)
	{
		try
		{
			DBInterface.database = new Derpy(strDatabase);
			DBInterface.database.connect();
		}
		catch(SQLException e)
		{
			System.err.println("Error connecting to server (someone already connected?)");
		}
		catch(ClassLoadException e)
		{
			System.err.println("Error loading Derby driver");
		}
	}

	/**
	* Prepares a statement with the database
	*
	* @param strQuery The query to run
	* @return A <code>PreparedStatement</code>
	* @throws SQLException
	*/
	public static PreparedStatement prepare(String strQuery) throws SQLException
	{
		return DBInterface.database.prepare(strQuery);
	}

	/**
	* Executes a query on the database
	*
	* @param strQuery The query to run
	* @return A <code>ResultSet</code>
	* @throws SQLException
	*/
	public static ResultSet query(String strQuery) throws SQLException
	{
		return DBInterface.database.query(strQuery);
	}
}