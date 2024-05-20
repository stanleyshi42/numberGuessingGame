package tests;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import numberGuessingGame.GameMenu;

public class GameMenuTest {

	@Test
	// Tests that the random number is within the correct range
	public void testGenerateAnswer() {
		int rand;
		for (int i = 0; i < 500; i++) {
			rand = GameMenu.getHighestAnswer(1);
			assertTrue(rand > 0 && rand < 51);
		}
		for (int i = 0; i < 1000; i++) {
			rand = GameMenu.getHighestAnswer(2);
			assertTrue(rand > 0 && rand < 101);
		}
		for (int i = 0; i < 5000; i++) {
			rand = GameMenu.getHighestAnswer(3);
			assertTrue(rand > 0 && rand < 501);
		}
	}

	@Test
	public void testGetHighestAnswer() {
		assertEquals(50, GameMenu.getHighestAnswer(1));
	}
}
