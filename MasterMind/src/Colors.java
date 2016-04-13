import java.util.Random;

// Manages colors and such.
public class Colors {
	// instance vars
	
	public final char[] validColors = new char[]{'b','g','o','p','r','y'};
	private final char[] secretCode = new char[4];
	
	
	//Constructor
	public Colors(){
		generateSecretCode();
	}
	
	//Methods
	
	// Secret Code Generator
	//pre:none
	//post:generateSecretCodes the secret code randomly
	private void generateSecretCode(){
		Random r = new Random();
		for (int i=0;i<4;i++){
			secretCode[i]=(validColors[r.nextInt(6)]);
		}
		
			
	}
	public char[] getCode(){
		return secretCode;
	}
	// This method checks if the user has inputed the correct number of characters
	//pre: input[]!=null
	//post: returns true if #of inputs =4, false otherwise.
	public boolean goodNumberOfInputs(char[] input){
		assert input!=null:"No input"; //check if enter = null
		return input.length==4;
	}
	
	//This method checks if user has inputed okay characters
	public boolean goodInputValues(char[] input){
		boolean isGood=goodNumberOfInputs(input);
		int i = 0;
		while (isGood&&i<4){
				isGood=
					(input[i]=='b'||input[i]=='B'||
					input[i]=='g'||input[i]=='G'||
					input[i]=='o'||input[i]=='O'||
					input[i]=='p'||input[i]=='P'||
					input[i]=='r'||input[i]=='R'||
					input[i]=='y'||input[i]=='Y');
			i++;
		}
		return isGood;
			
	}

}

