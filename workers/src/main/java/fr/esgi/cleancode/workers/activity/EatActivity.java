package fr.esgi.cleancode.workers.activity;

import fr.esgi.cleancode.workers.Worker;

public class EatActivity implements Activity {
	@Override
	public void proceed(Worker worker, int start, int end) {
		System.out.println("Worker " + worker.getName() + " ate from " + start + " to " + end + ".");
	}
}
