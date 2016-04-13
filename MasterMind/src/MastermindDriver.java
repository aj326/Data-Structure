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


public class MastermindDriver {
	public static String prettyPrint(char[] input)
	{
		String print="";
		for (char x:input)
			print+=x;
		return print;
	}
    public static void main(String[] args){
    	
        Game g = new Game(true);
        g.runGames();
        g = new Game(false);
        g.runGames();
    }

}
