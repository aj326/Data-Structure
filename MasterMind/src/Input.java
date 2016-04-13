import java.util.Scanner;


public class Input {
	private Scanner input = new Scanner(System.in);
	private String raw_in;
	
	public Input(){
		if(input.hasNext()){  raw_in=input.next();}
					}
	public char[] getInput(){
		return raw_in.toLowerCase().toCharArray();
	}
	public String getInputStr(){
		return raw_in.toLowerCase();
	}

}
