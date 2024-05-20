package numberGuessingGame;

import java.util.Timer;
import java.util.TimerTask;

public class TimedGame extends NumberGame {
	int timeRemaining;

	TimedGame(int difficulty) {
		super(difficulty);
		this.timeRemaining = generateTimeRemaining(difficulty);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				countdown();
			}
		}, 0L, 1000L);

	}

	public void countdown() {
		if (this.timeRemaining % 10 == 0)
			System.out.println("Time remaining: " + this.timeRemaining);
		this.timeRemaining--;

		// Print the timer every 10 seconds

		if (this.timeRemaining <= 0)
			this.lose = true;
	}

	public int generateTimeRemaining(int difficulty) {
		if (difficulty == 1)
			return 60;
		else if (difficulty == 2)
			return 45;
		return 30;
	}
}
