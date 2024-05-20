package tests;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import numberGuessingGame.NumberGame;

public class NumberGameTest {

	@Test
	// Tests that random numbers are generated within the correct range
	public void testGenerateAnswer() {
		int rand;
		for (int i = 0; i < 5000; i++) {
			rand = NumberGame.generateAnswer(1);
			assertTrue(rand > 0 && rand < 51);
		}
		for (int i = 0; i < 10000; i++) {
			rand = NumberGame.generateAnswer(2);
			assertTrue(rand > 0 && rand < 101);
		}
		for (int i = 0; i < 50000; i++) {
			rand = NumberGame.generateAnswer(3);
			assertTrue(rand > 0 && rand < 501);
		}
	}

}
