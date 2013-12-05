/**
* @author Kyle Ratti (PC18)
* @version 1.0, 11/20/13
*/

package utilx;

/** Provides an overlay for java.util.ArrayList, adding useful utility methods that aren't there by default */
public class ArrayList<T> extends java.util.ArrayList<T>
{
	/**
	* Adds data to an ArrayList
	*
	* @param args The data to add to the ArrayList
	*/
	public void add(T... args)
	{
		for(int i = 0; i < args.length; i++)
		{
			this.add(args[i]);
		}
	}

	/**
	* Adds data from an array to the ArrayList
	*
	* @param objData The array of data to add
	*/
	public void addArray(T[] objData)
	{
		for(int i = 0; i < objData.length; i++)
		{
			this.add(objData[i]);
		}
	}
}