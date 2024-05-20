package numberGuessingGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMenu {
	public static void gameMenu(int difficulty, int timed) {
		NumberGame game;
		if (timed == 1) {
			game = new TimedGame(difficulty);
		} else {
			game = new NumberGame(difficulty);
		}
		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("Guesses left: " + game.guessesRemaining);
				System.out.println("Guess a number between 1 and " + game.highestAns + ": ");
				int guess = sc.nextInt();

				game.guess(guess); // Process the player's guess

				if (game.win) {
					System.out.println("You guessed the number!!!");
					System.out.println("You guessed the number in " + game.attempts + " guesses");
					System.out.println("Hit enter to return");
					sc.nextLine(); // Needs 2 for some reason
					sc.nextLine();
					return; // Return to main menu
				}

				if (game.lose) {
					System.out.println("You lose!");
					System.out.println("The number was " + game.answer);
					System.out.println("Hit enter to return");
					sc.nextLine(); // Needs 2 for some reason
					sc.nextLine();
					return; // Return to main menu
				}
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
