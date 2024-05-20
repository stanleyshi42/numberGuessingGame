package numberGuessingGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMenu {
	public static void gameMenu(int difficulty, int timed) {
		Scanner sc = new Scanner(System.in);
		NumberGame game;
		if (timed == 1) {
			game = new TimedGame(difficulty);
		} else {
			game = new NumberGame(difficulty);
		}

		while (true) {
			try {
				System.out.println("Guesses left: " + game.guessesRemaining);
				System.out.println("Guess a number between 1 and " + game.highestAns + ": ");
				int guess = sc.nextInt();

				game.guess(guess); // Process the player's guess

			} catch (InputMismatchException e) {
				System.out.println("Error: Invalid input");
				sc.nextLine(); // Clear scanner buffer
			} catch (Exception e) {
				e.printStackTrace();
				sc.nextLine(); // Clear scanner buffer
			}
		}
	}

}
