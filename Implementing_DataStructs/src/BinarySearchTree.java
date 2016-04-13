/*  Student information for assignment:
 *
 *  On my honor, Ahmed AlJehairan, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: aa29665
 *  email address: ahmed24633@gmail.com
 *  Grader name: Yuanzhong
 *  Number of slip days I am using:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Shell for a bianry search tree class.
 * 
 * @author scottm
 * 
 */

public class BinarySearchTree<E extends Comparable<? super E>> {

	private BSTNode<E> root;
	private int size;


	/**
	 * Add the specified item to this Binary Search Tree if it is not already
	 * present. <br>
	 * pre: <tt>value</tt> != null<br>
	 * post: Add value to this tree if not already present. Return true if this
	 * tree changed as a result of this method call, false otherwise.
	 * 
	 * @param value
	 *            the value to add to the tree
	 * @return false if an item equivalent to value is already present in the
	 *         tree, return true if value is added to the tree and size() = old
	 *         size() + 1 (Reverted to class notes to fix problems.)
	 */
	public boolean add(E value) { // DONE! O(LogN)
		int oldSize = size;
		setRoot(addHelper(getRoot(), value));
		return size != oldSize;
	}

	private BSTNode<E> addHelper(BSTNode<E> node, E value) {
		// base case
		if (node == null) {
			size++;
			return new BSTNode<E>(null, value, null);
			// recursion
		} else {

			int dir = value.compareTo(node.getData());

			if (dir < 0) {
				node.setLeft(addHelper(node.getLeft(), value));

			} else if (dir > 0) {
				node.setRight(addHelper(node.getRight(), value));
			}

			return node;
		}
	}

	/**
	 * Remove a specified item from this Binaray Search Tree if it is present. <br>
	 * pre: <tt>value</tt> != null<br>
	 * post: Remove value from the tree if present, return true if this tree
	 * changed as a result of this method call, false otherwise.
	 * 
	 * @param value
	 *            the value to remove from the tree if present
	 * @return false if value was not present returns true if value was present
	 *         and size() = old size() - 1
	 */
	public boolean remove(E value) {
		if (value == null)
			throw new IllegalArgumentException();
		int oldSize = size();
		root = remHelper(root, value);
		return size() != oldSize;
	}

	private BSTNode<E> remHelper(BSTNode<E> node, E value) {
		// base case
		if (node == null)
			return null;
		// recursively search:
		int dir = value.compareTo(node.getData());
		if (dir < 0)
			node.setLeft(remHelper(node.getLeft(), value));
		else if (dir > 0)
			node.setRight(remHelper(node.getRight(), value));
		// actual removal
		else {
			size--;
			if (node.getLeft() == null && node.getRight() == null) { // leaf
				node = null;
			} else if (node.getLeft() == null) {
				node = node.getRight();
			} else if (node.getRight() == null) { 
				node = node.getLeft();
			}
			// copied from class notes. has two children (and grandkids...)
			else {
				E newVal = maxHelper(node.getLeft()).getData();
				node.setData(newVal);
				node.setLeft(remHelper(node.getLeft(), newVal));
				size++;
			}
		}
		// returns root
		return node;
	}

	/**
	 * Check to see if the specified element is in this Binary Search Tree. <br>
	 * pre: <tt>value</tt> != null<br>
	 * post: return true if value is present in tree, false otherwise
	 * 
	 * @param value
	 *            the value to look for in the tree
	 * @returns true if value is present in this tree, false otherwise
	 */
	public boolean isPresent(E value) { // DONE O(LogN)
		if (getRoot() == null) {
			// System.out.println("Empty tree. Nothing to check.");
			return false;
		}
		// System.out.println("initiate recursive search:");
		return search(getRoot(), value);
	}

	private boolean search(BSTNode<E> node, E value) {

		// base case: found!
		if (value.compareTo(node.getData()) == 0) {
			// System.out.println("found!");
			return true;
		}

		// base case: reached leaf without finding the value.
		else if (node.getLeft() == null && node.getRight() == null) {
			// System.out.println("a leaf. Exit.");
			return false;
		}

		// the actual searching
		int dir = value.compareTo(node.getData());

		if (dir < 0) {
			// System.out.println("searching left...");
			return search(node.getLeft(), value);
		} else {
			// System.out.println("searching right...");
			return search(node.getRight(), value);
		}

	}

