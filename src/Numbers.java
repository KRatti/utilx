/**
* @author Kyle Ratti (PC18)
* @version 1.5, 11/12/13
*/

package utilx;

import java.text.NumberFormat;

/** Allows for quick access to frequency used math methods */
public class Numbers
{
	private static final NumberFormat CUR_FORMAT = NumberFormat.getCurrencyInstance();
	private static final double TOLERANCE = 0.0000001;

	/**
	* Clamps a double value
	*
	* @param dValue The value to clamp
	* @param dMin The minimum value allowed
	* @return The clamped double
	*/
	public static double clamp(double dValue, double dMin)
	{
		return Numbers.clamp(dValue, dMin, null);
	}

	/**
	* Clamps a double value
	*
	* @param dValue The value to clamp
	* @param dMin The minimum value allowed
	* @param dMax The maximum value allowed
	* @return The clamped double
	*/
	public static double clamp(double dValue, double dMin, Double dMax)
	{
		if(dValue < dMin)
		{
			return dMin;
		}
		else if(dMax != null && dValue > dMax)
		{
			return dMax;
		}

		return dValue;
	}

	/**
	* Clamps an int value
	*
	* @param iValue The value to clamp
	* @param iMin The minimum value allowed
	* @return The clamped int
	*/
	public static int clamp(int iValue, int iMin)
	{
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
	public static int clamp(int iValue, int iMin, int iMax)
	{
		if(iValue < iMin)
		{
			return iMin;
		}
		else if(iValue > iMax)
		{
			return iMax;
		}

		return iValue;
	}

	/**
	* Rounds a double
	*
	* @param dValue The double value to round
	* @param iPlaces The number of decimal places to round to
	* @return The rounded double
	*/
	public static double round(double dValue, int iPlaces)
	{
		iPlaces = Numbers.clamp(Math.abs(iPlaces), 1);

		return (Math.round((dValue * (Math.pow(10, iPlaces)))) / Math.pow(10, iPlaces));
	}

	/**
	* Rounds an int to the nearest 10th (34 => 30, 38 => 40)
	*
	* @param iValue The int value to round
	* @return The rounded int
	*/
	public static int round(int iValue)
	{
		int iRemainder = iValue % 10;

		if(Math.abs(iRemainder) >= 5)
		{
			return iValue + iRemainder;
		}

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
	public static boolean isInBounds(double dValue, double dMin, double dMax)
	{
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
	public static boolean isInBounds(int iValue, int iMin, int iMax)
	{
		return iValue >= iMin && iValue <= iMax;
	}

	/**
	* Checks if an int is prime
	*
	* @param iValue The int to check
	* @return true if the number is prime
	*/
	public static boolean isPrime(int iValue)
	{
		if(iValue <= 1 || iValue % 2 == 0)
		{
			return false;
		}
		else if(iValue == 2)
		{
			return true;
		}
		
		int iSqrt = (int) Math.sqrt(iValue);

		for(int i = 3; i < iSqrt; i += 2)
		{
			if(iValue % i == 0)
			{
				return false;
			}
		}

		return true;
	}

	/**
	* Checks if an int is a super prime (all digits in the number are prime)
	*
	* @param iValue The int to check
	* @return true if the number is a super prime
	*/
	public static boolean isSuperPrime(int iValue)
	{
		for(int i = iValue; i > 10; i /= 10)
		{
			if(!Numbers.isPrime(i))
			{
				return false;
			}
		}

		return true;
	}

	/**
	* Determines if two doubles are equal
	*
	* @param dValue The bigger of the two values
	* @param dValue2 The double to check against
	* @return true if the doubles are within the tolerance of each other
	*/
	public static boolean isEqual(double dValue, double dValue2)
	{
		return dValue - dValue2 <= Numbers.TOLERANCE;
	}

	/**
	* Format a double as currency
	*
	* @param dValue The value to format
	* @return A formatted String with the currency
	*/
	public static String formatCurrency(double dValue)
	{
		return Numbers.CUR_FORMAT.format(dValue);
	}
}
