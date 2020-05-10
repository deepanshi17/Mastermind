

package assignment2;

import java.util.*;

public class History {
	public ArrayList<String> history;
	private int size;
	
	public History() {
		 history = new ArrayList<String>();
		 size = 0;
	}
	
	public void add(String pegs, Guess guess) {
		history.add(guess.input + " -> " + pegs);
		size++;
	}
	
	public void print() {
		for(int i = 0; i < history.size(); i++) {
			System.out.println(history.get(i));
		}
	}
	
	public void printLast() {
		System.out.println(history.get(size-1));
	}
	
}
