/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx.forms;

/** The base class for all elements in a <code>PForm</code> */
public abstract class PFormElement
{
	private final String name;
	private PForm parent;

	public PFormElement(String strName)
	{
		this.name = strName;
	}

	public final String getName()
	{
		return this.name;
	}

	public abstract String getText();

	public final void setParent(PForm objParent)
	{
		this.parent = objParent;
	}

	public final PForm getParent()
	{
		return this.parent;
	}

	public void validateInput() throws InvalidInputException {}

	public void preShow() {}
	public void postShow() {}
	public boolean onInputCanceled() { return false; }

	public abstract void show();
	public abstract void showDialog();
}