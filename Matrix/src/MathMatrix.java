//  MathMatrix.java - CS314 Assignment 2

/*  Student information for assignment:
 *
 *  On my honor, Ahmed AlJehairan, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: aa29665
 *  email address: ahmed24633@gmail.com
 *  Grader name: Yuanzhong
 *  Number of slip days I am using:0
 */


/**
 * A class that models systems of linear equations (Math Matrices)
 * as used in linear algebra.
 *
 * @version Skeleton file for students
 */
public class MathMatrix
{
    // instance variables
    int [][] values;
    

    
    /**
     * create a MathMatrix with cells equal to the values in mat.
     * A "deep" copy of mat is made.
     * Changes to mat after this constructor do not affect this
     * Matrix and changes to this MathMatrix do not affect mat
     * @param  mat  mat !=null, mat.length > 0, mat[0].length > 0,
     * mat is a rectangular matrix
     */
    public MathMatrix(int[][] mat) {
        // check the precondition. rectangularMatrix is a private method at end of Matrix class
        assert ( mat != null ) && ( mat.length > 0 ) && ( mat[0].length > 0 )
                && ( rectangularMatrix(mat) ) : "Violation of precondition: int[][] Matrix constructor";
        values = new int[mat.length][mat[0].length];
        for (int r=0; r<mat.length;r++)
            System.arraycopy(mat[r], 0, values[r], 0, mat[0].length);
                
    }
    


    /**
     * create a MathMatrix of the specified size with all cells set to the intialValue.
     * <br>pre: numRows > 0, numCols > 0
     * <br>post: create a matrix with numRows rows and numCols columns. 
     * All elements of this matrix equal initialVal.
     * In other words after this method has been called getVal(r,c) = initialVal 
     * for all valid r and c.
     * @param numRows numRows > 0
     * @param numCols numCols > 0
     * @param initialVal all cells of this Matrix are set to initialVal
     */
    public MathMatrix(int numRows, int numCols, int initialVal) {
        assert (numRows>0) && (numCols>0): "Violation of precondition: size and"+
                " initial val specified Matrix constructor";
        
        values = new int[numRows][numCols];
        for (int r=0; r<values.length;r++)
            for (int c=0; c<values[0].length;c++){
                values[r][c]=initialVal;
            }
        
    }


    /**
     * change the value of one of the cells in this MathMatrix.
     * <br>pre: 0 <= row < numRows(), 0 <= col < numCols()
     * <br>post: getVal(row, col) = newValue
     * @param row 0 <= row < numRows()
     * @param col 0 <= col < numCols()
     */
    public void changeElement(int row, int col, int newValue) {
        assert ((row>=0) && row<numRows()) && ((col>=0) && col<numCols()):
                "Violation of precondition: changeElement method";
        values[row][col]=newValue;
    }


    /**
     * Get the number of rows.
     * @return the number of rows in this MathMatrix
     */
    public int numRows() {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
        return values.length; // alter as necessary
    }


    /**
     * Get the number of columns.
     * @return the number of columns in this MathMatrix
     */
    public int numCols() {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
        return values[0].length; // alter as necessary
    }


    /**
     * get the value of a cell in this MathMatrix.
     * <br>pre: row  0 <= row < numRows(), col  0 <= col < numCols()
     * @param  row  0 <= row < numRows()
     * @param  col  0 <= col < numCols()
     * @return the value at the specified position
     */
    public int getVal(int row, int col) {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
        return values[row][col]; // alter as necessary
    }

    
   /**
    * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
    * <br>pre: rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * <br>post: This method does not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * @return a new MathMatrix that is the result of adding this Matrix to rightHandSide.
    * The number of rows in the returned Matrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned Matrix is equal to the number of columns in this MathMatrix.
    */
    private MathMatrix add(MathMatrix rightHandSide, int sign) {
        assert (rightHandSide.numCols()==this.numCols()
                && rightHandSide.numRows()==this.numRows()):
                "Violation of precondition: Matrices are not of equal sizes";
        assert sign==1 || sign ==-1: "Violation of precondition: int sign hast to be 1 or -1";
        MathMatrix result = new MathMatrix(values); //a copy of this
        
     
            for (int r=0; r<result.numRows();r++)
                for (int c=0; c<result.numCols();c++)
                    result.changeElement(r, c, result.getVal(r, c)
                            +sign*rightHandSide.getVal(r, c));
       
            
        
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
        return result; // alter as necessary
    }
    
    public MathMatrix add(MathMatrix rightHandSide){
        return this.add(rightHandSide, 1);
    }


   /**
    * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
    * <br>pre: rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * <br>post: This method does not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * @return a new MathMatrix that is the result of subtracting rightHandSide from this MathMatrix.
    * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned MathMatrix is equal to the number of columns in this MathMatrix.
    */
    public MathMatrix subtract(MathMatrix rightHandSide) {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
        return this.add(rightHandSide,-1); // alter as necessary
    }
    

