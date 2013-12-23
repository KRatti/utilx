/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx.forms;

import utilx.Prompt;

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

	public void show()
	{
		try
		{
			this.text = Prompt.getString(this.getName());
			this.validateInput();
		}
		catch(InvalidInputException e)
		{
			System.err.println("Error: " + e.getMessage());
		}
	}

	public void showDialog()
	{
		Prompt.showError("Not yet implemented");
	}
}