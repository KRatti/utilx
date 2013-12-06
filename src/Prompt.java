/**
* @author	Kyle Ratti
* @version	3.1, 12/06/13
*/

package utilx;

import java.util.Scanner;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
* Allows easy prompting and data type verification for user input<br/>
* <h2>Examples</h2>
* Integer iValue = Prompt.getInt("Enter a number between 0 and 50", 0, 50);<br/>
* // iValue is now an Integer between 0 and 50 (or null if using dialogs and the user canceled)<br/>
* <br/>
* String strName = Prompt.getString("Enter your name: ");<br/>
* // strName is now a String (or null if using dialogs and the user canceled)
* <h2>New in 3.1</h2>
* <ul>
*	<li>Renamed Prompt.setAllowNull(bAllow) to Prompt.setAllowNullInput(bAllow)</li>
	<li>Renamed Prompt.getAllowNull() to Prompt.getAllowNullInput()</li>
* </ul>
*/
public class Prompt
{
	/** The current version of Prompt */
	public static final double VERSION = 3.1;
	
	/** The scanner object used for command line input */
	private static final Scanner scanner = new Scanner(System.in);
	/** A character array of user input that sets acceptable input for Prompt.getYesNo(...) */
	private static final char[] yesNo = {'y', 'Y', 'n', 'N'};
	/** A character array of user input that sets acceptable input for Prompt.getYesNoCancel(...) */
	private static final char[] yesNoCancel = {'y', 'Y', 'n', 'N', 'c', 'C'};
	/** A boolean that determines if dialog boxes should be used when prompting the user */
	private static boolean dialogs = false;
	/** A boolean that determines if input methods should return null if nothing is entered on the command line */
	private static boolean allowNullInput = false;
	
	/**
	* Converts a character array to a formatted string
	*
	* @param arrValid The character array to format
	* @return A formatted String (ie: "y, n, t, f")
	*/
	private static String arrToStr(char[] arrValid)
	{
		StringBuilder objOutput = new StringBuilder(arrValid.length + (arrValid.length * 2));
		
		for(int i = 0; i < arrValid.length; i++)
		{
			objOutput.append(arrValid[i]);
			
			if(i < arrValid.length - 1)
				objOutput.append(", ");
		}
		
		return objOutput.toString();
	}

	/**
	* Sets the use of dialog boxes in prompts
	*
	* @param bDialogs Should dialog boxes be used
	*/
	public static void setUseDialogs(boolean bDialogs)
	{
		Prompt.dialogs = bDialogs;
	}

	/**
	* Determines if dialog boxes are being used for prompts
	*
	* @return <code>true</code> if dialogs are being used
	*/
	public static boolean getUseDialogs()
	{
		return Prompt.dialogs;
	}

	/**
	* Allows or disallows input methods to return null when nothing is entered on the command line
	*
	* @param bAllow Should input methods allow empty inputs
	*/
	public static void setAllowNullInput(boolean bAllow)
	{
		Prompt.allowNullInput = bAllow;
	}

	/**
	* Determines if null input is allowed for command-line prompts
	*
	* @return <code>true</code> if null input is allowed
	*/
	public static boolean getAllowNullInput()
	{
		return Prompt.allowNullInput;
	}

	/** Terminates the current line by writing the line separator string */
	public static void println()
	{
		Prompt.print('\n');
	}

	/**
	* Prints a string formatted with the specified data and terminates the line
	*
	* @param strMsg The message to format
	* @param args The data to format the message with
	*/
	public static void println(String strMsg, Object... args)
	{
		Prompt.println(String.format(strMsg, args));
	}

	/**
	* Prints the data and terminates the line
	*
	* @param objData The data to print
	*/
	public static void println(Object objData)
	{
		System.out.println(objData);
	}


	/**
	* Prints a string formatted with the specified data
	*
	* @param strMsg The message to format
	* @param args The data to format the message with
	*/
	public static void print(String strMsg, Object... args)
	{
		Prompt.print(String.format(strMsg, args));
	}

	/**
	* Prints the data
	*
	* @param objData The data to print
	*/
	public static void print(Object objData)
	{
		System.out.print(objData);
	}

	
	/**
	* Gets a string from the user
	*
	* @param strMsg The message to prompt with
	* @return The user's response, a <code>String</code>, or <code>null</code> if the prompt was canceled
	*/
	public static String getString(String strMsg)
	{
		return Prompt.getString(strMsg, null, null);
	}
	
