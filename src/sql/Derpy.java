/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/5/13
*/

package utilx.sql;

import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;

/** Easy interfacing with a Derby database */
public class Derpy
{
	private final String database;
	private final String connectString;
	private Connection connection;

	/**
	* Creates a new Derpy object
	*
	* @param strDatabase The name of the database
	* @throws SQLException, ClassLoadException
	*/
	public Derpy(String strDatabase) throws SQLException, ClassLoadException
	{
		try
		{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		}
		catch(ClassNotFoundException e)
		{
			throw new ClassLoadException();
		}
		catch(InstantiationException e)
		{
			throw new ClassLoadException();
		}
		catch(IllegalAccessException e)
		{
			throw new ClassLoadException();
		}

		this.database = strDatabase;
		this.connectString = "jdbc:derby:" + this.database + ";create=true";
	}

	/**
	* Attempts to connect to the database
	*
	* @throws SQLException
	*/
	public void connect() throws SQLException
	{
		this.close();
		this.connection = DriverManager.getConnection(this.connectString);
	}

	/**
	* Retrieves whether the database connection has been closed
	*
	* @return <code>true</code> if the database connection has been closed
	*/
	public boolean isClosed()
	{
		if(this.connection == null)
			return false;

		try
		{
			return this.connection.isClosed();
		}
		catch(SQLException e)
		{
			return false;
		}
	}

	/**
	* Creates a <code>PreparedStatement</code> with the database
	*
	* @param strQuery The SQL statement to run
	* @return A <code>ResultSet</code> with the query results
	* @throws SQLException
	*/
	public PreparedStatement prepare(String strQuery) throws SQLException
	{
		if(this.connection == null) return null;

		return this.connection.prepareStatement(strQuery);
	}

	/**
	* Runs a query on the database<br/>
	* NOTE: This will not do any escaping!
	*
	* @param strQuery The SQL statement to run
	* @return A <code>ResultSet</code> with the query results
	* @throws SQLException
	*/
	public ResultSet query(String strQuery) throws SQLException
	{
		if(this.connection == null) return null;

		return this.connection.createStatement().executeQuery(strQuery);
	}

	/**
	* Releases this <code>Connection</code> object's database and JDBC resources immediately instead of waiting for them to be automatically released.
	* @throws SQLException
	*/
	public void close() throws SQLException
	{
		if(this.connection != null)
			this.connection.close();
	}
}