package assignment2;

import java.util.*;

public class Compare {
	char[] secretCode;
	char[] guess;
	String resultString;
	int black;
	int white;
	int pegNumber;
	
	public Compare(String SecretCode, char[] guess) {
		secretCode = new char[pegNumber];
		secretCode = SecretCode.toCharArray();
		this.guess = guess;
		pegNumber = GameConfiguration.pegNumber;
		resultString = new String();
		black = 0;
		white = 0;
	}
	
	public Compare parse() {
		ArrayList<Integer> guessed = new ArrayList<Integer>();
		guessed.clear();
		int skip = -1;
		for(int i = 0; i < secretCode.length; i++) {
			if(secretCode[i] == guess[i]) {
				black++;
			}else {
				for(int j = 0; j < guess.length; j++) {
					if(secretCode[i] == guess[j] && i!=j) {
						if(guess[j] != secretCode[j]) {
							for(int x = 0 ; x < guessed.size(); x++) {
								if(j == guessed.get(x)) {
									skip = 1;
									j = guess.length;
									x = guessed.size();
								}
							}
							if(skip != 1) {
							white++;
							guessed.add(j);
							j = guess.length;
							}
							skip = -1;
						}
						
					}
				}
			}
		}
		resultString = black + "b_" + white + "w";
		return this;
	}
	
	
}
