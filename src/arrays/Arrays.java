/**
* @author Kyle Ratti (PC18)
* @version 1.0, 11/14/13
*/

package utilx.arrays;

import java.util.ArrayList;

/** Quick methods for dealing with arrays */
public class Arrays
{
	/**
	* Chooses a random element from an array
	*
	* @param objData The data
	* @return A random <code>Object</code> in the array
	*/
	public static Object random(Object[] objData)
	{
		return objData[Numbers.randInt(0, objData.length)];
	}

	/**
	* Chooses a random element from an ArrayList
	*
	* @param objData The ArrayList
	* @return A random <code>Object</code> in the ArrayList
	*/
	public static Object random(ArrayList<Object> objData)
	{
		return objData.get(Numbers.randInt(0, objData.size()));
	}

	/**
	* Checks if an array contains an element
	*
	* @param objData The array to check
	* @param objValue The value to check for in the array
	* @return <code>true</code> if the value is in the array
	*/
	public static boolean contains(Object[] objData, Object objValue)
	{
		for(int i = 0; i < objData.length; i++)
		{
			if(objData[i].equals(objValue))
			{
				return true;
			}
		}

		return false;
	}
}