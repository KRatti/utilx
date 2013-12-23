/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx.forms;

/** A text field */
public class InvalidInputException extends RuntimeException
{
	public InvalidInputException(String strMsg)
	{
		super(strMsg);
	}
}