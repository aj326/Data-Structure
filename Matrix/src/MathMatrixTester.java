/*  Student information for assignment:
 *
 *  UTEID: aa29665
 *  email address: ahmed24633@gmail.com
 *  Grader name: Yuanzhong
 *  Number of slip days I am using:0
 */



/* CS314 Students. Put your experiment results and
* answers to questions here.
 *           //exp1
//          exp1(1600); // avg time: 0.029235649999999995 dim: 1600
//          exp1(2*1600); //avg time: 0.15027084999999998 dim: 3200

             //exp2
//          exp2(200); avg time: 0.02975962 dim: 200
//          exp2(400); avg time: 0.3258188599999999 dim: 400
//          
 *ANSWERS:
 * 1) 0.60 seconds
 * 2) O(N^2), my results support the order. (Off by creating the Object)
 * 3) 2.6 seconds
 * 4) O(N^3), my results support the order. (Off by creating the Object)
 * 5) appx a Matrix with dim 6400x6400. (Or (6400)^2*4 bytes = 163 840 000 bytes
 * or 156.25 megabytes.)
 * 
*/

/**
 * A class to run tests on the MathMatrix class
 */
public class MathMatrixTester
{

    /**
     * main method that runs simple test on the MathMatrix class
     *
     * @param args not used
     */
    public static void main(String[] args) {
        System.out.print(
        "samanthasam".indexOf("saaaam"));
////       MathMatrix x = new MathMatrix(6400,6400,5);
//       int[][] data1 = { {1, 2, 3},
//                       {2, 3, 4}};
//        int[][] data2 = { {2, 1, 1},
//                       {2, 3, 1}};
//        int[][] e1;
//
//        //test 1, specify size and values constructor
//        MathMatrix mat1 = new MathMatrix(2, 2, 0);
//        e1 = new int[][] {{0,0}, {0,0}};
//        printTestResult( get2DArray(mat1), e1, 1, "Constructor with size and initial val specified.");
//        
//        System.out.println("Test number 2 tests asserstions of constructor (commented out)—passed");
//
//        //test 2, specify size and values constructor, check assertion
////        mat1 = new MathMatrix(-2, 2, -1);
////        e1 = new int[][] {};
////        printTestResult( get2DArray(mat1), e1, 1, "Constructor with size and initial val specified.");
////        //test 2, specify size and values constructor
////        mat1 = new MathMatrix(3, 2, 0);
////        e1 = new int[][] {{0,0}, {0,0}, {0,0}};
////        printTestResult( get2DArray(mat1), e1, 2, "Constructor with size and initial val specified.");
////        
////        
//        //tests 3 and 4, int[][] constructor, deep copy
//        data1 = new int[][]{{1,1,1},{-1,-2,-6},{3,8,9}};
//        mat1 = new MathMatrix( data1 );
//        data1[0][0] = 2;
//        // alter data1. mat1 should be unchanged if deep copy made
//        e1 = new int[][] { {2,1,1},{-1,-2,-6},{3,8,9} };
//        printTestResult( data1, e1, 3, "constructor with one parameter of type int[][]");
//        // data1 altered. mat1 should be unchanged if deep copy made
//        e1 = new int[][] { {1,1,1},{-1,-2,-6},{3,8,9} };
//        printTestResult( get2DArray(mat1), e1, 4, "constructor with one parameter of type int[][]. Testing deep copy made.");
//
//        //tests 5 - 7, addition
//        data1[0][0] = 1;
//        mat1 = new MathMatrix(data1);
//        data2 = new int[][] {{8,1,0},{1,2,6},{1,8,9}};
//                             
//        MathMatrix mat2 = new MathMatrix(data2);
//        MathMatrix mat3 = mat1.add(mat2);
//        e1 = new int[][] {{1,1,1},{-1,-2,-6},{3,8,9}  };
//        printTestResult( get2DArray(mat1), e1, 5, "add method. Testing mat1 unchanged.");
//        e1 = new int[][] { {8,1,0},{1,2,6},{1,8,9}};
//        printTestResult( get2DArray(mat2), e1, 6, "add method. Testing mat2 unchanged.");
//        e1 = new int[][] { {9, 2, 1}, {0, 0, 0},{4,16,18}  };
//        printTestResult( get2DArray(mat3), e1, 7, "add method. Testing mat3 correct result.");
//
//        //test 8-9, multiplication
//        data1= new int[][] {{1,0,0},{0,1,0},{0,0,1}};
//        data2 = new int[][] { {3,1, 2}, {3,2,1}, {2, 1, 3}  };
//        mat2 = new MathMatrix(data2);
//        mat1 = new MathMatrix(data1);
//        mat3 = mat2.multiply(mat1);
//        e1 = new int[][] { {3,1, 2}, {3,2,1}, {2, 1, 3}  };
//        printTestResult( get2DArray(mat3), e1, 8, "multiply method");
//        data1 =new int[][] {{1,1},{1,1}};
//        data2 = new int[][] { {3,1,3}, {3,2,4} };
//        mat2 = new MathMatrix(data2);
//        mat1 = new MathMatrix(data1);
//        mat3 = mat1.multiply(mat2);
//        e1 = new int[][] { {6,3, 7},{6,3, 7}};
////        System.out.println(mat3.toString());
//        printTestResult( get2DArray(mat3), e1, 9, "multiply method");
//
//        //test 10-11, toString()
//
////        System.out.println(mat1.toString());
//        String expected = " 1 1\n 1 1\n";
//        if( mat1.toString().equals( expected ) )
//            System.out.println("passed test 10, toString method.");
//        else
//            System.out.println("failed test 10, toString method.");
//        data1 = new int[][] {{-123, -4, -3}};
//        mat1 = new MathMatrix(data1);
//        expected = " -123   -4   -3\n";
//                if( mat1.toString().equals( expected ) )
//            System.out.println("passed test 11, toString method.");
//        else
//            System.out.println("failed test 11, toString method.");
//        
//                
//        //test 12-13 subtract
//        data1= new int[][] {{1,0,0},{0,1,0},{0,0,1}};
//        data2 = new int[][] {{1,0,0},{0,1,0},{0,0,1}};
//        mat1 = new MathMatrix(data1);
//        mat2 = new MathMatrix(data2);
//        mat3 = mat1.subtract(mat2);
//        e1 = new int[][] {{0, 0, 0}, {0, 0, 0},{0, 0, 0}};
//        printTestResult( get2DArray(mat3), e1, 12, "subtract method. Testing mat3 correct result.");
//        mat3 = mat3.subtract(mat1);
//        e1 = new int[][] {{-1, 0, 0}, {0, -1, 0},{0, 0, -1}};
//        printTestResult( get2DArray(mat3), e1, 13, "subtract method. Testing mat3 correct result.");
//        
//
//        //test 14-15 changeElement
//        mat1.changeElement(0, 0, 100);
//        e1 = new int[][]{{100,0,0},{0,1,0},{0,0,1}};
//        printTestResult( get2DArray(mat1), e1, 14, "changeElement method.");
//        
//        mat1.changeElement(1, 0, 200);
//        e1 = new int[][]{{100,0,0},{200,1,0},{0,0,1}};
//        printTestResult( get2DArray(mat1), e1, 15, "changeElement method.");
//        
//        //test 16-17 equals
//        data1 = new int[][] {{1, 2, 3, 0}, {0, 3, 2, 3}, {0, 0, 4, -1}, {1, 2, 3, 4}};
//        mat1 = new MathMatrix(data1);
//        mat2 = new MathMatrix(data1);
//        System.out.print("Test number 16 tests equals method. ");
//        System.out.println(mat1.equals(mat2)? "Pass": "Fail");
//        data1[0][3]=3;
//        mat2 = new MathMatrix(data1);
//        System.out.print("Test number 17 tests equals method. ");
//        System.out.println(mat1.equals(mat2)? "Fail": "Pass");
//
//        //test 18-19 scale
//        data1 = new int[][] {{1, 2, 3, 0}, {0, 3, 2, 3}, {0, 0, 4, -1}, {1, 2, 3, 4}};
//        mat1 = new MathMatrix(data1);
//        mat1.scale(2);
//        e1 = new int[][]{{2,4,6,0},{0, 6, 4, 6}, {0, 0, 8, -2}, {2, 4, 6, 8}};
//        printTestResult( get2DArray(mat1), e1, 18, "scale method.");
//        mat1 = new MathMatrix(2,2,1);
//        mat1.scale(5);
//        e1 = new int[][]{{5,5},{5,5}};
//        printTestResult( get2DArray(mat1), e1, 19, "scale method.");
//        
//        //test 20-21 getVal
//        data1 = new int[][] {{1, 2, 3, 0}, {0, 3, 2, 3}, {0, 0, 4, -1}, {1, 2, 3, 4}};
//        mat1 = new MathMatrix(data1);
//        mat2 = new MathMatrix(3,3,3);
//        System.out.print("Test number 20 tests getVal method. ");
//        System.out.println(mat1.getVal(2, 3)==-1 ? "Pass": "Fail");
//        System.out.print("Test number 21 tests getVal method. ");
//        System.out.println(mat2.getVal(0, 0)==3 ? "Pass": "Fail");
//
//        //test 22-23 numCols
//        data1 = new int[][] {{1, 2, 3, 0}, {0, 3, 2, 3}, {0, 0, 4, -1}, {1, 2, 3, 4}};
//        mat1 = new MathMatrix(data1);
//        mat2 = new MathMatrix(3,3,3);
//        System.out.print("Test number 22 tests numCols method. ");
//        System.out.println(mat1.numCols()==4 ? "Pass": "Fail");
//        System.out.print("Test number 23 tests numCols method. ");
//        System.out.println(mat2.numCols()==3 ? "Pass": "Fail");
//        
//        
//        //test 24-25 numRows
//        data1 = new int[][] {{1, 2, 3, 0}, {0, 3, 2, 3}, {0, 0, 4, -1}, {1, 2, 3, 4}};
//        mat1 = new MathMatrix(data1);
//        mat2 = new MathMatrix(3,3,3);
//        System.out.print("Test number 24 tests numRows method. ");
//        System.out.println(mat1.numCols()==4 ? "Pass": "Fail");
//        System.out.print("Test number 25 tests numRows method. ");
//        System.out.println(mat2.numCols()==3 ? "Pass": "Fail");
//        
//        
//        //test 26-28, upperTriangular
//        data1 = new int[][] {{4,5,4,5}, {0, 3, 22, 1}, {0, 0, 14, -10}, {0, 0, 0, 112}};
//        mat1 = new MathMatrix(data1);
//        if( mat1.isUpperTriangular())
//            System.out.println("Test number 28 tests isUpperTriangular method. Pass.");
//        else
//            System.out.println("Test number 28 tests isUpperTriangular method. Pass.");
//        
//
//        mat1 = new MathMatrix(3,3,3);
//        if( !mat1.isUpperTriangular())
//            System.out.println("Test number 27 tests isUpperTriangular method. Pass.");
//        else
//            System.out.println("Test number 27 tests isUpperTriangular method. Fail.");   
//        
//        mat1 = new MathMatrix(3,3,0);
//        if( mat1.isUpperTriangular())
//            System.out.println("Test number 28 tests isUpperTriangular method. Pass.");
//        else
//            System.out.println("Test number 28 tests isUpperTriangular method. Pass.");         
//        
//        
//        
//        //test 29-30 getTranspose
//        data1 = new int[][] {{1, 2},{3,4}};
//        mat1 = new MathMatrix(data1);
//        mat2 = mat1.getTranspose();
//        e1 = new int[][]{{1,3},{2,4}};
//        printTestResult( get2DArray(mat2), e1, 29, "getTranspose method.");
//        data1 = new int[][] {{1, 2}};
//        mat1 = new MathMatrix(data1);
//        mat2 = mat1.getTranspose();
////        System.out.println(mat1.toString()+"\n");
////        System.out.println(mat2.toString()+"\n");
//        e1 = new int[][]{{1},{2}};
//        printTestResult( get2DArray(mat2), e1, 30, "scale method.");
////        //test transpose
////        data1 = new int[][] {{1,2},{3,4}};
////        mat1 = new MathMatrix(data1);
////        System.out.println(mat1.toString()+"\n");
////        System.out.println(mat1.getTranspose().toString()+"\n");
////        
//        
//     
//    }
//
//    private static void printTestResult(int[][] data1, int[][] data2, int testNum, String testingWhat) {
//        System.out.print( "Test number " + testNum + " tests the " + testingWhat +". The test ");
//        String result = equals(data1, data2) ? "passed" : "failed";
//        System.out.println( result );
//    }
//    private static void exp1 (int dim){
//        Stopwatch s = new Stopwatch();
//        MathMatrix mat1 = new MathMatrix(dim,dim,(int)Math.random()*100);
//        MathMatrix mat2 = new MathMatrix(dim,dim,(int)Math.random()*100);
//        double avgTime = 0;
//        
//        for (int i=0;i<100;i++){
//        s.start();
//        mat1.add(mat2);
//        s.stop();
//        System.out.println("it took: "+s.time()+" to add two "+ dim+"x"+dim+" matrices");
//        avgTime+=s.time();
//                }
//        System.out.println("avg time: "+avgTime/100+" dim: "+dim);
//        }
//    private static void exp2 (int dim){
//        Stopwatch s = new Stopwatch();
//        MathMatrix mat1 = new MathMatrix(dim,dim,(int)Math.random()*100);
//        MathMatrix mat2 = new MathMatrix(dim,dim,(int)Math.random()*100);
//        double avgTime = 0;
//        
//        for (int i=0;i<100;i++){
//        s.start();
//        mat1.multiply(mat2);
//        s.stop();
//        System.out.println("it took: "+s.time()+" to multiply two "+ dim+"x"+dim+" matrices");
//        avgTime+=s.time();
//                }
//        System.out.println("avg time: "+avgTime/100+" dim: "+dim);
//        }
//
//    // pre: m != null, m is at least 1 by 1 in size
//    private static int[][] get2DArray(MathMatrix m) {
//        //check precondition
//        assert ( m != null ) && ( m.numRows() > 0 ) && ( m.numCols()> 0 )
//                : "Violation of precondition: get2DArray";
//
//        int[][] result = new int[m.numRows()][m.numCols()];
//        for(int r = 0; r < result.length; r++)
//        {   for(int c = 0; c < result[0].length; c++)
//            {   result[r][c] = m.getVal(r,c);
//            }
//        }
//        return result;
//    }
//
//    // pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1 matrices
//    //      data1 and data2 are rectangular matrices
//    // post: return true if data1 and data2 are the same size and all elements are
//    //      the same
//    private static boolean equals(int[][] data1, int[][] data2) {
//       //check precondition
//        assert ( data1 != null ) && ( data1.length > 0 )
//               && ( data1[0].length > 0 ) && rectangularMatrix( data1 )
//               &&  ( data2 != null ) && ( data2.length > 0 )
//               && ( data2[0].length > 0 ) && rectangularMatrix( data2 )
//                : "Violation of precondition: get2DArray";
//
//        boolean result = (data1.length == data2.length) && (data1[0].length == data2[0].length);
//        int row = 0;
//        int col;
//        while( result && row < data1.length ) {
//            col = 0;
//            while( result && col < data1[0].length ) {
//               result = ( data1[row][col] == data2[row][col] );
//                col++;
//            }
//            row++;
//        }
//
//        return result;
//    }
//
//
//    // private method to ensure mat is rectangular
//    // pre: mat != null, mat is at least 1 by 1
//    private static boolean rectangularMatrix( int[][] mat ) {
//       //check preconditions
//        assert (mat != null) && (mat.length > 0) && (mat[0].length > 0)
//               : "Violation of precondition : rectangularMatrix";
//
//        boolean isRectangular = true;
//        int row = 1;
//        final int COLUMNS = mat[0].length;
//
//        while( isRectangular && row < mat.length ){
//            isRectangular = ( mat[row].length == COLUMNS );
//            row++;
//        }
//
//        return isRectangular;
//    }
//    
}}

