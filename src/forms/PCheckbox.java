/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx.forms;

import javax.swing.JPanel;

import utilx.Prompt;

/** A checkbox */
public class PCheckbox extends PFormElement
{
	private Boolean response;

	public PCheckbox(String strName)
	{
		super(strName);
		this.response = null;
	}

	@Override
	public void validateInput() {}

	public Boolean getResponse()
	{
		return this.response;
	}

	public void show()
	{
		Prompt.setAllowNullInput(true);
		Character strLetter = Prompt.getYesNo(this.getName());

		this.response = strLetter != null && (strLetter == 'y' || strLetter == 'Y');
	}

	public JPanel getPanel()
	{
		throw new RuntimeException("Not yet implemented");
	}
}