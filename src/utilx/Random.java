/**
* @author Kyle Ratti
* @version 1.0, 07/11/14
*/

package utilx;

import java.awt.Color;

/** Allows for quick access to frequency used math methods */
public class Random {
	private static final java.util.Random random = new java.util.Random();
	
	/**
	* Gets a random color
	*
	* @return A random <code>Color</code>
	*/
	public static Color nextColor() {
		return new Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256));
	}
	
	/**
	* Gets a random integer between 0 and iMax (exclusive)
	*
	* @param iMax The maximum integer
	* @return A random int
	*/
	public static int nextInt(int iMax) {
		return Random.nextInt(null, iMax);
	}

	/**
	* Get a random integer between iMin and iMax (exclusive)
	*
	* @param iMin The minimum integer
	* @param iMax The maximum integer
	* @return A random int
	*/
	public static int nextInt(Integer iMin, int iMax) {
		int iNum = Random.random.nextInt(iMax);

		if(iMin != null)
			iNum += iMin;

		return iNum;
	}
	
	/**
	* Gets a boolean (with a 50% chance of being <code>true</code>)
	*
	* @return <code>true</code> if the odds are in your favor
	*/
	public static boolean nextBoolean() {
		return Random.nextBoolean(50.0);
	}
	
	/**
	* Gets a boolean with the specified chance of being true
	*
	* @param dChance The chance of being <code>true</code> (0.0-100.0)
	* @return <code>true</code> if the odds are in your favor
	*/
	public static boolean nextBoolean(double dChance) {
		return Numbers.clamp(dChance, 0.0, 100.0) >= (Math.random() * 100);
	}
}
