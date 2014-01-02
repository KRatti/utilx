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
		this.elements = new ArrayList<PFormElement>();
	}

	public String getName()
	{
		return this.name;
	}

	public ArrayList<PFormElement> getElements()
	{
		return this.elements;
	}

	public void add(PFormElement objElement)
	{
		this.elements.add(objElement);
		objElement.setParent(this);
	}

	public void show()
	{
		if(this.elements.size() <= 0)
		{
			System.out.println("Tried showing form '" + this.getName() + "' with no elements!");
			return;
		}

		for(PFormElement objElement : this.elements)
		{
			try
			{
				objElement.preShow();
				objElement.show();
				objElement.postShow();
			}
			catch(InputCanceledException e)
			{
				if(objElement.onInputCanceled())
					break;
			}
		}
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