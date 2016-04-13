import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericList<E> implements Iterable<E> {
	
	// class constant
	private static final int DEFAULT_CAP = 10;
	
	// instance variables
	private E[] values;
	private int size;
	
	// post: create an empty list
	public GenericList() {
		this(DEFAULT_CAP);
	}
	
	public Iterator<E> iterator() {
		return new GenListIterator();
	}
	
	private class GenListIterator implements Iterator<E> {
		private int indexOfNext;
		private boolean removeOK;
		
		public GenListIterator() {
			indexOfNext = 0;
			removeOK = false;
		}
		
		public boolean hasNext() {
			return indexOfNext < size;
		}
		
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException
					("No more elements in this iterator. hasNext is false");
			
			removeOK = true;
			E result = get(indexOfNext);
			indexOfNext++;
			return result;
		}
		
		public void remove() {
			if(!removeOK)
				throw new IllegalStateException("Shame on you. Not okay to remove");
				
			removeOK = false;
			indexOfNext--;
			GenericList.this.remove(indexOfNext);
		}
	}
	
	// pre: initialCap >= 0
	// post: create an empty list with capacity of initialCap
	public GenericList(int initialCap) {
		if(initialCap < 0)
			throw new IllegalArgumentException("violation of precondition. " +
					"initialCap may not be negative: " + initialCap);
		
		values = (E[]) new Object[initialCap];
	}
	
	// return size of list
	public int size() {
		return size;
	}
	
	// pre: newValue != null
	// post: newValue added to end of list, size of list increased by 1
	public void add(E newValue) {
		insert(size, newValue);
	}


	private void resize(int newCap) {
		E[] temp = (E[]) new Object[newCap];
		System.arraycopy(values, 0, temp, 0, values.length);
		values = temp;
	}
	
	// pre: -1 < pos < size()
	// post: return element in list at specified position
	public E get(int pos){
		if(!(-1 < pos && pos < size))
			throw new IllegalArgumentException("violation of precondition. " +
					"pos must be in bounds: " + pos);
		
		return values[pos];
	}
	
	
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		final int LIM = size - 1;
		for(int i = 0; i < LIM; i++) {
			result.append(values[i]);
			result.append(", ");
		}
		if(size > 0)
			result.append(values[LIM]);
		result.append("]");
		return result.toString();
	}
	
	// pre: 0 <= pos <= size(), newValue != null
	// post: get(pos) returns newValue, elements at old positions moved one
	// element to right, size goes up by one
	public void insert(int pos, E newValue) {
		// ensure capacity
		if(size == values.length)
			resize(values.length * 2 + 1);
		
		// shift elements to right
		for(int i = size; i > pos; i--)
			values[i] = values[i - 1];
		
		values[pos] = newValue;
		size++;
	}
	
	
	public void insertAll(int pos, GenericList<E> other) {
		int newSize = this.size + other.size;
		if(newSize >= this.values.length)
			resize(newSize * 2 + 1);
		
		final int LIM = other.size + pos;
		
		// shift elements in this list to right
		for(int i = newSize - 1; i >= LIM; i--)
			this.values[i] = this.values[i - other.size];
		
		// copy elements from other into this list
		for(int i = 0; i < other.size; i++)
			this.values[i + pos] = other.values[i];
		
		this.size = newSize;
	}
	
	
	public E remove(int pos) {
		E result = (E) values[pos];
		size--;
		for(int i = pos; i < size; i++)
			values[i] = values[i + 1];
		
		values[size] = null;
		return result;
	}
	 
	// pre: none
	public boolean equals(Object other) {
		if(other == null)
			return false;
		else if(!(other instanceof GenericList))
			return false;
		else if(this == other)
			return true;
		else {
			// I know other is a non null GenericList
			GenericList<?> otherList = ((GenericList<?>)other);
			boolean same = size() == otherList.size();
			int i = 0;
			while(i < size() && same) {
				same = values[i].equals(otherList.values[i]);
				i++;
			}
			return same;
		}
	}
	
	
	
	
	
	

}
