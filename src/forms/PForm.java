/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx.forms;

import java.util.ArrayList;

import utilx.Prompt;

/** The base class for adding other form elements to */
public class PForm
{
	private final String name;
	private final ArrayList<PFormElement> elements;

	public PForm(String strName)
	{
		this.name = strName;
		this.elements = new ArrayList<>();
	}

	public String getName()
	{
		return this.name;
	}

	public ArrayList<PFormElement> getElements()
	{
		return this.elements;
	}

	public void show()
	{
		if(this.elements.size() <= 0)
		{
			System.out.println("Tried showing form '" + this.getName() + "' with no elements!");
			return;
		}

		// TODO: show the CLI version of the form
	}

	public void showDialog()
	{
		if(this.elements.size() <= 0)
		{
			Prompt.showError("Tried showing form '" + this.getName() + "' with no elements!");
			return;
		}

		// TODO: show the dialog version of the form
	}
}