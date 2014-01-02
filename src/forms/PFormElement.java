/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx.forms;

import javax.swing.JPanel;

/** The base class for all elements in a <code>PForm</code> */
public abstract class PFormElement
{
	private final String name;
	private PForm parent;

	public PFormElement(String strName)
	{
		this.name = strName;
		this.parent = null;
	}

	public final String getName()
	{
		return this.name;
	}

	public final void setParent(PForm objParent)
	{
		this.parent = objParent;
	}

	public final PForm getParent()
	{
		return this.parent;
	}

	public abstract void validateInput();

	public abstract void show();
	public abstract JPanel getPanel();
}