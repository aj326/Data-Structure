/*  Student information for assignment:
 *
 *  On my honor, <NAME>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID:
 *  email address:
 *  Grader name:
 *  Number of slip days I am using:
 */

/*
 * Place results of experiments here:
 * 
 */

/**
 * Test class for binary search tree
 */

import java.util.*;

public class BSTTester {

	public static void main(String[] args) {
		BinarySearchTree<String> t = new BinarySearchTree<String>();

		// test 1
		System.out.println("Test 1: empty tree created.");
		showTestResults(t.size() == 0, 1);

		// test 2
		System.out.println("Test 2: height of empty tree must be -1.");
		showTestResults(t.height() == -1, 2);

		// test 3
		System.out.println("Test 3: empty tree must "
				+ "not contain the String \"abyss\".");
		showTestResults(!t.isPresent("abyss"), 3);

		t.add("abyss");
		// test 4
		System.out.println("Test 4: added \"abyss\" to the"
				+ "tree. Size must be 1.");
		showTestResults(t.size() == 1, 4);

		// test 5
		System.out.println("Test 5: height of tree with 1 "
				+ "element must be 0.");
		showTestResults(t.height() == 0, 5);

		// test 6
		System.out.println("Test 6: \"abyss\" must be in the tree.");
		showTestResults(t.isPresent("abyss"), 6);

		// test 7
		System.out.println("Test 7: tree must "
				+ "not contain the String \"beep\".");
		showTestResults(!t.isPresent("beep"), 7);

		// test 8
		System.out.println("Test 8: min value must be"
				+ "\"abyss\" at this point.");
		showTestResults(t.min().equals("abyss"), 8);

		// test 9
		System.out.println("Test 9: max value must be"
				+ "\"abyss\" at this point.");
		showTestResults(t.max().equals("abyss"), 9);

		t.add("abyss");
		// test 10
		System.out.println("Test 10: attempt to add \"abyss\""
				+ "again. size must remain 1.");
		showTestResults(t.size() == 1, 10);

		// test 11
		System.out.println("Test 11: attempt to add \"abyss\""
				+ "again. height must remain 0.");
		showTestResults(t.height() == 0, 11);

		// test 12
		System.out.println("Test 12: \"abyss\" must still be" + "present.");
		showTestResults(t.isPresent("abyss"), 12);

		t.add("beep");
		// test 13
		System.out.println("Test 13: added \"beep\" to the"
				+ "tree. Size must be 2.");
		showTestResults(t.size() == 2, 13);

		// test 14
		System.out.println("Test 14: height of tree with 2"
				+ "elements must be 1.");
		showTestResults(t.height() == 1, 14);

		// test 15
		System.out.println("Test 15: Removing \"abyss\" from the tree.");
		showTestResults(t.remove("abyss"), 15);

		// test 16
		System.out.println("Test 16: Removing \"beep\" from the tree.");
		showTestResults(t.remove("beep"), 16);

		// test 17
		System.out.println("Test 17: Tree must be empty at this point.");
		showTestResults(t.size() == 0, 17);

		t.add("beep");
		t.add("abyss");
		t.add("calls");
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("abyss");
		expected.add("beep");
		expected.add("calls");

		// test 18
		System.out.println("Test 18: Added \"beep\", \"abyss\", and"
				+ "\"calls\" to the tree in that order.\n"
				+ "Testing getAll method.");

		showTestResults(expected.equals(t.getAll()), 18);

		// test 19
		t.add("bit");
		t.add("dish");
		System.out.println("Test 19: Added \"bit\" and \"dish\" to"
				+ "tree. Checking that \"yes\" is not present.");
		showTestResults(!t.remove("yes"), 19);

		// test 20
		t.add("a");
		System.out.println("Test 20: Added \"a\" and then " + "removed it.");
		showTestResults(t.remove("a"), 20);

		// test 21
		System.out
				.println("Test 21: Checking that \"calls\" is still present.");
		showTestResults(t.remove("calls"), 21);

		// test 22
		t.remove("abyss");
		System.out.println("Test 22: Removing \"abyss\". "
				+ "Checking that \"beep\" is still present.");
		showTestResults(t.remove("beep"), 22);

		// Test 23 - Adding unbalanced
		BinarySearchTree<Integer> iTree = new BinarySearchTree<Integer>();
		ArrayList<Integer> iExpected = new ArrayList<Integer>();
		iTree.add(1);
		iTree.iterativeAdd(2);
		iTree.iterativeAdd(3);
		iTree.add(-1);
		iExpected.add(-1);
		iExpected.add(1);
		iExpected.add(2);
		iExpected.add(3);
		System.out.println("Test 23: Adding unbalanced");
		showTestResults(iExpected.equals(iTree.getAll()), 23);
		// System.out.println(iTree.getAll());
		// iTree.printTree();

		// Test 24 - Adding unbalanced
		iTree.iterativeAdd(-2);
		iExpected.add(0, -2);
		System.out.println("Test 24: Adding unbalanced");
		showTestResults(iExpected.equals(iTree.getAll()), 24);
		// System.out.println(iTree.getAll());
		// iTree.printTree();

		// Test 25 - Removing root [-2, -1, 2, 3]
		iTree.remove(1);
		iExpected.remove(new Integer(1));
		System.out.println("Test 25: Removing root");
		showTestResults(iExpected.equals(iTree.getAll()), 25);
		System.out.println(iTree.getAll());
		// iTree.printTree();
		// System.exit(-1);

		// Test 26 - Removing new root [-2, 2, 3]
		iTree.remove(-1);
		iExpected.remove(new Integer(-1));
		System.out.println("Test 26: Removing new root");
		showTestResults(iExpected.equals(iTree.getAll()), 26);
		// System.out.println(iTree.getAll());
		// iTree.printTree();

		// Test 27 - IsPresent new root
		System.out.println("Test 27: IsPresent new root");
		showTestResults(iTree.isPresent(-2), 27);
		// System.out.println(iTree.getAll());
		// iTree.printTree();

		// Test 28 - IsPresent rightmost minimum
		System.out.println("Test 28: IsPresent rightmost minimum");
		showTestResults(iTree.isPresent(2), 28);
		// System.out.println(iTree.getAll());
		// iTree.printTree();

		// Test 29 - Size
		System.out.println("Test 29: Size of defunct tree");
		showTestResults(iTree.size() == 3, 29);
		// System.out.println(iTree.getAll());
		// iTree.printTree();

		// Test 30 - Size removing rightmost minimum [-2, 3]
		iTree.remove(2);
		iExpected.remove(new Integer(2));
		System.out.println("Test 30: Size of defunct tree");
		showTestResults(iTree.size() == 2, 30);
		// System.out.println(iTree.getAll());
		// iTree.printTree();

		// Test 31 - Height
		System.out.println("Test 31: Height of defunct tree");
		showTestResults(iTree.height() == 1, 31);
		// System.out.println(iTree.getAll());
		// iTree.printTree();

		// Test 32 - Height removing root [3]
		iTree.remove(-2);
		iExpected.remove(new Integer(-2));
		System.out.println("Test 32: Height of defunct tree");
		showTestResults(iTree.height() == 0, 32);
		// System.out.println(iTree.getAll());
		// iTree.printTree();

		// Test 33 - Max of tree
		System.out.println("Test 33: Max of defunct tree");
		showTestResults(iTree.max().equals(new Integer(3)), 33);
		// System.out.println(iTree.getAll());
		// iTree.printTree();

		// Test 34 - Max of tree [-1, 3]
		iTree.add(-1);
		System.out.println("Test 34: Max of defunct tree");
		showTestResults(iTree.max().equals(new Integer(3)), 34);
		// System.out.println(iTree.getAll());
		// iTree.printTree();

		// Test 35 - Min of tree
		System.out.println("Test 35: Min of defunct tree");
		showTestResults(iTree.min().equals(new Integer(-1)), 35);
		// System.out.println(iTree.getAll());
		// iTree.printTree();

		// Test 36 - Min of tree
		iTree.add(4);
		System.out.println("Test 36: Min of defunct tree");
		showTestResults(iTree.min().equals(new Integer(-1)), 36);
		// System.out.println(iTree.getAll());
		// iTree.printTree();

		// Test 37 - Number of Nodes at Depth
		System.out.println("Test 37: Number of Nodes at depth of defunct tree");
		showTestResults(iTree.numNodesAtDepth(0) == 1, 37);
		// System.out.println(iTree.getAll());
		// iTree.printTree();

		// Test 38 - Number of Nodes at Depth
		System.out.println("Test 38: Number of Nodes at depth of defunct tree");
		showTestResults(iTree.numNodesAtDepth(1) == 2, 38);
		// System.out.println(iTree.getAll());
		// iTree.printTree();

		// Test 39 - height
		int[] values = { 50, 25, -10, 10, 5, 0, 23, 30, 35, 40, 100, 75, 200 };
		BinarySearchTree<Integer> t2 = new BinarySearchTree<Integer>();
		for (int i : values)
			t2.add(i);
		System.out.println("Height again for non trivial tree");
		showTestResults(t2.height() == 5, 39);
		// System.out.println(t2.getAll());
		// t2.printTree();

		// Test 40 - 52: get kth
		System.out.println("getKth");
		Arrays.sort(values);
		for (int i = 0; i < values.length; i++) {
			showTestResults(t2.get(i).equals(new Integer(values[i])), 40 + i);
		}

		// Test 53: getAllLessThan
		System.out.println("get all less than -50");
		showTestResults(
				t2.getAllLessThan(-50).equals(new ArrayList<Integer>()), 53);
		// System.out.println(t2.getAll());
		// t2.printTree();

		// Test 54: getAllLessThan
		System.out.println("get all less than 25");
		ArrayList<Integer> expectedList = new ArrayList<Integer>();
		int cutoff = 25;
		int index = 0;
		while (index < values.length && values[index] < cutoff) {
			expectedList.add(values[index]);
			index++;
		}
		List<Integer> actual = t2.getAllLessThan(cutoff);
		showTestResults(actual.equals(expectedList), 54);
		// System.out.println(expectedList);
		// System.out.println(t2.getAll());
		// t2.printTree();

		// Test 55: getAllLessThan
		System.out.println("get all less than 1000");
		expectedList.clear();
		cutoff = 1000;
		index = 0;
		while (index < values.length && values[index] < cutoff) {
			expectedList.add(values[index]);
			index++;
		}
		actual = t2.getAllLessThan(cutoff);
		showTestResults(actual.equals(expectedList), 55);
		// System.out.println(expectedList);
		// System.out.println(t2.getAll());
		// t2.printTree();

		// Test 57: getAllGreaterThan
		System.out.println("get all greater than 1000");
		expectedList.clear();
		cutoff = 1000;
		index = values.length - 1;
		while (index >= 0 && values[index] > cutoff) {
			expectedList.add(values[index]);
			index--;
		}
		Collections.reverse(expectedList);
		actual = t2.getAllGreaterThan(cutoff);
		showTestResults(actual.equals(expectedList), 57);
		// System.out.println(expectedList);
		// System.out.println(t2.getAll());
		// t2.printTree();

		// Test 58: getAllGreaterThan
		System.out.println("get all greater than 25");
		expectedList.clear();
		cutoff = 25;
		index = values.length - 1;
		while (index >= 0 && values[index] > cutoff) {
			expectedList.add(values[index]);
			index--;
		}
		Collections.reverse(expectedList);
		actual = t2.getAllGreaterThan(cutoff);
		showTestResults(actual.equals(expectedList), 58);
		// System.out.println(expectedList);
		// System.out.println(t2.getAll());
		// t2.printTree();

		// Test 59: getAllGreaterThan
		System.out.println("get all greater than -1000");
		expectedList.clear();
		cutoff = -1000;
		index = values.length - 1;
		while (index >= 0 && values[index] > cutoff) {
			expectedList.add(values[index]);
			index--;
		}

		Collections.reverse(expectedList);
		actual = t2.getAllGreaterThan(cutoff);
		showTestResults(actual.equals(expectedList), 59);
		// System.out.println(expectedList);
		// System.out.println(t2.getAll());
		// t2.printTree();
		System.out.println();
        BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>();
        myTree.add(50);
        myTree.add(25);
        myTree.add(75);
        myTree.add(100);
        myTree.add(60);
        myTree.add(1);
        myTree.add(27);
        myTree.add(2);
//        System.out.println("Leaves: " + );
        myTree.printTree();
        System.out.println("Leaves: " + myTree.countLeaves());
        myTree.prune();
        System.out.println("Tree after pruning: ");
        myTree.printTree();
        System.out.println("new size is " + (4==myTree.size()? "correct" : "incorrect"));
        System.out.println("back to root: " + (myTree.getRootData()==50? "yes": "no"));
        myTree.removeMax();
        System.out.println("Tree after removing max: ");
        myTree.printTree();
        myTree.removeMax();
        myTree.printTree();
        for (int i = 1; i<10; i++)
            System.out.println(i + "%" + 31 + "=" + i%31+"\t\t\t"+ (i*i) + "%" + 31 + "="+(i*i)%31);
//		for (int i = 1000; i<=1024000; i*=2){
//			System.out.print(i + " ");
//			exp(i, 10);
//			}
//System.out.println();
	
//	for (int i = 1000; i<=1024000; i*=2){
//		System.out.print(i + " ");exp2(i, 10);}
//
//
//		for (int i = 1000; i<=64000; i*=2){
//		System.out.print(i + " ");exp3(i, 10);}
		
//		for (int i = 1000; i<=64000; i*=2){
//			System.out.print(i + " ");exp4(i, 10);}
	
		
		
}

