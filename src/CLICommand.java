/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/21/13
*/

package utilx;

import java.util.TreeMap;

import utilx.InvalidUsageException;
import utilx.CLIArgument;

/** A command for the CLI class */
public class CLICommand
{
	private final String command;
	private final String info;
	private final TreeMap<String, CLIArgument> arguments;

	public CLICommand(String strCmd, String strInfo)
	{
		this.command = strCmd;
		this.info = strInfo;
		this.arguments = new TreeMap<String, CLIArgument>();
	}

	/**
	* Gets the command name
	*
	* @return The command name
	*/
	public String getCommand()
	{
		return this.command;
	}

	public String getInfo()
	{
		return this.info;
	}

	public void addArgument(CLIArgument objArg)
	{
		this.arguments.put(objArg.getArgument(), objArg);
	}

	public boolean hasArguments()
	{
		return this.arguments.size() > 0;
	}

	public boolean hasArgument(String strArg)
	{
		return this.arguments.containsKey(strArg);
	}

	public CLIArgument getArgument(String strArg)
	{
		if(!this.hasArgument(strArg)) return null;

		return this.arguments.get(strArg);
	}

	public void process(String strCmd, String[] arrArgs) throws InvalidUsageException
	{
		if(this.hasArguments())
		{
			if(arrArgs != null && arrArgs.length >= 1)
			{
				String strArg = arrArgs[0];

				if(this.hasArgument(strArg))
				{
					String[] arrNewArgs = new String[arrArgs.length-1];

					for(int i = 1; i < arrArgs.length; i++)
					{
						arrNewArgs[i-1] = arrArgs[i];
					}

					this.getArgument(strArg).handle(strCmd, strArg, arrNewArgs);
					return;
				}
				else
					throw new InvalidUsageException(String.format("Unknown argument '%s'", strArg));
			}
			else
				throw new InvalidUsageException("Expected an argument");
		}

		this.handle(strCmd, arrArgs);
	}

	public void handle(String strCmd, String[] arrArgs) throws InvalidUsageException {}
}