package fr.esgi.cleancode.workers.logger;

import fr.esgi.cleancode.workers.activity.Activity;
import fr.esgi.cleancode.workers.task.Task;
import fr.esgi.cleancode.workers.worker.Worker;

public class DummyLogger implements Logger {
	@Override
	public void log(Worker worker, Task task, Activity activity) throws LoggerException {
		/* Do nothing */
	}
}
