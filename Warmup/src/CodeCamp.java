//  CodeCamp.java - CS314 Assignment 1

/*  Student information for assignment:
 *
 *  On my honor, Ahmed AlJehairan, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: aa29665
 *  email address: ahmed24633@gmail.com
 *  Grader name: Yuanzhong
 *  Number of slip days I am using: 1
 */

import java.util.Random;

public class CodeCamp {

    /**
     * Determine the Hamming distance between two arrays of ints.
     * Neither the parameter <tt>aList</tt> or
     * <tt>bList</tt> are altered as a result of this method.
     * @param aList != null, aList.length == bList.length
     * @param bList != null, bList.length == aList.length
     * @return the Hamming Distance between the two arrays of ints.
     */
    public static int hammingDistance(int[] aList, int[] bList){
        // check preconditions
        if (aList == null || bList == null || aList.length != bList.length)
            throw new IllegalArgumentException("Violation of precondition: hammingDistance. " +
                    "neither parameter may equal null, arrays must be equal length.");

        int result = 0;
        for (int i =0; i<aList.length;i++){
            if (aList[i]!=bList[i])
                result++;
        }

        return result;
    }


    /**
     * Determine if one array of ints is a permutation of another.
     * Neither the parameter <tt>listA</tt> or
     * the parameter <tt>listB</tt> are altered as a result of this method.
     * @param listA != null
     * @param listB != null
     * @return <tt>true</tt> if listB is a permutation of listA, <tt>false</tt> otherwise
     *
    */
    public static boolean isPermutation(int[] listA, int[] listB) {
        // check preconditions
        if (listA == null || listB == null)
            throw new IllegalArgumentException("Violation of precondition: isPermutation. " +
                    "neither parameter may equal null.");

        boolean result = false, match= false;
        int i=0, j=0;
//        System.out.println("result initialized");
//      first, I'm gonna see if it's even worth looping through by checking the lengths;
//      they have to be equal.
        if (listA.length==listB.length){
//            System.out.println("passed length condition");
//          Awesome. We're in.
            final int LENGTH = listA.length;
            result=true;
//          the big while loop conditionally moves forward in listA elements
            while (result==true && i<LENGTH){
//                System.out.println("in while loop");
                match = false; j=0;
//              the small one condtionally moves forward listB elements and compares
//              them with the slower listA elements progression
                while (match==false&& j<LENGTH){ //!match or match by itself confuse me so I equated it with a false clause
//                    System.out.println("in for loop");
//                    System.out.println("checking: "+ listA[i]+" with "+ listB[j]);
                    if (listA[i]==listB[j])
//                      if no match, break both loops.
                        match=true;
                    j++;
                }

                result = match;
                i++;

            }

        }

        return result;
    }


    /**
     * Determine the index of the String that
     * has the largest number of vowels.
     * Vowels are defined as <tt>'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', and 'u'</tt>.
     * The parameter <tt>list</tt> is not altered as a result of this method.
     * <p>pre: <tt>list != null</tt>, <tt>list.length > 0</tt>, there is an least 1 non null element in list
     * <p>post: return the index of the non-null element in list that has the
     * largest number of characters that are vowels.
     * If there is a tie return the index closest to zero.
     * The empty String, "", has zero vowels.
     * It is possible for the maximum number of vowels to be 0.
     * @param list the array to check
     * @return the index of the non-null element in list that has the largest number of vowels.
     */


    public static int mostVowels(String[] list) {
        // check preconditions
        if (list == null || list.length == 0 || !atLeastOneNonNull(list)) {
            throw new IllegalArgumentException("Violation of precondition: mostVowels. "
                    + "parameter may not equal null and must contain at least one none null value.");
        }

        int count = 0; // how many vowels in a string

        int[] result = new int[2];
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null)
                if (i+1<list.length)
                {result[1]=i+1;}
                else
                    count=0;

