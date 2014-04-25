/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx.forms;

import javax.swing.JPanel;

import utilx.Prompt;

/** A text field */
public class PPasswordField extends PFormElement
{
	private String text;

	public PPasswordField(String strName)
	{
		super(strName);
		this.text = null;
	}

	@Override
	public void validateInput() throws InvalidInputException
	{
		if(this.getResponse() == null)
			throw new InvalidInputException("Expected a password to be inputted");
		else if(this.getResponse().length() <= 3)
			throw new InvalidInputException("Expected a password >= 3 characters long");
	}

	public String getResponse()
	{
		return this.text;
	}

	public void show()
	{
		this.text = Prompt.getPassword(this.getName());
	}

	public JPanel getPanel()
	{
		throw new RuntimeException("Not yet implemented");
	}
}