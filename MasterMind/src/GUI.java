//All GUI ELEMENTS
public class GUI {
	// Instance Variables
	private int tries = 0;
	private boolean play = true;
	private boolean won = false;
	private boolean showCode;
	char[] input;
	String[] pegs = new String[] { "====", "====", "====", "====", "====", "====",
			"====", "====", "====", "====", "====", "====" };

	String[] inputs = new String[] { "....", "....", "....", "....", "....",
			"....", "....", "....", "....", "....", "....", "...." };

	String menu = "Welcome to Mastermind.\n\n\n"
			+ "This is a text version of the classic board game Mastermind.\n"
			+ "The computer will think of a secret code.\n"
			+ "The code consists of 4 colored pegs.\n"
			+ "The pegs may be one of six colors: blue, green , orange, purple, red, or yellow.\n"
			+ "A color may appear more than once in the code.\n\n"
			+

			"You try to guess what colored pegs are in the code and what order they are in\n"
			+ "After making a guess the result will be displayed.\n"
			+ "A result consists of a black peg for each peg you have exactly correct (color and position) in your guess.\n"
			+ "For each peg in the guess that is the correct color, but is out of position, you get a white peg.\n\n"
			+

			"Only the first letter of the color is displayed. b for blue, r for red, and so forth.\n"
			+ "When entering guesses you only need to enter the first character of the color.\n\n\n"
			+

			"You have " + (12)
			+ " to guess the answer or you lose the game.\n\n";

	Colors c = new Colors();
	Pegs p = new Pegs(c);

	// Input i = new Input();

	// Constructor
	public GUI(boolean easy){
		showCode=easy;
		showMenu();
		boolean inputIsNotGood = true;
		//start game
		while(play){
			while(tries<12 && !won){
				System.out.print("What is your guess: ");
				Input i = new Input();
				input = i.getInput();
				System.out.println();
				inputIsNotGood=c.goodInputValues(input);
				while(!inputIsNotGood){
					System.out.print("bad guess. Please guess blue, green , orange, purple, red, or yellow: ");
					i = new Input();
					input = i.getInput();
					inputIsNotGood=c.goodInputValues(input);
				}
//				System.out.println("So far, so good!");
				inputs[tries]=prettyPrint(input);
//				System.out.println(inputs[tries]);

				p.countPegs(input);
				pegs[tries]=p.getPegs();
//				System.out.println(pegs[tries]);
				//prints secret code if chosen to show
				System.out.println(showCode?prettyPrint(c.getCode())+" Secret Code":"");
				//prints guesses and pegs
				
				for (int c =0;c<12;c++){
					System.out.println(inputs[c]+" Result "+pegs[c]);
				}
				
				//win	
				if (pegs[tries].equals("Black Black Black Black ")){
					won=true;
					int triesPrint = tries+1;
					System.out.println("Great job, you won!\nIt took you "+triesPrint+" guess(es) to guess the code.");
					System.out.print("Again? y to go, n to exit: ");
					i = new Input();
					String choice = i.getInputStr();
					if (!choice.equals("y")){
						System.out.println("Goodbye!");
						play=false;
						}
					else{
						reset(0);
						System.out.println(showCode?prettyPrint(c.getCode())+" Secret Code":"");
						}
			}
				else{
				tries++;
				System.out.println("You have "+(int)(12-tries)+" left.");
				}
			}
//		System.out.println("out of won and tries loop");
		if (play){
			System.out.print("You lost... the code was: "+prettyPrint(c.getCode())+" play again (y to play again, n to exit)? ");
			
		Input i = new Input();
		String choice = i.getInputStr();
		if (!choice.equals("y")){
			System.out.println("Goodbye!\n\n");
			play=false;
			}
		else{
			reset(0);
			}
		}
//		System.out.println("after final conditions");
		}
	}
	
	public void reset(int whichLoop){
		tries=whichLoop; won=false;
		pegs = new String[] { "====", "====", "====", "====", "====", "====",
			"====", "====", "====", "====", "====", "====" };

		inputs = new String[] { "....", "....", "....", "....", "....",
				"....", "....", "....", "....", "....", "....", "...." };
		c = new Colors();
		p = new Pegs(c);
//		input = new char[4];
	}
	public String prettyPrint(char[] input) {
		String print = "";
		for (char x : input)
			print += x;
		return print;
	}

	public void showMenu() {
		System.out.println(menu
				+ (showCode ? "Secret Code is: " + prettyPrint(c.getCode())
						+ "\n\n" : "Secret Code not shown\n\n"));
	}

	public boolean loopThrough() {
		boolean inputIsNotGood = true;
		while (play)
			while (tries < 12 && !won) {
				System.out.print("What is your guess? ");
				Input i = new Input();
				input = i.getInput();
				System.out.println();
				inputIsNotGood = c.goodInputValues(input);
				while (!inputIsNotGood) {
					System.out.println("bad guess");
					i = new Input();
					input = i.getInput();
					inputIsNotGood = c.goodInputValues(input);
				}
				System.out.println("So far, so good!");
				inputs[tries] = prettyPrint(input);
				// System.out.println(inputs[tries]);

				p.countPegs(input);
				pegs[tries] = p.getPegs();
				// System.out.println(pegs[tries]);
				System.out.println(showCode ? prettyPrint(c.getCode())
						+ " Secret Code" : "");
				for (int c = 0; c < 12; c++) {
					System.out.println(inputs[c] + " Result " + pegs[c]);
				}
				if (pegs[tries].equals("Black Black Black Black ")) {
					won = true;
					System.out.println("Great job, you won!\nIt took you: "
							+ tries + " to guess the code");
				}
				tries++;
			}
		return won;
	}

}
