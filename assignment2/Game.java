/*
 * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data. 
 * <Deepanshi Sharma>
 * <ds52384>
 * Slip days used: <0>
 * Spring 2020
 */

package assignment2;

import java.util.Scanner;

public class Game {

	private String SecretCode;
	private int guessNumber;
	
	public Scanner input;
	public History history;
	public String playing = "Y";
	
	

	public Game(boolean mode, Scanner input, History history, int guessNumber) {
		SecretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
		if(mode) {
			System.out.println("SecretCode: " + SecretCode);
			System.out.println();
		}
		this.guessNumber = guessNumber;
		this.input = input;
		this.history = history;
		
	}
	
	public String runGame() {
		System.out.println("You have " + guessNumber + " guess(es) left.");
		System.out.println("Enter guess:");
		String maybe_guess = input.nextLine();
		Guess guess = new Guess(maybe_guess);
		if(guess.isValid() == 1) {				//normal guess
			guessNumber--;		
			Compare toParse = new Compare(SecretCode, guess.getChar());		//get peg status
			Compare result  = toParse.parse();
			history.add(result.resultString, guess);		//update history
			history.printLast();		//print guess and resulting pegs
			
			if(result.black == GameConfiguration.pegNumber) {
				System.out.println("You win!");
				System.out.println();
				System.out.println("Do you want to play a new game? (Y/N):");
				playing = input.nextLine();
			}
			
			else if(guessNumber <= 0) {
				System.out.println("You lose! The pattern was " + SecretCode);
				System.out.println();
				System.out.println("Do you want to play a new game? (Y/N):");
				playing = input.nextLine();
			}	
			else {				//keep playing
				System.out.println();
				playing = runGame();
			}
		}
		else if(guess.isValid() == 0) {			//print history
			if(history.history.size() > 0) {
				history.print();
				playing = runGame();
			}else {							//no history yet
				System.out.println();
				playing = runGame();
			}
		}
		else {
			System.out.println("INVALID_GUESS");
			System.out.println();
			playing = runGame();
		}
		return playing;
	}

}
