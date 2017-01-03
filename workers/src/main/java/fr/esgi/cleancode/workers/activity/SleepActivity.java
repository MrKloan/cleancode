package fr.esgi.cleancode.workers.activity;

import fr.esgi.cleancode.workers.Worker;

public class SleepActivity implements Activity {
	@Override
	public void proceed(Worker worker, int start, int end) {
		System.out.println("Worker " + worker.getName() + " slept from " + start + " to " + end + ".");
	}
}
