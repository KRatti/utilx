package utilx;

/**
 * @author Kyle
 * @version 1.0, 4/25/2014
 */
public class Strings {
	/**
	 * Returns a String with the proper ending depending on the specified number
	 * @param strInput The String to handle
	 * @param iAmount The number
	 * @return The new String
	 */
	public static String singularPlural(String strInput, int iAmount)
	{
		return iAmount != 1 ? (strInput + "s") : strInput;
	}
}
