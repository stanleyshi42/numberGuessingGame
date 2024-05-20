package numberGuessingGame;

import java.util.Scanner;

public class MainMenu {
	public static void mainMenu() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Welcome to the Number Guessing Game!");
			System.out.println("Select a difficulty: ");
			System.out.println("1. Easy");
			System.out.println("2. Medium");
			System.out.println("3. Hard");
		}
	}
}
