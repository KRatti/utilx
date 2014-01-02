/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx.forms;

import utilx.Prompt;

/** A text field */
public class PCheckbox extends PFormElement
{
	private String text = "";

	public PCheckbox(String strName)
	{
		super(strName);
	}

	public String getText()
	{
		return this.text;
	}

	@Override
	public void preShow()
	{
		Prompt.setAllowNullInput(true);
	}

	public void show()
	{
		try
		{
			this.text = Prompt.getYesNo(this.getName()).toString();
			this.validateInput();
		}
		catch(InvalidInputException e)
		{
			System.err.println("Error: " + e.getMessage());
		}
	}

	@Override
	public void validateInput() throws InvalidInputException
	{
		String strText = this.getText();

		if(strText == null)
			throw new InvalidInputException("Expected a response");
	}

	public void showDialog()
	{
		Prompt.showError("Not yet implemented");
	}
}