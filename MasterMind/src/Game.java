
public class Game {


	// if showCode is true then the secret code is revealed before
	// the game starts. This will be used by graders of the program
	// to test the feedback of guesses
    private boolean showCode;

    public Game(boolean easy){
        showCode = easy;
    }

    public void runGames(){
    	GUI gui = new GUI(showCode);
//    	gui.showMenu();
//    	System.out.println("in Game");
    }
}
