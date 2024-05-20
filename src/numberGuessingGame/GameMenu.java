package numberGuessingGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMenu {
	public static void gameMenu(Scanner sc, int difficulty, int timed) {
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

				if (guess < 1 || guess > game.highestAns)
					throw new InputMismatchException();

				game.guess(guess); // Process the player's guess

				if (game.win || game.lose) {
					System.out.println("Hit enter to return");
					sc.nextLine();
					sc.nextLine();
					return; // Return to main menu
				}

			} catch (InputMismatchException e) {
				System.out.println("Error: Invalid input");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
