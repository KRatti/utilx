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

	public abstract String getText()
	{
		return this.text;
	}

	public final PForm getParent()
	{
		return this.parent;
	}

	public boolean isInputValid()
	{
		return true;
	}
}