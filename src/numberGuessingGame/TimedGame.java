package numberGuessingGame;

import java.util.Timer;
import java.util.TimerTask;

public class TimedGame extends NumberGame {
	int timeRemaining;
	Timer timer;

	TimedGame(int difficulty) {
		super(difficulty);
		this.timeRemaining = generateTimeRemaining(difficulty);
		this.timer = new Timer();
		System.out.println("Time remaining: " + this.timeRemaining);

		// Executes the countdown function every second
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				countdown();
			}
		}, 0L, 1000L);

	}

	private void countdown() {
		if (this.win || this.lose)
			this.timer.cancel();

		this.timeRemaining--;

		// Print the timer every 10 seconds
		if (this.timeRemaining % 10 == 0)
			System.out.println("Time remaining: " + this.timeRemaining);

		if (this.timeRemaining <= 0) {
			this.timer.cancel();
			System.out.println("Out of time!");
			loseGame();
		}
	}

	public int generateTimeRemaining(int difficulty) {
		if (difficulty == 1)
			return 60;
		else if (difficulty == 2)
			return 45;
		return 3;
	}
}
