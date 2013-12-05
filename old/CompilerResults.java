/**
* @author Kyle Ratti (PC18)
* @version 1.0, 11/11/13
*/

package utilx;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

/** Results from the utilx Compiler */
public class CompilerResults
{
	private boolean successful;
	private ArrayList<CompilerError> errors = new ArrayList<CompilerError>();
	private long startTime;
	private long endTime;

	public CompilerResults(boolean bSuccess, long lgStart)
	{
		this.successful = bSuccess;
		this.startTime = lgStart;
		this.endTime = System.currentTimeMillis();
	}

	/**
	* Adds an error to the results
	*
	* @param lgLine The line number
	* @param lgColumn The column number
	* @param strError The error message
	*/
	public void addError(long lgLine, long lgColumn, String strError)
	{
		this.errors.add(new CompilerError(lgLine, lgColumn, strError));
	}

	/**
	* Gets the start time of the compile
	*
	* @return The millisecond time the compile started
	*/
	public long getStartTime()
	{
		return this.startTime;
	}

	/**
	* Gets the time the compile finished
	*
	* @return The millisecond time when the compile finished
	*/
	public long getEndTime()
	{
		return this.endTime;
	}

	/**
	* Gets the time the compile took
	*
	* @return The millisecond time that the file took to compile
	*/
	public long getCompileTime()
	{
		return this.endTime - this.startTime;
	}

	/**
	* Gets the errors associated with this result
	*
	* @return The CompilerErrors
	*/
	public ArrayList<CompilerError> getErrors()
	{
		ArrayList<CompilerError> objTemp = new ArrayList<CompilerError>(Arrays.asList(new CompilerError[this.errors.size()]));
		Collections.copy(objTemp, this.errors);

		return objTemp;
	}

	/**
	* Gets if the compile succeeded
	*
	* @return true if the compile succeeded
	*/
	public boolean successful()
	{
		return this.successful;
	}
}