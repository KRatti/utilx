/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx.forms;

/** A text field */
public class InputCanceledException extends RuntimeException
{
	public InputCanceledException(String strMsg)
	{
		super(strMsg);
	}
}