package numberGuessingGame;

import java.util.Random;
import java.util.Scanner;

public class GameMenu {
	public static void gameMenu(int difficulty) {
		Scanner sc = new Scanner(System.in);
		int answer = generateAnswer(difficulty);
		int attempts = 0;
		System.out.println("answer "+answer); // TODO delete
		while (true) {
			System.out.println("Guess a number: ");

			int guess = sc.nextInt();

			attempts++;
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
				return;	// Return to main menu
			}
		}
	}

	// Generates a random number based on the difficulty
	private static int generateAnswer(int difficulty) {
		Random rand = new Random();

		if (difficulty == 1)
			return rand.nextInt(49) + 1;	// 1-50
		else if (difficulty == 2)
			return rand.nextInt(99) + 1;	// 1-100
		else
			return rand.nextInt(499) + 1;	// 1-500

	}
}
