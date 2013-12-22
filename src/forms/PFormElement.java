/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx.forms;

/** The base class for all elements in a <code>PForm</code> */
public class PFormElement
{
	private final String name;
	private final String text;

	public PForm(String strName)
	{
		super(strName, strName);
	}

	public PForm(String strName, String strText)
	{
		this.name = strName;
		this.text = strText;
		this.elements = new ArrayList<>();
	}

	public String getName()
	{
		return this.name;
	}

	public String getText()
	{
		return this.text;
	}

	public boolean isInputValid()
	{
		return true;
	}
}