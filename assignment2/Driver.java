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

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to Mastermind.");
		System.out.println("Do you want to play a new game? (Y/N):");
		int guessNumber = GameConfiguration.guessNumber;
		Scanner input = new Scanner(System.in);
		String gameplay = input.nextLine();
		boolean mode = false;
		
		if(args.length > 0) {
		mode = (args[0].equals("1"));
		}
		
		while (gameplay.equals("Y")) {
			History history = new History();
			Game newGame = new Game(mode, input, history, guessNumber);
			gameplay = newGame.runGame();
		}

	}

}
