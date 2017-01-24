package fr.esgi.cleancode.workers.activity;

import fr.esgi.cleancode.workers.worker.Worker;

public abstract class Activity {

	protected final int start;
	protected final int end;

	public Activity(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public abstract String proceed(Worker worker);

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	@Override
	public String toString() {
		int index;
		String simpleName = getClass().getSimpleName();

		return ((index = simpleName.indexOf("Activity")) > 0)
			? simpleName.substring(0, index)
			: simpleName;
	}
}
