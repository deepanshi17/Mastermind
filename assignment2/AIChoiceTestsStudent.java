package assignment2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AIChoiceTestsStudent {

	static SecretCodeGenerator scg;
	static boolean DEBUG = false;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		scg = SecretCodeGenerator.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMaxNoGuesses() {
		Computer.reset();
		String secretCode = scg.getNewSecretCode();
		if (DEBUG)
			System.out.println("Secret Code is " + secretCode);
		int guessesSoFar = 0;
		int maxGuesses = 50;

		while (guessesSoFar <= maxGuesses) {
			String guess = Computer.pickNextGuess();
			if (DEBUG)
				System.out.println("Computer guessed " + guess);
			guessesSoFar++;
			Response result = CheckGuess.checkGuess(guess, secretCode);
			if (result.won()) 
				break;
			Computer.setLastResponse(result);
		}

		if (guessesSoFar > maxGuesses)
			fail ("Too many guesses -- " + guessesSoFar);
		if (DEBUG)
			System.out.println(guessesSoFar);
	}
	
	@Test
	public void TestMultipleMaxGuesses () {
		for (int i = 0; i < 1000; i++) {
			testMaxNoGuesses();
		}
	}
}
