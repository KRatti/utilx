/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx.cli;

/** An exception for the CLICommand class */
public class InvalidUsageException extends RuntimeException
{
	/**
	* Creates a new InvalidUsageException with the specified error message
	*
	* @param strMsg The error message
	*/
	public InvalidUsageException(String strMsg)
	{
		super(strMsg);
	}
}