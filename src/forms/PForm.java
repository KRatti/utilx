/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx.forms;

import java.util.ArrayList;

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
		// TODO: write the code to show the form (either with a dialog or CLI)
	}
}