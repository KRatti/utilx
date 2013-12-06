/**
* @author Kyle Ratti (PC18)
* @version 1.0, 11/11/13
*/

package utilx;

/** An error from the compiler */
public class CompilerError
{
	private long line;
	private long column;
	private String error;

	/**
	* Creates a new compiler error
	*
	* @param lgLine The line number of the error
	* @param lgColumn The column number of the error
	* @param strError The error message
	*/
	public CompilerError(long lgLine, long lgColumn, String strError)
	{
		this.line = lgLine;
		this.column = lgColumn;
		this.error = strError;
	}

	/**
	* Gets the line of the error
	*
	* @return The line of the error
	*/
	public long getLine()
	{
		return this.line;
	}

	/**
	* Gets the column of the error
	*
	* @return The column of the error
	*/
	public long getColumn()
	{
		return this.column;
	}

	/**
	* Gets the error message
	*
	* @return The error message
	*/
	public String getError()
	{
		return this.error;
	}
}