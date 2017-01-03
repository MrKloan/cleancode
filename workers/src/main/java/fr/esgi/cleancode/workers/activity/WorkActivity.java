package fr.esgi.cleancode.workers.activity;

import fr.esgi.cleancode.workers.Worker;

public class WorkActivity implements Activity {
	@Override
	public void proceed(Worker worker, int start, int end) {
		System.out.println("Worker " + worker.getName() + " worked from " + start + " to " + end + ".");
	}
}
