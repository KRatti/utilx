/**
* @author Kyle Ratti (PC18)
* @version 1.0, 12/06/13
*/

package utilx;

import java.awt.Color;

/** Allows for quick access to frequency used math methods */
public class Random
{
	private static final java.util.Random random = new java.util.Random();
	
	/**
	* Gets a random color
	*
	* @return A random <code>Color</code>
	*/
	public static Color nextColor()
	{
		return new Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256));
	}
	
	/**
	* Gets a random integer between 0 and iMax (exclusive)
	*
	* @param iMax The maximum integer
	* @return A random int
	*/
	public static int nextInt(int iMax)
	{
		return Random.nextInt(null, iMax);
	}

	/**
	* Get a random integer between iMin and iMax (exclusive)
	*
	* @param iMin The minimum integer
	* @param iMax The maximum integer
	* @return A random int
	*/
	public static int nextInt(Integer iMin, int iMax)
	{
		int iNum = Random.random.nextInt(iMax);

		if(iMin != null)
			iNum += iMin;

		return iNum;
	}
}