	private BSTNode<E> getNode(BSTNode<E> node, E value) {

		// base case: found!
		if (value.compareTo(node.getData()) == 0) {
			// System.out.println("found!");
			return node;
		}
		// the actual searching
		int dir = value.compareTo(node.getData());

		if (dir < 0) {
			// System.out.println("searching left...");
			node = getNode(node.getLeft(), value);
		} else {
			// System.out.println("searching right...");
			node = getNode(node.getRight(), value);
		}
		return node;

	}

	/**
	 * Return how many elements are in this Binary Search Tree. <br>
	 * pre: none<br>
	 * post: return the number of items in this tree
	 * 
	 * @returns the number of items in this Binary Search Tree
	 */
	public int size() {
		return size;
	}

	/**
	 * return the height of this Binary Search Tree. <br>
	 * pre: none<br>
	 * post: return the height of this tree. If the tree is empty return -1,
	 * otherwise return the height of the tree
	 * 
	 * @returns the height of this tree or -1 if the tree is empty
	 * 
	 *          Copied from class notes.
	 */
	public int height() {

		return getHeight(getRoot());
	}

	private int getHeight(BSTNode<E> node) {

		if (node == null)
			return -1;

		int l = getHeight(node.getLeft()); // pointer --move on not recurse
		// System.out.println(l);
		int r = getHeight(node.getRight()); // pointer --move on not recurse

		return 1 + Math.max(r, l); // return 1+1+1+1+1+1.......-1
	}

	/**
	 * Return a list of all the elements in this Binary Search Tree. <br>
	 * pre: none<br>
	 * post: return a List object with all data from the tree in ascending
	 * order. If the tree is empty return an empty List
	 * 
	 * @returns a List object with all data from the tree in sorted order if the
	 *          tree is empty return an empty List
	 */
	public List<E> getAll() {
		ArrayList<E> result = new ArrayList<E>();
		return inOrder(getRoot(), result);
	}

	/**
	 * return the maximum value in this binary search tree. <br>
	 * pre: <tt>size()</tt> > 0<br>
	 * post: return the largest value in this Binary Search Tree
	 * 
	 * @return the maximum value in this tree
	 */
	public E max() {
		assert size > 0;
		return maxHelper(getRoot()).getData();
	}

	private BSTNode<E> maxHelper(BSTNode<E> node) {
		if (node.getRight() != null) {
			node = maxHelper(node.getRight());
		}
		return node;
	}

	/**
	 * return the minimum value in this binary search tree. <br>
	 * pre: <tt>size()</tt> > 0<br>
	 * post: return the smallest value in this Binary Search Tree
	 * 
	 * @return the minimum value in this tree
	 */
	public E min() {
		assert size > 0;
		return minHelper(getRoot()).getData();
	}

	private BSTNode<E> minHelper(BSTNode<E> node) {
		if (node.getLeft() != null) {
			node = minHelper(node.getLeft());
			// System.out.println(result);
		}
		return node;
	}

    public int countLeaves(){
        return countLeaves(getRoot());
    }

    private int countLeaves(BSTNode<E> n) {
        if (n!=null)
        if (isLeaf(n))
            return 1;
        else
            return countLeaves(n.getLeft()) + countLeaves(n.getRight());
        else
            return -1;
    }
    public void prune(){
        root = prune(getRoot());
    }

    private BSTNode prune(BSTNode<E> node) {
        if (node!=null){
            if (isLeaf(node)){
                node = null;
                size--;
            }
            else{
                node.setLeft(prune(node.getLeft()));
                node.setRight(prune(node.getRight()));
            }
        }
        return node;  //To change body of created methods use File | Settings | File Templates.
    }
    public void removeMax(){
        root = removeMax(getRoot());
    }

