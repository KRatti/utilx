/**
* @author Kyle Ratti (PC18)
* @version 1.3, 12/5/13
*/

package utilx;

/** Sometimes it's true, sometimes it's false- ya never know */
public class Kinda
{
	/**
	* A 75% chance of being true
	*
	* @return true, if the odds are in your favor
	*/
	public static boolean trueish()
	{
		return Kinda.trueish(75);
	}

	/**
	* An x% chance of being true
	*
	* @param dChance The chance of being true (0.0-100.0)
	* @return true, if the odds are in your favor
	*/
	public static boolean trueish(double dChance)
	{
		return Numbers.clamp(dChance, 0.0, 100.0) >= (Math.random() * 100);
	}

	/**
	* A 75% chance of being false
	*
	* @return false, if the odds are in your favor
	*/
	public static boolean falseish()
	{
		return !Kinda.falseish(75);
	}

	/**
	* An x% chance of being true
	*
	* @param dChance The chance of being false (0.0-1.0)
	* @return false, if the odds are in your favor
	*/
	public static boolean falseish(double dChance)
	{
		return !Kinda.trueish(dChance);
	}
}