	/**
	* Gets a minimum length string from the user
	*
	* @param strMsg The message to prompt with
	* @param iMin The minimum length of the response
	* @return The user's response, a <code>String</code>, or <code>null</code> if the prompt was canceled
	*/
	public static String getString(String strMsg, Integer iMin)
	{
		return Prompt.getString(strMsg, iMin, null);
	}
	
	/**
	* Gets a minimum &amp; maximum length string from the user
	*
	* @param strMsg The message to prompt with
	* @param iMin The minimum length of the response
	* @param iMax The maximum length of the response
	* @return The user's response, a <code>String</code>, or <code>null</code> if the prompt was canceled
	*/
	public static String getString(String strMsg, Integer iMin, Integer iMax)
	{
		String strResponse = null;
		boolean bValid = false;
		
		while(!bValid)
		{
			if(Prompt.dialogs)
				strResponse = JOptionPane.showInputDialog(null, strMsg, "Input", JOptionPane.QUESTION_MESSAGE);
			else
			{
				System.out.print(strMsg);
				strResponse = Prompt.scanner.nextLine();
			}
			
			if(strResponse == null || (Prompt.allowNullInput && strResponse.length() == 0))
				return null;
			
			int iLen = strResponse.length();
			
			if(iLen > 0)
			{
				bValid = true;
				
				if(iMin != null)
				{
					if(iLen < iMin)
					{
						Prompt.println("Expected a string >= %d character%s", iMin, (iMin != 1 ? "s" : ""));
						bValid = false;
					}
				}
				
				if(iMax != null)
				{
					if(iLen > iMax)
					{
						Prompt.println("Expected a string =< %d characters", iMax);
						bValid = false;
					}
				}
			}
			else
				Prompt.println("Expected a string to be inputted");
		}
		
		return strResponse;
	}
	
	/**
	* Gets a double from the user
	*
	* @param strMsg The message to prompt with
	* @return The user's response, a <code>Double</code>, or <code>null</code> if the prompt was canceled
	*/
	public static Double getDouble(String strMsg)
	{
		return Prompt.getDouble(strMsg, null, null);
	}
	
	/**
	* Gets a minimum size double from the user
	*
	* @param strMsg The message to prompt with
	* @param dMin The minimum size of the response (inclusive)
	* @return The user's response, a <code>Double</code>, or <code>null</code> if the prompt was canceled
	*/
	public static Double getDouble(String strMsg, Double dMin)
	{
		return Prompt.getDouble(strMsg, dMin, null);
	}
	
	/**
	* Gets a minimum &amp; maximum size double from the user
	*
	* @param strMsg The message to prompt with
	* @param dMin The minimum size of the response (inclusive)
	* @param dMax The maximum size of the response (inclusive)
	* @return The user's response, a <code>Double</code>, or <code>null</code> if the prompt was canceled
	*/
	public static Double getDouble(String strMsg, Double dMin, Double dMax)
	{
		Double dOutput = null;
		boolean bValid = false;
		
		String strResponse = null;
		
		while(!bValid)
		{
			if(Prompt.dialogs)
				strResponse = JOptionPane.showInputDialog(null, strMsg, "Input", JOptionPane.QUESTION_MESSAGE);
			else
			{
				System.out.print(strMsg);
				strResponse = Prompt.scanner.nextLine();
			}
			
			if(strResponse == null)
				return null;
			
			try
			{
				dOutput = Double.parseDouble(strResponse);
			}
			catch(NumberFormatException e)
			{
				Prompt.println("Expected a number as input");
			}
			
			if(dOutput != null)
			{
				bValid = true;
				
				if(dMin != null)
				{
					if(dOutput < dMin)
					{
						Prompt.println("Expected a number >= %f", dMin);
						bValid = false;
					}
				}
				
				if(dMax != null)
				{
					if(dOutput > dMax)
					{
						Prompt.println("Expected a number <= %f", dMax);
						bValid = false;
					}
				}
			}
		}
		
		return dOutput;
	}
	
	/**
	* Gets an integer from the user
	*
	* @param strMsg The message to prompt with
	* @return The user's response, an <code>Integer</code>, or <code>null</code> if the prompt was canceled
	*/
	public static Integer getInt(String strMsg)
	{
		return Prompt.getInt(strMsg, null, null);
	}
	
	/**
	* Gets a minimum size integer from the user
	*
	* @param strMsg The message to prompt with
	* @param iMin The minimum size of the response (inclusive)
	* @return The user's response, an <code>Integer</code>, or <code>null</code> if the prompt was canceled
	*/
	public static Integer getInt(String strMsg, Integer iMin)
	{
		return Prompt.getInt(strMsg, iMin, null);
	}
	
