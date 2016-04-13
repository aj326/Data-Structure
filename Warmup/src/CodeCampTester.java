
//  CodeCamp.java - CS314 Assignment 1 - Tester class

/*  Student information for assignment:
 *
 *  UTEID:aa29665
 *  email address:ahmed24633@gmail.com
 *  Grader name:Yuanzhong
 *  Number of slip days I am using:1
 */
public class CodeCampTester {

    public static void main(String[] args) {
        final String newline = System.getProperty("line.separator");

// CS314 Students: add tests here.

//test 1, hamming distance
        int[] h1 = {-2, 0, -9, -2, 6, 4, -2, 7, 4, -6};
        int[] h2 = {5, 9, 2, 3, 3, 6, 7, -5, -5, 2};
        int expected = 10;
        int actual = CodeCamp.hammingDistance(h1, h2);
        System.out.println("Test 1 hamming distance: expected value: "
                + expected + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println(" passed test 1, hamming distance");
        } else {
            System.out.println(" ***** FAILED ***** test 1, hamming distance");
        }

// test 2, hamming distance
        h1 = new int[]{-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        h2 = new int[]{-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        expected = 0;
        actual = CodeCamp.hammingDistance(h1, h2);
        System.out.println(newline + "Test 2 hamming distance: expected value: "
                + expected + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println(" passed test 2, hamming distance");
        } else {
            System.out.println(" ***** FAILED ***** test 2, hamming distance");
        }

// test 3, hamming distance
        h1 = new int[5];
        h2 = new int[5];
        h2[3] = 1;
        expected = 1;
        actual = CodeCamp.hammingDistance(h1, h2);
        System.out.println(newline + "Test 3 hamming distance: expected value: "
                + expected + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println(" passed test 3, hamming distance");
        } else {
            System.out.println(" ***** FAILED ***** test 3, hamming distance");
        }

//test 4, isPermutation
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {-5, 14, 2, 3, 1};
        boolean expectedBool = false;
        boolean actualBool = CodeCamp.isPermutation(a, b);
        System.out.println(newline + "Test 4 isPermutation: expected value: "
                + expectedBool + ", actual value: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println(" passed test 4, isPermutation");
        } else {
            System.out.println(" ***** FAILED ***** test 4, isPermutation");
        }

//test 5, is Permutation
        b = new int[]{1, 2, 3};
        expectedBool = false;
        actualBool = CodeCamp.isPermutation(a, b);
        System.out.println(newline + "Test 5 isPermutation: expected value: "
                + expectedBool + ", actual value: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println(" passed test 5, isPermutation");
        } else {
            System.out.println(" ***** FAILED ***** test 5, isPermutation");
        }

//test 6, is Permutation
        a = new int[]{Integer.MAX_VALUE, 12345, 99999, Integer.MIN_VALUE};
        b = new int[]{Integer.MIN_VALUE, 99999, 12345, Integer.MAX_VALUE};
        expectedBool = true;
        actualBool = CodeCamp.isPermutation(a, b);
        System.out.println(newline + "Test 6 isPermutation: expected value: "
                + expectedBool + ", actual value: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println(" passed test 6, isPermutation");
        } else {
            System.out.println(" ***** FAILED ***** test 6, isPermutation");
        }

// test 7, mostVowels
        String[] sList = {"The", "mostVowels", "methods", "takes", "in", "an",
            "array", "of", "Strings", "as", "a", "parameter", "and", "determines",
            "which", "String", "has", "the", "most", "vowels."};
        int expectedResult = 11;
        int actualResult = CodeCamp.mostVowels(sList);
        System.out.println(newline + "Test 7 mostVowels: expected result: "
                + expectedResult + ", actual result: " + actualResult);
        if (actualResult == expectedResult) {
            System.out.println("passed test 7, mostVowels");
        } else {
            System.out.println("***** FAILED ***** test 7, mostVowels");
        }

// test 8, mostVowels
        sList = new String[]{"3.14159", null, "YoSeMiTe NaTiOnAl PaRk", "foo", "", "!@#$%^&*()~_+=-][", "s\n\"\'\\t",
            Character.toString((char) 27)};
        expectedResult = 2;
        actualResult = CodeCamp.mostVowels(sList);
        System.out.println(newline + "Test 8 mostVowels: expected result: "
                + expectedResult + ", actual result: " + actualResult);
        if (actualResult == expectedResult) {
            System.out.println("passed test 8, mostVowels");
        } else {
            System.out.println("***** FAILED ***** test 8, mostVowels");
        }

// test 9 mostVowels
        sList = new String[]{null, ""};
        expectedResult = 1;
        actualResult = CodeCamp.mostVowels(sList);
        System.out.println(newline + "Test 9 mostVowels: expected result: "
                + expectedResult + ", actual result: " + actualResult);
        if (actualResult == expectedResult) {
            System.out.println("passed test 9, mostVowels");
        } else {
            System.out.println("***** FAILED ***** test 9, mostVowels");
        }

//test 10, sharedBirthdays, simple test
        int pairs = CodeCamp.sharedBirthdays(100, 1);
        System.out.println(newline + "Test 10 shared birthdays: expected: 0, actual: " + pairs);
        int expectedShared = 4950;
        if (pairs == expectedShared) {
            System.out.println("passed test 10, shared birthdays");
        } else {
            System.out.println("***** FAILED ***** test 10, shared birthdays");
        }

//test 11, sharedBirthdays, simple test
        pairs = CodeCamp.sharedBirthdays(1000000, 999999);
        System.out.println(newline + "Test 11 shared birthdays: expected: "
                + "a value of 1 or more, actual: " + pairs);
        if (pairs > 0) {
            System.out.println("passed test 11, shared birthdays");
        } else {
            System.out.println("***** FAILED ***** test 11, shared birthdays");
        }

//test 12, queensAreASafe
        char[][] board = {
            {'q', 'q', 'q'},
            {'q', 'q', 'q'},
            {'q', 'q', 'q'}};

        expectedBool = false;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 12 queensAreSafe: expected value: "
                + expectedBool + ", actual value: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println(" passed test 12, queensAreSafe");
        } else {
            System.out.println(" ***** FAILED ***** test 12, queensAreSafe");
        }

//test 13, queensAreASafe
        board = new char[][]{{'q'}};
        expectedBool = true;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 13 queensAreSafe: expected value: "
                + expectedBool + ", actual value: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println(" passed test 13, queensAreSafe");
        } else {
            System.out.println(" ***** FAILED ***** test 13, queensAreSafe");
        }

//test 14, queensAreASafe
        board = new char[][]{
            {'.', '.', '.', '.', 'q', '.', '.', '.'},
            {'q', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', 'q'},
            {'.', '.', '.', 'q', '.', '.', '.', '.'},
            {'.', 'q', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', 'q', '.'},
            {'.', '.', 'q', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', 'q', '.', '.'}};
        expectedBool = true;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 14 queensAreSafe: expected value: "
                + expectedBool + ", actual value: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println(" passed test 14, queensAreSafe");
        } else {
            System.out.println(" ***** FAILED ***** test 14, queensAreSafe");
        }

//test 15, queensAreASafe
        board = new char[][]{
            {'q', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', 'q'}};
        expectedBool = false;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 15 queensAreSafe: expected value: "
                + expectedBool + ", actual value: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println(" passed test 15, queensAreSafe");
        } else {
            System.out.println(" ***** FAILED ***** test 15, queensAreSafe");
        }

// test 16, getValueOfMostValuablePlot
        int[][] city = new int[100][100];

        expected = 0;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println(newline + "Test 16 getValueOfMostValuablePlot: expected value: "
                + expected + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println(" passed test 16, getValueOfMostValuablePlot");
        } else {
            System.out.println(" ***** FAILED ***** test 16, getValueOfMostValuablePlot");
        }

// test 17, getValueOfMostValuablePlot
        city[0][0] = 6;
        city[99][99] = 6;
        expected = 12;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println(newline + "Test 17 getValueOfMostValuablePlot: expected value: "
                + expected + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println(" passed test 17, getValueOfMostValuablePlot");
        } else {
            System.out.println(" ***** FAILED ***** test 17, getValueOfMostValuablePlot");
        }

// test 18, getValueOfMostValuablePlot
        city = new int[][]{
            {Integer.MIN_VALUE + 100000000, -100, -102, -3},
            {-7, 10, -6, -9},
            {100, 0, -4, -23},
            {-30, 50, -12, -23}};

        expected = 123;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println("\nTest 18 getValueOfMostValuablePlot: expected value: "
                + expected + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println(" passed test 18, getValueOfMostValuablePlot");
        } else {
            System.out.println(" ***** FAILED ***** test 18, getValueOfMostValuablePlot");
        }

    } // end of main method
}
