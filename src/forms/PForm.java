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
	private boolean running;

	public PForm(String strName)
	{
		this.name = strName;
		this.elements = new ArrayList<PFormElement>();
		this.running = false;
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

		this.running = true;

		for(PFormElement objElement : this.elements)
		{
			if(!this.running) break;

			boolean bValid = false;

			while(!bValid)
			{
				try
				{
					objElement.show();
					objElement.validateInput();
					bValid = true;
				}
				catch(InputCanceledException e)
				{
					System.out.println("Canceled: " + e.getMessage());
					this.stop();
				}
				catch(InvalidInputException e)
				{
					System.out.println("Error: " + e.getMessage());
				}
				catch(InputException e)
				{
					System.out.println("General Error: " + e.getMessage());
				}
			}
		}

		this.running = false;
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

	public final boolean isRunning()
	{
		return this.running;
	}

	public final void stop()
	{
		this.running = false;
	}
}