	/**
	* Gets a minimum &amp; maximum size integer from the user
	*
	* @param strMsg The message to prompt with
	* @param iMin The minimum size of the response (inclusive)
	* @param iMax The maximum size of the response (inclusive)
	* @return The user's response, an <code>Integer</code>, or <code>null</code> if the prompt was canceled
	*/
	public static Integer getInt(String strMsg, Integer iMin, Integer iMax)
	{
		Double dMin = null;
		Double dMax = null;
		
		if(iMin != null)
			dMin = new Double(iMin);
		
		if(iMax != null)
			dMax = new Double(iMax);
		
		Double dValue = Prompt.getDouble(strMsg, dMin, dMax);
		
		if(dValue == null)
			return null;
		
		return dValue.intValue();
	}
	
	/**
	* Gets a character from the user
	*
	* @param strMsg The message to prompt with
	* @return The user's response, a <code>Character</code>, or <code>null</code> if the prompt was canceled
	*/
	public static Character getChar(String strMsg)
	{
		return Prompt.getString(strMsg).charAt(0);
	}
	
	/**
	* Gets a whitelisted-character from the user
	*
	* @param strMsg The message to prompt with
	* @param arrValid A character array of valid responses
	* @return The user's response, a <code>Character</code>, or <code>null</code> if the prompt was canceled
	*/
	public static Character getChar(String strMsg, char[] arrValid)
	{
		String strResponse = null;
		Character strLetter = null;
		
		while(true)
		{
			strResponse = Prompt.getString(strMsg);
			
			if(strResponse == null)
				return null;
			
			strLetter = strResponse.charAt(0);
			
			for(int i = 0; i < arrValid.length; i++)
			{
				if(strLetter == arrValid[i])
					return strLetter;
			}
			
			Prompt.println("Expected one of the following: %s", Prompt.arrToStr(arrValid));
		}
	}
	
	/**
	* Gets 'y'/'n' from the user
	*
	* @param strMsg The message to prompt with
	* @return The user's response, a <code>Character</code> ('y'/'n'), or <code>null</code> if the prompt was canceled
	*/
	public static Character getYesNo(String strMsg)
	{
		if(Prompt.dialogs)
		{
			int iResponse = JOptionPane.showConfirmDialog(null, strMsg, "Confirmation", JOptionPane.YES_NO_OPTION);
			
			return (iResponse == JOptionPane.YES_OPTION) ? 'y' : 'n';
			
		}
		
		return Prompt.getChar(strMsg, Prompt.yesNo);
	}
	
	/**
	* Gets 'y', 'n', or 'c' from the user
	* 
	* @param strMsg The message to prompt with
	* @return The user's response, a <code>Character</code> ('y', 'n', or 'c'), or <code>null</code> if the prompt was canceled
	*/
	public static Character getYesNoCancel(String strMsg)
	{
		if(Prompt.dialogs)
		{
			int iResponse = JOptionPane.showConfirmDialog(null, strMsg, "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
			
			if(iResponse == JOptionPane.YES_OPTION)
				return 'y';
			else if(iResponse == JOptionPane.NO_OPTION)
				return 'n';
			else
				return 'c';
		}
		
		return Prompt.getChar(strMsg, Prompt.yesNoCancel);
	}

	/**
	* Gets a String matching the specified pattern
	*
	* @param strMsg The message to prompt with
	* @param strPattern The regular expression to which user input is matched
	* @return The user's response, a matched <code>String</code>, or <code>null</code> if the prompt was canceled
	*/
	public static String getMatch(String strMsg, String strPattern)
	{
		String strResponse = null;
		boolean bValid = false;

		while(!bValid)
		{
			strResponse = Prompt.getString(strMsg);

			bValid = strResponse.matches(strPattern);

			if(!bValid)
				Prompt.println("Didn't receive expected input");
		}
		
		return strResponse;	
	}

	/**
	* Shows a dialog box
	*
	* @param strMsg The message to show
	*/
	public static void showDialog(String strMsg)
	{
		if(Prompt.dialogs)
			JOptionPane.showMessageDialog(null, strMsg, "Information", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	* Shows an error dialog
	*
	* @param strMsg The message to show
	*/
	public static void showError(String strMsg)
	{
		if(Prompt.dialogs)
			JOptionPane.showMessageDialog(null, strMsg, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/** Prints some new lines to 'clear' the screen */
	public static void clearScreen()
	{
		for(int i = 0; i < 100; i++)
		{
			System.out.printf("%n");
		}
	}
}
