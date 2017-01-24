package fr.esgi.cleancode.workers.task;

public class Task {

	private final String name;
	private final String date;

	public Task(String name, String date) {
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}
}
