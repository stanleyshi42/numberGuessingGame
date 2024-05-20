package numberGuessingGame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameMenu {
	public static void gameMenu(int difficulty) {
		Scanner sc = new Scanner(System.in);
		int answer = generateAnswer(difficulty);
		int attempts = 0;
		int guessesRemaining = getGuesses(difficulty); // Number of guesses for this difficulty
		int highestAns = getHighestAnswer(difficulty); // Highest possible answer for this difficulty

		while (true) {
			try {
				System.out.println("Guesses left: " + guessesRemaining);
				System.out.println("Guess a number between 1 and " + highestAns + ": ");
				int guess = sc.nextInt();

				attempts++;
				guessesRemaining--;
				if (guess < answer)
					System.out.println("Your guess is lower!");
				else if (guess > answer)
					System.out.println("Your guess is higher!");
				else if (guess == answer) {
					System.out.println("You guessed the number!!!");
					System.out.println("You guessed the number in " + attempts + " guesses");
					System.out.println("Hit enter to return");

					sc.nextLine(); // Needs 2 for some reason
					sc.nextLine();
					return; // Return to main menu
				}

				if (guessesRemaining <= 0) {
					System.out.println("You lose!");
					System.out.println("The number was " + answer);
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

	// Generates a random answer based on the difficulty
	private static int generateAnswer(int difficulty) {
		Random rand = new Random();

		if (difficulty == 1)
			return rand.nextInt(49) + 1; // 1-50
		else if (difficulty == 2)
			return rand.nextInt(99) + 1; // 1-100
		else
			return rand.nextInt(499) + 1; // 1-500
	}

	private static int getHighestAnswer(int difficulty) {
		if (difficulty == 1)
			return 50;
		else if (difficulty == 2)
			return 100;
		else
			return 500;
	}

	private static int getGuesses(int difficulty) {
		if (difficulty == 1)
			return 10;
		else if (difficulty == 2)
			return 9;
		else
			return 8;
	}
}
