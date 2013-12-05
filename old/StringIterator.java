/**
* @author Kyle Ratti (PC18)
* @version 1.0, 11/20/13
*/

package utilx;

import java.util.Iterator;

/** Provides quick methods for iterating over a string */
public class StringIterator<E> implements Iterator
{
	private final char delimiter;
	private final String value;
	private final String[] data;
	private int index = 0;

	/**
	* Creates a new StringIterator with the specified value and delimiter
	*
	* @param strValue The String to iterate over
	*/
	public StringIterator(String strValue)
	{
		this(strValue, ' ');
	}

	/**
	* Creates a new StringIterator with the specified value
	*
	* @param strValue The String to iterate over
	* @param strDelimiter The delimiter to use
	*/
	public StringIterator(String strValue, char strDelimiter)
	{
		this.value = strValue;
		this.delimiter = strDelimiter;
		
		this.data = this.value.split(Character.toString(this.delimiter));
	}

	/** Unsupported */
	public void remove()
	{
		throw new UnsupportedOperationException();
	}

	/**
	* Gets the next element in the iteration
	*
	* @return The next element, <code>E</code>, in the iteration
	*/
	@SuppressWarnings("unchecked")
	public E next()
	{
		E objTemp = (E) this.data[this.index];
		this.index++;

		return objTemp;
	}

	/**
	* Checks if the iteration has more elements
	*
	* @return <code>true</code> if the iteration has more elements
	*/
	public boolean hasNext()
	{
		return this.index < this.data.length;
	}
}