   /**
    * implements matrix multiplication, (this MathMatrix) * rightHandSide.
    * <br>pre: rightHandSide.numRows() = numCols()
    * <br>post: This method should not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numCols()
    * @return a new MathMatrix that is the result of multiplying this MathMatrix and rightHandSide.
    * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned MathMatrix is equal to the number of columns in rightHandSide.
    */
    public MathMatrix multiply(MathMatrix rightHandSide) {
        assert rightHandSide.numRows()==this.numCols():
                "Violation of precondition: rows must match columns";
        MathMatrix result = 
                new MathMatrix(this.numRows(), rightHandSide.numCols(),0);
        int cell=0;
        for (int colsOfRHS=0; colsOfRHS<rightHandSide.numCols();colsOfRHS++)
            for (int rowsOfLHS=0; rowsOfLHS<this.numRows();rowsOfLHS++){
                cell=0;
                for (int rowsOfRHS=0; rowsOfRHS<rightHandSide.numRows();rowsOfRHS++)
                    cell+=this.getVal(rowsOfLHS, rowsOfRHS)*
                            rightHandSide.getVal(rowsOfRHS, colsOfRHS);
                result.changeElement(rowsOfLHS, colsOfRHS, cell);
            }
        
        
        
        return result; // alter as necessary
    } 


   /**
    * Multiply all elements of this MathMatrix by factor.
    * <br>pre: none
    * <br>post: all elements in this matrix have been multiplied by factor. 
    * In other words after this method has been called getVal(r,c) = old getVal(r, c) * factor
    * for all valid r and c.
    * @param factor the value to multiply every cell in this Matrix by.
    */
    public void scale(int factor) {
        for (int r=0;r<this.numRows();r++)
            for (int c=0;c<this.numCols();c++)
                this.changeElement(r, c, this.getVal(r, c)*factor);
    }


    /**
     * accessor: get a transpose of this MathMatrix. 
     * This Matrix is not changed.
     * <br>pre: none
     * @return a transpose of this MathMatrix
     */
    public MathMatrix getTranspose() {
        MathMatrix result = new MathMatrix(this.numCols(),this.numRows(),0);
        for (int r = 0;r<result.numRows();r++)
            for (int c=0; c<result.numCols();c++)
                result.changeElement(r, c, this.getVal(c, r));
        return result; // alter as necessary
    }


    /**
     * override equals.
     * @return true if rightHandSide is the same size as this MathMatrix and all values in the
     * two MathMatrix objects are the same, false otherwise
     */
    public boolean equals(Object rightHandSide) {
        /* Cs314 Students. The following is standard equals
         * method code. We will learn about it in a few weeks.
         */
        boolean result = false; int c=0; int r=0;
        if( rightHandSide != null && this.getClass() == rightHandSide.getClass()){
            // rightHandSide is a non null MathMatrix
            MathMatrix otherMatrix = (MathMatrix)rightHandSide;
            
            // cs314 students: determine if otherMatrix is equal
            // to this MathMatrix and set result to true if they are.
            
            if (this.numRows()==otherMatrix.numRows()
                    && this.numCols()==otherMatrix.numCols()){
                result = true;
                while (result && r<this.numRows()){
                    while (result && c<this.numCols()){
                        result = this.getVal(r, c)==otherMatrix.getVal(r, c);
                        c++;
                    }
                    c=0; r++;
                }
            }
            
        }
        return result;
    }


    /**
     * override toString.
     * @return a String with all elements of this MathMatrix. 
     * Each row is on a seperate line.
     * Spacing based on longest element in this Matrix.
     */
    // helper method to get longest entry
    private int maxLen(){
        int max=0;
        for (int r=0; r<this.numRows();r++)
            for (int c=0;c<this.numCols();c++)
                max = Math.max(max, ("" + this.getVal(r, c)).length());
        return max+1;
    }
    public String toString(){
        String form = "%1$"+this.maxLen()+"d";
        String output="";
        for (int r=0;r<this.numRows();r++)
            for (int c=0; c<this.numCols();c++){
                output+=String.format(form,this.getVal(r, c));
                
                if(c==this.numCols()-1)
                    output+="\n";
            }
//        System.out.println(output);
            
        return output; // alter as necessary
    }
    
    /**
     * Return true if this MathMatrix is upper triangular. To
     * be upper triangular all elements below the main 
     * diagonal must be 0.<br>
     * pre: this is a square matrix. numRows() == numCols()  
     * @return <tt>true</tt> if this MathMatrix is upper triangular,
     * <tt>false</tt> otherwise. 
     */
    public boolean isUpperTriangular() {
        MathMatrix temp = this.getTranspose(); //to make the coding easier
//        System.out.println(temp.toString());
        boolean result = true;
        int row = 0, col=1;
        while (result && row<temp.numRows()){
            while(result && col<temp.numCols()){
//                System.out.println(row+ ","+ col+ ": "+temp.getVal(row, col)+result);

                result=temp.getVal(row, col)==0;
                col++;
            }
            
            row++;
            col=row+1;
        }
        return result; // alter as necessary
    }
    
    //private method to ensure mat is rectangular
    private boolean rectangularMatrix( int[][] mat ) {
        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;

        while( isRectangular && row < mat.length )
        {   isRectangular = ( mat[row].length == COLUMNS );
            row++;
        }

        return isRectangular;
    }
}