    private BSTNode<E> removeMax(BSTNode<E> root) {
        if (root!=null)
            if (isLeaf(root))
            {root = null; size--;}
            else
                root.setRight(removeMax(root.getRight()));
        return root;
    }

    private boolean isLeaf(BSTNode<E> n){
        return n.getLeft()==null && n.getRight()==null;
    }

	/**
	 * An add method that implements the add algorithm iteratively instead of
	 * recursively. <br>
	 * pre: data != null <br>
	 * post: if data is not present add it to the tree, otherwise do nothing.
	 * 
	 * @param data
	 *            the item to be added to this tree
	 * @return true if data was not present before this call to add, false
	 *         otherwise.
	 */
	public boolean iterativeAdd(E data) {
		if (data == null)
			throw new IllegalArgumentException("data cannot be null");
		BSTNode<E> lead = root;
		BSTNode<E> tail = null;
		int dir = 0;
		while (lead != null) { // not a copy; exit at correct leaf.
			if (lead.getData().compareTo(data) == 0) {
				return false;
			}
			dir = data.compareTo(lead.getData());
			tail = lead;
			// go left
			if (dir < 0) {

				lead = lead.getLeft();
			}
			if (dir > 0) {
				lead = lead.getRight();
			}
		} // found correct leaf
		dir = data.compareTo(tail.getData());
		size++;
		if (dir < 0) {
			tail.setLeft(new BSTNode<E>(null, data, null));
			return true;
		}
		if (dir > 0) {
			tail.setRight(new BSTNode<E>(null, data, null));
			return true;
		}

		return false;
	}

	/**
	 * Return the "kth" largest element in this Binary Search Tree. If kth = 0
	 * the smallest value (minimum) is returned. If kth = 1 the second smallest
	 * value is returned, and so forth. <br>
	 * pre: 0 <= kth < size()
	 * 
	 * @param kth
	 *            indicates the rank of the element to get
	 * @return the kth largest value in this Bianary Search Tree
	 * 
	 *         DONE O(LogN)
	 */
	public E get(int kth) {
		assert kth >= 0 && kth < size();
		int[] v = new int[] { -1 };
		return get(getRoot(), kth, v, getRoot().getData());
	}

	private E get(BSTNode<E> node, int kth, int[] v, E result) {
		// the reason for storing the digit to compare in a one-element array
		// v[] is so Java can update the value of that object
		// (through the reference) instead
		// of only updating the local copy if it was a primitive data type, an
		// int.

		// backtrack; similar to inOrder.
		if (node != null) {
			// System.out.println("recursion: " +node.getData()+ " start: " +
			// v[0]);
			// System.out.println("checking left...");
			result = get(node.getLeft(), kth, v, result);
			v[0]++;
			if (v[0] == kth) {
				result = node.getData();
			}
			// System.out.println("checking right...");
			result = get(node.getRight(), kth, v, result);
		}
		// System.out.println(node.getData());
		// System.out.println("checked right");

		return result;
	}

	/**
	 * Return a List with all values in this Binary Search Tree that are less
	 * than the parameter <tt>value</tt>. <tt>value</tt> != null<br>
	 * 
	 * @param value
	 *            the cutoff value
	 * @return a List with all values in this tree that are less than the
	 *         parameter value. If there are no values in this tree less than
	 *         value return an empty list. The elements of the list are in
	 *         ascending order.
	 */
	public List<E> getAllLessThan(E value) {
		ArrayList<E> result = new ArrayList<E>();

		return gALHelper(getRoot(), value, result);
	}

	private List<E> gALHelper(BSTNode<E> node, E value, ArrayList<E> result) {
		if (node != null) {
			int dir = node.getData().compareTo(value);
			if (dir < 0) { // node val < val: add it to list; check both
							// children.
				gALHelper(node.getLeft(), value, result); // check left nodes
				result.add(node.getData());
				gALHelper(node.getRight(), value, result); // check right nodes
			} else { // no need to check right children
				gALHelper(node.getLeft(), value, result); // check left nodes
			}
		}
		return result;
	}

