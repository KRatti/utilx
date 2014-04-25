package utilx.io;

import java.io.Console;
import java.io.IOError;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Kyle
 * @version 1.0, 4/25/2014
 */
public class ConsoleIO {
	/**
	 * The Scanner object to use
	 */
	private static final Scanner inputScanner = new Scanner(System.in);
	/**
	 * The Console object to use
	 */
	private static final Console inputConsole = System.console();
	/**
	 * Should user input be shown?
	 */
	private static boolean showInput = true;

	/**
	 * Print an empty line
	 */
	public static void println() {
		System.out.println();
	}

	/**
	 * Print an Object
	 * @param objData The Object to print
	 */
	public static void println(Object objData) {
		System.out.println(objData);
	}

	/**
	 * Print an empty line to the error stream
	 */
	public static void errorln() {
		System.err.println();
	}

	/**
	 * Print an Object to the error stream
	 * @param objData The Object to print
	 */
	public static void errorln(Object objData) {
		System.err.println(objData);
	}

	public static void setShowInput(boolean bShow) {
		ConsoleIO.showInput = bShow;
	}

	public static boolean getShowInput() {
		return ConsoleIO.showInput;
	}

	/*
	* TODO
	*   - getInt
	 */

	public static String getString() throws NoSuchElementException, IllegalStateException, IOError {
		String strInput;

		if(ConsoleIO.getShowInput())
			strInput = ConsoleIO.inputScanner.nextLine();
		else
			strInput = new String(ConsoleIO.inputConsole.readPassword());

		if(strInput.length() <= 0)
			throw new NoSuchElementException();

		return strInput;
	}

	public static Character getChar() throws NoSuchElementException, IllegalStateException, IOError {
		String strInput;

		if(ConsoleIO.getShowInput())
			strInput = ConsoleIO.inputScanner.next();
		else
			strInput = new String(ConsoleIO.inputConsole.readPassword());

		if(strInput.length() <= 0)
			throw new NoSuchElementException();

		return strInput.charAt(0);
	}

	public static Double getDouble() throws NoSuchElementException, NumberFormatException, IllegalStateException, IOError {
		try {
			return Double.parseDouble(ConsoleIO.getString());
		} catch(NullPointerException e) {
			throw new NoSuchElementException();
		}
	}
}
