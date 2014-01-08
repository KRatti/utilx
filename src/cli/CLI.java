/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/21/13
*/

package utilx.cli;

import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

import utilx.cli.*;

import utilx.Prompt;

/** An easy-to-use class for implementing otherwise complicated CLIs */
public class CLI
{
	private final String name;
	private final TreeMap<String, CLICommand> commands;
	private boolean running = false;

	/**
	* Creates a new CLI with the specified name
	*
	* @param strName The name to use
	*/
	public CLI(String strName)
	{
		this.name = strName;
		this.commands = new TreeMap<String, CLICommand>();

		this.addCommand(new CLICommand("help", "Get help")
		{
			@Override
			public void handle(String strCmd, String[] arrArgs)
			{
				Prompt.println("COMMAND\t\tINFORMATION\n========\t===========\n");
				Iterator it = CLI.this.commands.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry objEntry = (Map.Entry) it.next();
					String strKey = (String) objEntry.getKey();
					CLICommand objCmd = (CLICommand) objEntry.getValue();
					
					Prompt.println("%s\t\t%s", objCmd.getCommand(), objCmd.getInfo());
				}
			}
		});
	}

	/**
	* Adds a new command to this CLI
	*
	* @param objCmd The command to add
	*/
	public void addCommand(CLICommand objCmd)
	{
		this.commands.put(objCmd.getCommand(), objCmd);
	}

	/**
	* Checks if the specified command exists
	*
	* @param strCmd The command to check
	* @return <code>true</code> if the command exists
	*/
	public boolean hasCommand(String strCmd)
	{
		return this.commands.containsKey(strCmd);
	}

	/** Starts the CLI */
	public void start()
	{
		this.running = true;

		Prompt.clearScreen();
		Prompt.println(this.name);

		while(this.running)
			this.process();
	}

	private void process()
	{
		boolean bUseDialogs = Prompt.getUseDialogs();
		Prompt.setUseDialogs(false);

		String strInput = Prompt.getString("");

		if(strInput == null || strInput.length() == 0)
		{
			this.postProcess(bUseDialogs);
			return;
		}

		strInput = strInput.trim();

		String strCmd = strInput;
		String[] arrArgs = null;
		int iIndex = strInput.indexOf(" ");

		if(iIndex != -1)
		{
			strCmd = strInput.substring(0, iIndex);
			arrArgs = strInput.substring(iIndex+1).split(" ");
		}

		if(this.hasCommand(strCmd))
		{
			CLICommand objCmd = this.commands.get(strCmd);

			try
			{
				objCmd.process(strCmd, arrArgs);
			}
			catch(InvalidUsageException e)
			{
				Prompt.showError("Error: %s", e.getMessage());
			}
		}
		else
			Prompt.showError("Unknown cmd '%s'", strCmd);

		this.postProcess(bUseDialogs);
	}

	private void postProcess(boolean bUseDialogs)
	{
		Prompt.setUseDialogs(bUseDialogs);
	}
}