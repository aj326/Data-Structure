public class LinkList<E extends Comparable<E>> extends Node {
	private int size;
	private Node<E> first;
	private Node<E> last;
	
	public int size() {
		return size;
	}
	
	public void add(E value) {
		Node<E> newNode = new Node<E>(value, null);
		if(size == 0) 
			first = newNode;
		 else 
			last.setNext(newNode);
		last = newNode;
		size++;	
	}
	public boolean midTermAdd(E val){
	if (first == null || first.getData().compareTo(val)>0){
	first = new Node<E>(val,first);
	size++;
	return true;
	}
	else{
	Node<E> temp = first;
	while (temp!=null){
		int com = temp.getData().compareTo(val);
		if (com<0){
		temp = temp.getNext();
		}
		else if (com==0)
		return false;
		else{
		E old = temp.getData();
		temp.setData(val);
		temp.setNext(new Node<E>(old,temp.getNext()));
		old = null;
		size++;
		return true;
		}
	}//while
	//last
	temp = new Node<E> (val,null);
	last.setNext(temp);
	last = temp;
	size++;
	return true;
	}//else
	}
	
	public void split(){
	if (!(first==null || first.getNext()==null)){
		int c=0;
		for (Node<E> lead = first, tail = first; lead!=null; tail =lead, lead=lead.getNext()){
		//System.out.println("in for loop: " + c + " lead: " + lead.getData() + " tail: "+ tail.getData());
			if (c%2!=0){
					tail.setNext(lead.getNext());
					}
			c++;
			}
		}
	}
	
	public void addFront(E value) {
		if(size == 0)
			add(value);
		else {
			Node<E> newNode = new Node<E>(value, first);
			first = newNode;
			size++;
		}
	}
	
	
	public void insert(int pos, E value) {
		if(pos == 0)
			addFront(value);
		else if(pos == size)
			add(value);
		else {
			// general case
			Node<E> temp = first;
			for(int i = 1; i < pos; i++)
				temp = temp.getNext();
			Node<E> newNode = new Node<E>(value, temp.getNext());
			temp.setNext(newNode);
			size++;
		}
	}
	
	
	public void printList() {
		for(Node<E> temp = first; temp != null; temp = temp.getNext())
			System.out.print(temp.getData() + " ");
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
