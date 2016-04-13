public class LLTester {
	public static void main(String[] args) {
		LinkList<Integer> list1 = new LinkList<Integer>();
		System.out.print("Should be nothing: ");
		list1.printList();
		list1.add(12);
		list1.add(15);
		System.out.print("Should be 12 15: ");
		list1.printList();
		list1.addFront(7);
		list1.addFront(3);
		System.out.print("Should be 3 7 12 15: ");
		list1.printList();
		list1.insert(2, 17);
		System.out.print("Should be 3 7 17 12 15: ");
		list1.printList();
		System.out.println(list1.midTermAdd(3) + "should be false");
		list1.printList();
		System.out.println(list1.midTermAdd(666) + "should be true");
		
		list1.printList();
		
		list1.split();
		
		list1.printList();


//		list1.remove(list1.size() - 1);
//		System.out.print("Should be 3 7 17 12: ");
//		list1.printList();
//		list1.add(37);
//		System.out.print("Should be 3 7 17 12 37: ");
//		list1.printList();		
		
//		Iterator<Integer> it = list1.iterator();
//		while(it.hasNext())
//			System.out.print(it.next() + " ");
		
		System.out.println("test");
	}
}	
