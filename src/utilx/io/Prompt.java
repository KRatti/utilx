package utilx.io;

import java.io.IOError;
import java.util.NoSuchElementException;

/**
 * @author Kyle
 * @version 1.0, 4/25/2014
 */
public class Prompt {
	/**
	 * The version of Prompt
	 */
	private static final double VERSION = 4.0;

	/**
	 * Get the version of Prompt
	 * @return The version of Prompt
	 */
	public double getVersion() {
		return Prompt.VERSION;
	}

	/**
	 * Get a String from the user
	 * @param strPrompt The message to prompt the user with
	 * @return The user's response, or null if they entered nothing
	 * @throws NoSuchElementException
	 */
	public static String getString(String strPrompt) throws NoSuchElementException {
		ConsoleIO.println(strPrompt);

		String strInput = null;

		try {
			strInput = ConsoleIO.getString();
		} catch(IllegalStateException|IOError e) {
			ConsoleIO.errorln("Error reading string: " + e.getMessage());
		}

		return strInput;
	}
}
