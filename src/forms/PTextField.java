/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx.forms;

/** A text field */
public class PTextField extends PFormElement
{
	private String text = "";

	public PTextField(String strName, PForm objParent)
	{
		super(strName, objParent);
	}

	public String getText()
	{
		return this.text;
	}
}