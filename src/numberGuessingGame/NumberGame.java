package numberGuessingGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
	int attempts = 0;
	int answer;
	int guessesRemaining; // Number of guesses the player gets
	int highestAns; // Highest possible answer
	boolean win = false;
	boolean lose = false;
	Scanner sc = new Scanner(System.in);

	NumberGame(int difficulty) {
		this.answer = generateAnswer(difficulty);
		this.highestAns = generateHighestAnswer(difficulty);
		this.guessesRemaining = getGuesses(difficulty);
	}

	// Processes the player's guess
	public void guess(int guess) {
		this.attempts++;
		this.guessesRemaining--;

		if (guess < this.answer)
			System.out.println("Your guess is lower!");
		else if (guess > this.answer)
			System.out.println("Your guess is higher!");
		else if (guess == this.answer)
			winGame();

		if (this.guessesRemaining <= 0)
			loseGame();
	}

	public void winGame() {
		this.win = true;
		System.out.println("You guessed the number!!!");
		System.out.println("You guessed the number in " + this.attempts + " guesses");
		System.out.println("Hit enter to return");
		sc.nextLine();

		MainMenu.mainMenu(); // Return to main menu
	}

	public void loseGame() {
		this.lose = true;
		System.out.println("You lose!");
		System.out.println("The number was " + this.answer);
		System.out.println("Hit enter to return");
		sc.nextLine();

		MainMenu.mainMenu(); // Return to main menu
	}

	// Generates a random answer based on the difficulty
	public static int generateAnswer(int difficulty) {
		Random rand = new Random();

		if (difficulty == 1)
			return rand.nextInt(49) + 1; // 1-50
		else if (difficulty == 2)
			return rand.nextInt(99) + 1; // 1-100
		else
			return rand.nextInt(499) + 1; // 1-500
	}

	public static int generateHighestAnswer(int difficulty) {
		if (difficulty == 1)
			return 50;
		else if (difficulty == 2)
			return 100;
		else
			return 500;
	}

	public static int getGuesses(int difficulty) {
		if (difficulty == 1)
			return 10;
		else if (difficulty == 2)
			return 9;
		else
			return 8;
	}
}