            else if(list[i].equals("")) {
                            count = 1;
                        }
                else
                for (int c = 0; c < list[i].length(); c++) {
                    char toCompare = list[i].charAt(c);
                    if (
                            toCompare == 'A' || toCompare == 'a'
                            || toCompare == 'E'|| toCompare == 'e'
                            || toCompare == 'I'|| toCompare == 'i'
                            || toCompare == 'O'|| toCompare == 'o'
                            || toCompare == 'U'|| toCompare == 'u') {
                        count++; //count of vowels in one string

                    }
                if (result[0] < count) {
                result[0] = count;
                result[1] = i;
                }




            }
                            count =0;

        }




        return result[1];
    }



    /**
     * Perform an experiment simulating the birthday problem.
     * Pick random birthdays for the given number of people.
     * Return the number of pairs of people that share the
     * same birthday.
     * @param numPeople The number of people in the experiment.
     * This value must be > 0
     * @param numDaysInYear The number of days in the year for this experiement.
     * This value must be > 0
     * @return The number of pairs of people that share a birthday after running the simulation.
     */
/*  Three helping methods: one that randomizes the birthdays, one to biggest day
     * in random birthdays and one counts people with the same birthday.
     * The main method
     * will count pairs with
     * the enfamous f(n) = n*(n-1)/2
     */
    public static int[] randomizeBirthdays(int people, int days){
        Random r = new Random();
        int[] bdays = new int[people];
        for (int person =0; person<people; person++){
            bdays[person]= r.nextInt(days);
//        System.out.println("Person: "+ person+" BDAY: "+ bdays[person]);}

        }
    return bdays;
    }
    public static int sameBday(int person, int[] bdays){
        int count =0;
        for (int i = 0; i<bdays.length; i++){
            if (bdays[person]==bdays[i] /*&& i!= person*/)
                count++;
//            System.out.println("Person: "+ person+" with BDAY: "+ bdays[person]
//                    + "shares his Bday with "+ count+" people "+i+" so far");
        }
        return count;
    }

    public static int sharedBirthdays(int numPeople, int numDaysInYear) {
        // check preconditions
        if (numPeople <= 0 || numDaysInYear <= 0)
            throw new IllegalArgumentException("Violation of precondition: sharedBirthdays. " +
                    "both parameters must be greater than 0. numPeople: " + numPeople +
                    ", numDaysInYear: " + numDaysInYear);

        int [] bdays = randomizeBirthdays(numPeople, numDaysInYear);
        int pairs = 0;
        if (numDaysInYear == 1)
            pairs = (numPeople*(numPeople-1))/2;
        else
            for (int person=0; person<bdays.length; person++){
//            System.out.println((sameBday(person, bdays)));
                pairs+= (sameBday(person, bdays)*(sameBday(person,bdays)-1)/2);
//            System.out.println(pairs);
        }


        return pairs; //must change
    }
    //Experiments (because we are scientests after all).
    public static float exp1 (int n, int p, int d){
        float avg=0;
        for (int i=1;i<=n;i++){
            avg+=sharedBirthdays(p,n);
//          System.out.println(avg/i);
        }
        return avg;}
    public static void exp2(){
        float total=1;
        float result=0;
        float percent=0;
        for (int i =20; i<=100;i++){
            total = 1;
            for (int exp =1; exp<500;exp++){
                result= exp1(exp,i,365);
                total+= result;
                percent = (result/total)*exp;
                System.out.println("result: "+ result+" total: "+total);
                System.out.printf("Num people: %d, number of experiments with one or"
                    + " more shared birthday: %d, percentage: %f\n", i, exp, percent);
        }

    }

    }


    /**
     * Determine if the chess board represented by board is a safe set up.
     * <p>pre: board != null, board.length > 0, board is a square matrix.
     * (In other words all rows in board have board.length columns.),
     * all elements of board == 'q' or '.'. 'q's represent queens, '.'s
     * represent open spaces.<br>
     * <p>post: return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
     * the parameter <tt>board</tt> is not altered as a result of
     * this method.
     * @param board the chessboard
     * @return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
    */
    public static boolean queensAreSafe(char[][] board) {
        char[] validChars = {'q', '.'};
        // check preconditions
        if (board == null || board.length == 0 || !isSquare(board) || !onlyContains(board, validChars))
            throw new IllegalArgumentException("Violation of precondition: queensAreSafe. " +
                    "The board may not be null, must be square, and may only contain" +
                    "'q's and '.'s");

      //CS314 STUDENTS: ADD YOUR CODE HERE

        return false; //must change
    }


    /**
     * Given a 2D array of ints return the value of the
     * most valuable contiguous sub rectangle in the 2D array.
     * The sub rectangle must be at lest 1 by 1.
     * <p>pre: <tt>mat != null, mat.length > 0, mat[0].length > 0,
     * mat</tt> is a rectangular matrix.
     * <p>post: return the value of the most valuable contigous sub rectangle
     * in <tt>city</tt>.
     * @param city The 2D array of ints representing the value of
     * each block in a portion of a city.
     * @return return the value of the most valuable contigous sub rectangle
     * in <tt>city</tt>.
     */
    public static int getValueOfMostValuablePlot(int[][] city) {
        // check preconditions
        if (city == null || city.length == 0 || city[0].length == 0 || !isRectangular(city) )
            throw new IllegalArgumentException("Violation of precondition: getValueOfMostValuablePlot. " +
                    "The parameter may not be null, must value at least one row and at least" +
                    " one column, and must be rectangular.");


        //CS314 STUDENTS: ADD YOUR CODE HERE

        return -1; //must change
    }


    // pre: list != null
    // post: return true if at least one element in list is null
    // otherwise return false.
    private static boolean atLeastOneNonNull(String[] list) {
        // check precondition
        if(list == null)
            throw new IllegalArgumentException("Violation of precondition: atLeastOneNonNull. " +
            "parameter may not equal null.");

        boolean foundNonNull = false;
        int i = 0;
        while( !foundNonNull && i < list.length ){
            foundNonNull = list[i] != null;
            i++;
        }
        return foundNonNull;
    }


    /* pre: mat != null
    post: return true if mat is a square matrix, false otherwise
     */
    private static boolean isSquare(char[][] mat) {
        if(mat == null)
            throw new IllegalArgumentException("Violation of precondition: isSquare. "
                    + "paremeter may not be null.");

        final int numRows = mat.length;
        int row = 0;
        boolean isSquare = true;
        while( isSquare && row < numRows ) {
            isSquare = ( mat[row] != null) && (mat[row].length == numRows);
            row++;
        }
        return isSquare;
    }


    /* pre: mat != null, valid != null
    post: return true if all elements in mat are one of the characters in valid
     */
    private static boolean onlyContains(char[][] mat, char[] valid) {
        // check preconditions
        if(mat == null || valid == null)
            throw new IllegalArgumentException("Violation of precondition: onlyContains. "
                    + "paremeters may not be null.");

        int row = 0;
        boolean correct = true;
        while( correct && row < mat.length) {
            int col = 0;
            while(correct && col < mat[row].length) {
                correct = contains(valid, mat[row][col]);
                col++;
            }
            row++;
        }
        return correct;
    }


    /*  pre: list != null
        post: return true if c is in list
     */
    private static boolean contains(char[] list, char tgtChar) {
        // check preconditions
        if(list == null)
            throw new IllegalArgumentException("Violation of precondition: contains. "
                    + "paremeter may not be null.");

        boolean found = false;
        int index = 0;
        while( !found && index < list.length) {
            found = list[index] == tgtChar;
            index++;
        }
        return found;
    }


     // pre: mat != null, mat.length > 0
     // post: return true if mat is rectangular
    private static boolean isRectangular(int[][] mat) {
        // check preconditions
        if(mat == null || mat.length == 0)
            throw new IllegalArgumentException("Violation of precondition: isRectangular. "
                    + "paremeter may not be null and must contain at least one row.");

        boolean correct = mat[0] != null;
        int row = 0;
        while(correct && row < mat.length) {
            correct = (mat[row] != null) && (mat[row].length == mat[0].length);
            row++;
        }
        return correct;
    }
}
