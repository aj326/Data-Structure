// Returns the White and Black Values.
public class Pegs {

	// instance variables
	private char[] code;
	private int black, white;
	private String pegs="";

	// constructor(s)
	public Pegs(Colors c) {
		code = c.getCode();
	}
//	for testing
	public Pegs(char[] easy){
		code = easy;
	}

	// methods

	// counts how many black/white pegs collected
	// I feel recursion could clean this up...
	// pre: already met by Colors class
	// post: Black/White peg count
	public void countPegs(char[] input) {
		char[] temp = new char[code.length];
		black=0;
		white=0;
		pegs="";
		System.arraycopy(code, 0, temp, 0,4);
		for (int i =0;i<code.length;i++){
			if (temp[i]==input[i] &&temp[i]!=' '){
				temp[i]=' ';
				input[i] = ' ';
				black++;
			}
			}
//			if (black<4)
		for (int i =0;i<code.length;i++)
			for (int j=0;j<code.length;j++){
				if (temp[j]==input[i]&&temp[j]!= ' '){
					temp[j]=' ';
					input[i]= ' ';
					white++;
				}
			}
		}
			

	//returns # of white pegs
	public int numOfWhitePegs() {
		return white;
	}

	//returns # of black pegs
	public int numOfBlackPegs() {
		return black;
	}

	private String printPegs(){
		if (black==0 && white==0)
			pegs="No pegs";
		else{
		for (int i=0; i<black;i++)
			pegs+="Black ";
		
		for (int i=0;i<white;i++)
			pegs+="White ";
		}
		return pegs;
	}
	public String getPegs(){
		return printPegs();
		
	}
	
	
}
	
		

