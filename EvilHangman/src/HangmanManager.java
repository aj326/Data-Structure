/*  Student information for assignment:
 *
 *  On my honor, <NAME>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID:
 *  email address:
 *  Grader name:
 *  Number of slip days I am using:
 */

// add imports as necessary

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HangmanManager {

    // instance vars
	ArrayList<String> activeWordList = new ArrayList<String>();
	ArrayList<Character> guessList = new ArrayList<Character>();
	String secretWord;
	char activeG=' ';
	int correctG, wrongG, countG, numOfG, wordLength, diff;
    
    public HangmanManager(List<String> words) {
    	for (String word: words){
    		activeWordList.add(word);
    	}

    }
    
    
    // pre: none
    // post: return the number of words in the original Dictionary with the given length
    public int numWords(int length) {
    	int c = 0;
    	for (String word: activeWordList)
    		if (word.length()==length)
    			c++;
        return c;
    }


    // pre: numWords(wordLen) > 0, numGuesses >= 1, HangmanMain.EASY <= difficulty <= HangmanMain.HARD
    public void reset(int wordLen, int numGuesses, int diff) {
    	if (numWords(wordLen)!=0 && numGuesses>0 && diff>=HangmanMain.EASY && diff<=HangmanMain.HARD){
    		throw new IllegalStateException();
    	}
    	else{
    		wordLength=wordLen;
    		numOfG = numGuesses;
    		this.diff=diff;
    		activeWordList = new ArrayList<String>();
    		guessList = new ArrayList<Character>();
    		
    		
    	}

    }
    
    
    
    // pre: none
    // return the number of words that are still possibilities
    public int numWordsCurrent() {
        return activeWordList.size();
    }
    
    // pre: none
    // return number of wrong guesses left in this game
    public int getGuessesLeft() {
        return numOfG-wrongG;
    }
    
    
    // pre: none
    // post: return a String version of the guesses made so far
    public String getGuessesMade() {
        return guessList.toString();
    }
    
    
    // pre: none
    // post: return true if guess has already been used, false otherwise
    public boolean alreadyGuessed(char guess) {
        return guess==activeG;
    }
    
    // get the current pattern. (In other words the revealed characters and '-'s
    // for characters not yet revealed.
    public String getPattern() {
        return "DEFAULT";
    }
    
    // pre: !alreadyGuessed(ch)
    // post: return a map with the resulting patterns and the number of
    // words in each of the new patterns
    public Map<String, Integer> makeGuess(char guess) {
        
        return null;
    }
    
    



    // pre: numWordsCurrent() > 0
    // return the secret word the manager picked 
    // if there is more than one word left, pick one at random
    public String getSecretWord() {
        return secretWord;
    }
}