	public static void exp(int n, int times) {
		Stopwatch s = new Stopwatch();
		s.start();
		Random r = new Random();
		double size = 0, height = 0, time = 0;
		
		for (int a = 0; a < times; a++) {
			BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
			for (int i = 0; i < n; i++) {
				b.add(new Integer(r.nextInt()));
			}
			s.stop();
			time += s.time();
			height += (double) b.height();
			size += (double) b.size();
//			System.out.println("time: " + s.time() + "\theight: " + b.height()
//					+ "\tsize: " + b.size());
		}
		System.out.println("time: "
				+ (time / times) + "\theight: " + (height / times) + "\tsize: "
				+ (size / times));
	}
	public static void exp2(int n, int times) {
		Stopwatch s = new Stopwatch();
		s.start();
		Random r = new Random();
		double size = 0, time = 0;
		
		for (int a = 0; a < times; a++) {
			TreeSet<Integer> b = new TreeSet<Integer>();
			for (int i = 0; i < n; i++) {
				b.add(new Integer(r.nextInt()));
			}
			s.stop();
			time += s.time();
//			height += (double) b.;
			size += (double) b.size();
//			System.out.println("time: " + s.time() + "\theight: " + b.height()
//					+ "\tsize: " + b.size());
		}
		System.out.println("time: "
				+ (time / times) +  "\tsize: "
				+ (size / times));
	}
	public static void exp3 (int n, int times){
		Stopwatch s = new Stopwatch();
		s.start();
		double size = 0, height = 0, time = 0;
		
		for (int a = 0; a < times; a++) {
			BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
			for (int i = 0; i < n; i++) {
				b.add(i);
			}
			s.stop();
			time += s.time();
			height += (double) b.height();
			size += (double) b.size();
//			System.out.println("time: " + s.time() + "\theight: " + b.height()
//					+ "\tsize: " + b.size());
		}
		System.out.println("time: "
				+ (time / times) + "\theight: " + (height / times) + "\tsize: "
				+ (size / times));
	}
	
