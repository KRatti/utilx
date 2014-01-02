/**
* @author Kyle Ratti (PC18)
* @version 1.0, 1/2/14
*/

package utilx.forms;

public class InputException extends RuntimeException
{
	/**
	* Creates a new InputException with the specified error message
	*
	* @param strMsg The error message
	*/
	public InputException(String strMsg)
	{
		super(strMsg);
	}
}