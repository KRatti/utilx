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
	private boolean dialogs = false;

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

	public void setUseDialogs(boolean bUseDialogs)
	{
		this.dialogs = bUseDialogs;
	}

	public boolean getUseDialogs()
	{
		return this.dialogs;
	}

	public void show()
	{
		if(this.elements.size() <= 0)
		{
			System.out.println("Tried showing form '" + this.getName() + "' with no elements!");
			return;
		}
	}
}