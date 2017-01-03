package fr.esgi.cleancode.workers;

import fr.esgi.cleancode.workers.activity.Activity;

public class Worker {

	private final String name;

	public Worker(String name) {
		this.name = name;
	}

	public void work(Activity activity, int start, int end) {
		activity.proceed(this, start, end);
	}

	public String getName() {
		return name;
	}
}
