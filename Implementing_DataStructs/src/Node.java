/**
 * A class that represents a node to be used in a linked list.
 * These nodes are singly linked.
 *
 * @author Mike Scott
 * @version July 27, 2005
 */

 public class Node<E extends Comparable<E>> {

	 // instance variables

	// the data to store in this node
	private E myData;

	// the link to the next node (presumably in a list)
	private Node<E> myNext;

	/**
	 * default constructor
	 * pre: none<br>
	 * post: getData() = null, getNext() = null
	 */
	public Node() {	this(null, null); }

	/**
	 * create a ListNode that holds the specified data and refers to the specified next element
	 * pre: none<br>
	 * post: getData() = item, getNext() = next
	 * @param item the  data this ListNode should hold
	 * @param next the next node in the list
	 */
	public Node(E data, Node<E> next) {	
		myData = data;
		myNext = next;
	}

	
	/**
	 * return the data in this node
	 * pre: none<br>
	 * @return the data this ListNode holds
	 */
	public E getData()
	{	return myData;	}

	
	/**
	 * return the ListNode this ListNode refers to
	 * pre: none<br>
	 * @return the ListNode this ListNode refers to (normally the next one in a list)
	 */
	public Node<E> getNext()
	{	return myNext;	}


	/**
	 * set the data in this node
	 * The old data is over written.<br>
	 * pre: none<br>
	 * @param data the new data for this ListNode to hold
	 */
	public void setData(E data)
	{	myData = data;	}

	/**
	 * set the next node this ListNode refers to
	 * pre: none<br>
	 * @param next the next node this ListNode should refer to
	 */
	public void setNext(Node<E> next)
	{	myNext = next;	}
 }
