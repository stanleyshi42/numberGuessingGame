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
			System.out.println("4. End Program");
		
			int input = sc.nextInt();

			if (input == 4)
				System.exit(0);

			switch (input) {
			case (1):
				GameMenu.gameMenu(1);
				break;
			case (2):
				GameMenu.gameMenu(2);
				break;
			case (3):
				GameMenu.gameMenu(3);
				break;

			}
		}
	}
}
