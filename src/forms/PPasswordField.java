/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx.forms;

import utilx.Prompt;

/** A text field */
public class PPasswordField extends PFormElement
{
	private String text = "";

	public PPasswordField(String strName)
	{
		super(strName);
	}

	public String getText()
	{
		return this.text;
	}

	public void show()
	{
		try
		{
			this.text = Prompt.getPassword(this.getName());
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