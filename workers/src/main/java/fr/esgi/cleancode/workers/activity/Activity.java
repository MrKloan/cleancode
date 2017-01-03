package fr.esgi.cleancode.workers.activity;

import fr.esgi.cleancode.workers.Worker;

public interface Activity {
	void proceed(Worker worker, int start, int end);
}