	/**
	 * Return a List with all values in this Binary Search Tree that are greater
	 * than the parameter <tt>value</tt>. <tt>value</tt> != null<br>
	 * 
	 * @param value
	 *            the cutoff value
	 * @return a List with all values in this tree that are greater than the
	 *         parameter value. If there are no values in this tree greater than
	 *         value return an empty list. The elements of the list are in
	 *         ascending order.
	 */
	public List<E> getAllGreaterThan(E value) {
		ArrayList<E> result = new ArrayList<E>();

		return gAGHelper(getRoot(), value, result);
	}

	private List<E> gAGHelper(BSTNode<E> node, E value, ArrayList<E> result) {
		if (node != null) {
			int dir = node.getData().compareTo(value);
			if (dir > 0) { // node val > val: add it to list; check both
							// children.
				gAGHelper(node.getLeft(), value, result); // check left nodes
				result.add(node.getData());
				gAGHelper(node.getRight(), value, result); // check right nodes
			} else { // no need to check left children
				gAGHelper(node.getRight(), value, result); // check right nodes
			}
		}
		return result;
	}

	/**
	 * Find the number of nodes in this tree at the specified depth. <br>
	 * pre: none
	 * 
	 * @param d
	 *            The target depth.
	 * @return The number of nodes in this tree at a depth equal to the
	 *         parameter d.
	 */

	public int numNodesAtDepth(int d) {
		return depthHelper(d, 0, root) - depthHelper(d - 1, 0, root);
	}

	private int depthHelper(int d, int level, BSTNode<E> node) {
		if (node != null) {
			if (d < level) {
				return 0;
			} else {
				return 1 + depthHelper(d, level + 1, node.getLeft())
						+ depthHelper(d, level + 1, node.getRight());
			}
		}
		return 0;
	}

	/**
	 * In-Order Traversal Recursive Backtracking.
	 * 
	 * @param start, depending on the sign of dir.
	 *
	 * @return an ordered list of elements O(N)
	 */
	private List<E> inOrder(BSTNode<E> start, ArrayList<E> list) {

		if (start != null) {
			inOrder(start.getLeft(), list); // it will stop calling this as soon
											// as the node's left child is null
			list.add(start.getData()); // the works
			inOrder(start.getRight(), list); // it will stop calling this as
												// soon as the node's right
												// child is null
		}
		return list;

	}

	/**
	 * Prints a vertical representation of this tree. The tree has been rotated
	 * counter clockwise 90 degrees. The root is on the left. Each node is
	 * printed out on its own row. A node's children wil not necessarily be at
	 * the rows directly above and below a row. They will be indented three
	 * spaces from the parent. Nodes indented the same amount are at the same
	 * depth. pre: none
	 */
	public void printTree() {
		printTree(getRoot(), "");
	}

	private void printTree(BSTNode<E> n, String spaces) {
		if (n != null) {
			printTree(n.getRight(), spaces + "  ");
			System.out.println(spaces + n.getData());
			printTree(n.getLeft(), spaces + "  ");
		}
	}

	public BSTNode<E> getRoot() {
		return root;
	}

    public E getRootData(){
        return root.data;
    }

	private void setRoot(BSTNode<E> root) {
		this.root = root;
	}

	private static class BSTNode<E extends Comparable<? super E>> {
		private E data;
		private BSTNode<E> left;
		private BSTNode<E> right;

		public BSTNode() {
			this(null);
		}

		public BSTNode(E initValue) {
			this(null, null, null);
		}

		public BSTNode(BSTNode<E> initLeft, E initValue, BSTNode<E> initRight) {
			data = initValue;
			left = initLeft;
			right = initRight;
		}

		public E getData() {
			return data;
		}

		public BSTNode<E> getLeft() {
			return left;
		}

		public BSTNode<E> getRight() {
			return right;
		}

		public void setData(E theNewValue) {
			data = theNewValue;
		}

		public void setLeft(BSTNode<E> theNewLeft) {
			left = theNewLeft;
		}

		public void setRight(BSTNode<E> theNewRight) {
			right = theNewRight;
		}
	}
}
