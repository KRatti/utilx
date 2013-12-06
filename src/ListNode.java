/**
* @author Kyle Ratti (PC18)
* @version 1.0, 11/13/13
*/

package utilx;

/** A node in a linked list */
public class ListNode
{
	private Object value;
	private ListNode next;

	/**
	* Creates a new list node with the specified value
	*
	* @param obj The value the node should hold
	*/
	public ListNode(Object obj)
	{
		this(obj, null);
	}

	/**
	* Creates a new list node with the specified value and next node
	*
	* @param obj The value the node should hold
	* @param objNext The next ListNode
	*/
	public ListNode(Object obj, ListNode objNext)
	{
		this.value = obj;
		this.next = objNext;
	}

	/**
	* Gets the value this ListNode holds
	*
	* @return The value
	*/
	public Object getValue()
	{
		return this.value;
	}

	/**
	* Gets the value this ListNode holds
	*
	* @return The value
	*/
	public Object getElement()
	{
		return this.getValue();
	}

	/**
	* Gets the next ListNode
	*
	* @return The next ListNode
	*/
	public ListNode getNext()
	{
		return this.next;
	}

	/**
	* Sets the value of this ListNode
	*
	* @param objNew The new value
	*/
	public void setValue(Object objNew)
	{
		this.value = objNew;
	}

	/**
	* Sets the value of this ListNode
	*
	* @param objNew The new value
	*/
	public void setElement(Object objNew)
	{
		this.setValue(objNew);
	}

	/**
	* Sets the next ListNode
	*
	* @param objNext The next ListNode
	*/
	public void setNext(ListNode objNext)
	{
		this.next = objNext;
	}
}