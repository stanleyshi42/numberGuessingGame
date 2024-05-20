package numberGuessingGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
	public static void mainMenu() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("Welcome to the Number Guessing Game!");
				System.out.println("Select a difficulty:");
				System.out.println("1. Easy");
				System.out.println("2. Medium");
				System.out.println("3. Hard");
				System.out.println("4. End Program");

				int input = sc.nextInt();

				if (input < 1 || input > 4)
					throw new InputMismatchException();

				if (input == 4)
					System.exit(0);

				System.out.println("Would you like to add a time limit?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				int timed = sc.nextInt();

				switch (input) {
				case (1):
					GameMenu.gameMenu(1, timed);
					break;
				case (2):
					GameMenu.gameMenu(2, timed);
					break;
				case (3):
					GameMenu.gameMenu(3, timed);
					break;
				default:
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Invalid input");
				sc.nextLine();
			} catch (Exception e) {
				e.printStackTrace();
				sc.nextLine();
			}
		}
	}
}
