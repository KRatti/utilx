/**
* @author Kyle Ratti
* @version 1.5, 07/11/14
*/

package me.ratti.kyle.utilx;

import java.text.NumberFormat;

/** Allows for quick access to frequency used math methods */
public class Numbers {
	public static final double TOLERANCE = 0.0000001;

	private static final NumberFormat CUR_FORMAT = NumberFormat.getCurrencyInstance();

	/**
	* Clamps a double value
	*
	* @param dValue The value to clamp
	* @param dMin The minimum value allowed
	* @return The clamped double
	*/
	public static double clamp(double dValue, double dMin) {
		return clamp(dValue, dMin, null);
	}

	/**
	* Clamps a double value
	*
	* @param dValue The value to clamp
	* @param dMin The minimum value allowed
	* @param dMax The maximum value allowed
	* @return The clamped double
	*/
	public static double clamp(double dValue, double dMin, Double dMax) {
		if(dValue < dMin)
			return dMin;
		else if(dMax != null && dValue > dMax)
			return dMax;

		return dValue;
	}

	/**
	* Clamps an int value
	*
	* @param iValue The value to clamp
	* @param iMin The minimum value allowed
	* @return The clamped int
	*/
	public static int clamp(int iValue, int iMin) {
		return (iValue < iMin ? iMin : iValue);
	}

	/**
	* Clamps an int value
	*
	* @param iValue The value to clamp
	* @param iMin The minimum value allowed
	* @param iMax The maximum value allowed
	* @return The clamped int
	*/
	public static int clamp(int iValue, int iMin, int iMax) {
		if(iValue < iMin)
			return iMin;
		else if(iValue > iMax)
			return iMax;

		return iValue;
	}

	/**
	* Rounds a double
	*
	* @param dValue The double value to round
	* @param iPlaces The number of decimal places to round to
	* @return The rounded double
	*/
	public static double round(double dValue, int iPlaces) {
		iPlaces = clamp(Math.abs(iPlaces), 1);

		return Math.round((dValue * (Math.pow(10, iPlaces)))) / Math.pow(10, iPlaces);
	}

	/**
	* Rounds an int to the nearest 10th (34 => 30, 38 => 40)
	*
	* @param iValue The int value to round
	* @return The rounded int
	*/
	public static int round(int iValue) {
		int iRemainder = iValue % 10;

		if(Math.abs(iRemainder) >= 5)
			return iValue + iRemainder;

		return iValue - iRemainder;
	}

	/**
	* Checks if a double is in the specified bounds
	*
	* @param dValue The double to check
	* @param dMin The minimum value allowed
	* @param dMax The maximum value allowed
	* @return true if dValue is between dMin and dMax
	*/
	public static boolean isInBounds(double dValue, double dMin, double dMax) {
		return dValue >= dMin && dValue <= dMax;
	}

	/**
	* Checks if an int is in the specified bounds
	*
	* @param iValue The int to check
	* @param iMin The minimum value allowed
	* @param iMax The maximum value allowed
	* @return true if iValue is between iMin and iMax
	*/
	public static boolean isInBounds(int iValue, int iMin, int iMax) {
		return iValue >= iMin && iValue <= iMax;
	}

	/**
	* Determines if two doubles are equal using the default tolerance
	* @param dValue The first value
	* @param dValue2 The second value
	* @return true if the doubles are within the tolerance of each other
	*/
	public static boolean isEqual(double dValue, double dValue2) {
		return isEqual(dValue, dValue2, TOLERANCE);
	}

	/**
	 * Determines if two doubles are equal
	 * @param dValue The first value
	 * @param dValue2 The second value
	 * @param dTolerance The tolerance to determine equality with
	 * @return true if the provided values are within the specified tolerance
	 */
	public static boolean isEqual(double dValue, double dValue2, double dTolerance) {
		return dValue - dValue2 <= dTolerance;
	}

	/**
	* Format a double as currency
	*
	* @param dValue The value to format
	* @return A formatted String with the currency
	*/
	public static String formatCurrency(double dValue) {
		return CUR_FORMAT.format(dValue);
	}
}
