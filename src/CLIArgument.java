/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/22/13
*/

package utilx;

import utilx.InvalidUsageException;

/** A command for the CLI class */
public class CLIArgument
{
	private final String argument;
	private final String info;

	public CLIArgument(String strArg, String strInfo)
	{
		this.argument = strArg;
		this.info = strInfo;
	}

	/**
	* Gets the argument name
	*
	* @return The argument name
	*/
	public String getArgument()
	{
		return this.argument;
	}

	public String getInfo()
	{
		return this.info;
	}

	public void handle(String strCmd, String strArg, String[] arrArgs) throws InvalidUsageException {}
}