	public static void exp4 (int n, int times){
		Stopwatch s = new Stopwatch();
		s.start();
		double size = 0, time = 0;
		
		for (int a = 0; a < times; a++) {
			TreeSet<Integer> b = new TreeSet<Integer>();
			for (int i = 0; i < n; i++) {
				b.add(i);
			}
			s.stop();
			time += s.time();
//			height += (double) b.height();
			size += (double) b.size();
//			System.out.println("time: " + s.time() + "\theight: " + b.height()
//					+ "\tsize: " + b.size());
		}
		System.out.println("time: "
				+ (time / times) +  "\tsize: "
				+ (size / times));
		myTestCases();
	}
	  private static void myTestCases()
	    {
	    	BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
	    	
	    	t.add(10);
	    	System.out.println("Test 60: add and isPresent");
	    	showTestResults(t.isPresent(10),60);
	    	
	    	t.add(5);
	    	System.out.println("Test 61: add and size");
	    	showTestResults(t.size()==2,61);
	    	
	    	t.iterativeAdd(15);
	    	System.out.println("Test 62: iterativeAdd and isPresent");
	    	showTestResults(t.isPresent(15),62);
	    	
	    	t.iterativeAdd(13);
	    	System.out.println("Test 63: iterativeAdd and size");
	    	showTestResults(t.size()==4,63);
	    	
	    	System.out.println("Test 64: height");
	    	showTestResults(t.height()==2,64);
	    	
	    	System.out.println("Test 65: min");
	    	showTestResults(t.min()==5,65);
	    	
	    	System.out.println("Test 66: max");
	    	showTestResults(t.max()==15,66);
	    	
	    	System.out.println("Test 67: numNodesAtDepth");
	    	showTestResults(t.numNodesAtDepth(1)==2,67);
	    	
	    	ArrayList<Integer> expected = new ArrayList<Integer>();
	    	expected.add(5);
	    	expected.add(10);
	    	expected.add(13);
	    	expected.add(15);
	    	System.out.println("Test 68: getAll");
	    	showTestResults(t.getAll().equals(expected),68);
	    	
	    	System.out.println("Test 69: get");
	    	showTestResults(t.get(0)==5,69);
	    	
	    	System.out.println("Test 70: get");
	    	showTestResults(t.get(3)==15,70);
	    	
	    	expected.clear();
	    	expected.add(5);
	    	expected.add(10);
	    	System.out.println("Test 71: getAllLessThan");
	    	showTestResults(t.getAllLessThan(13).equals(expected),71);
	    	
	    	expected.clear();
	    	expected.add(10);
	    	expected.add(13);
	    	expected.add(15);
	    	System.out.println("Test 72: getAllGreaterThan");
	    	showTestResults(t.getAllGreaterThan(7).equals(expected),72);
	    	
	    	t.remove(13);
	    	System.out.println("Test 73: remove and isPresent");
	    	showTestResults(!t.isPresent(13),73);
	    	
	    	System.out.println("Test 74: remove an object not present");
	    	showTestResults(!t.remove(50),74);
	    	
	    	t.add(1);
	    	t.add(0);
	    	t.add(3);
	    	t.add(7);
	    	t.add(9);
	    	t.add(11);
	    	t.add(14);
	    	t.add(50);
	    	System.out.println("Test 75: height");
	    	showTestResults(t.height()==3,75);
	    	
	    	expected.clear();
	    	expected.add(0);
	    	expected.add(1);
	    	expected.add(3);
	    	expected.add(5);
	    	expected.add(7);
	    	expected.add(9);
	    	expected.add(10);
	    	expected.add(11);
	    	expected.add(14);
	    	expected.add(15);
	    	expected.add(50);
	    	System.out.println("Test 76: getAll");
	    	showTestResults(t.getAll().equals(expected),76);
	    	
	    	System.out.println("Test 77: max");
	    	showTestResults(t.max()==50,77);
	    	
	    	System.out.println("Test 78: min");
	    	showTestResults(t.min()==0,78);
	    	
	    	System.out.println("Test 79: numNodesAtDepth");
	    	showTestResults(t.numNodesAtDepth(3)==4,79);
	    	
	    	expected.clear();
	    	expected.add(11);
	    	expected.add(14);
	    	expected.add(15);
	    	expected.add(50);
	    	System.out.println("Test 80: getAllGreaterThan");
	    	showTestResults(t.getAllGreaterThan(10).equals(expected),80);
	    	
	    	expected.clear();
	    	System.out.println("Test 81: getAllLessThan");
	    	showTestResults(t.getAllLessThan(0).equals(expected),81);
	    }

	private static void showTestResults(boolean passed, int testNum) {
		if (passed)
			System.out.println("test " + testNum + " passed.");
		else
			System.out.println("test " + testNum + " failed.");
	}
}