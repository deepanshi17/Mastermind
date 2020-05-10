/*
 * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data. 
 * <Deepanshi Sharma>
 * <ds52384>
 * Slip days used: <0>
 * Spring 2020
 */

package assignment2;


public class Guess {
	public String input;
	public char[] guess;
	public int isValid;
	
	
	public Guess(String maybe_guess) {
		input = maybe_guess;
		guess = new char[GameConfiguration.pegNumber];
		guess = input.toCharArray();
		isValid  = 0;
	}
	
	public int isValid() {	
		
		if(input.equals("HISTORY")) return 0;		//print history returns 0			
		
		if(guess.length != GameConfiguration.pegNumber) return -1;
		
		for(int i = 0; i < guess.length; i++) {
			isValid = 0;
			for(int j = 0; j < GameConfiguration.colors.length; j++) {
				if(GameConfiguration.colors[j].charAt(0) == guess[i]) {
					isValid = 1;
					j = ((GameConfiguration.colors.length)-1);
				}
				if(j == ((GameConfiguration.colors.length)-1) && isValid == 0) return -1;		//invalid guess returns -1
			}
		}
		return 1;		//valid guess returns 1
	}
	
	public char[] getChar() {
		return guess;
	}

}
