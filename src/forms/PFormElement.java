/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx.forms;

/** The base class for all elements in a <code>PForm</code> */
public abstract class PFormElement
{
	private final String name;
	private final PForm parent;

	public PFormElement(String strName, PForm objParent)
	{
		this.name = strName;
		this.parent = objParent;
	}

	public final String getName()
	{
		return this.name;
	}

	public abstract String getText();

	public final PForm getParent()
	{
		return this.parent;
	}

	public void validateInput() throws InvalidInputException {}

	public abstract void show();
	public abstract void showDialog();
}