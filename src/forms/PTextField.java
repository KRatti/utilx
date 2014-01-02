/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx.forms;

import utilx.Prompt;

import javax.swing.JPanel;

/** A text field */
public class PTextField extends PFormElement
{
	private String text;

	public PTextField(String strName)
	{
		super(strName);
		this.text = null;
	}

	@Override
	public void validateInput() throws InvalidInputException
	{
		if(this.getResponse() == null)
			throw new InvalidInputException("Expected text to be inputted");
		else if(this.getResponse().length() <= 3)
			throw new InvalidInputException("Expected text >= 3 characters long");
	}

	public String getResponse()
	{
		return this.text;
	}

	public void show()
	{
		this.text = Prompt.getString(this.getName());
	}

	public JPanel getPanel()
	{
		throw new RuntimeException("Not yet implemented");
	}
}