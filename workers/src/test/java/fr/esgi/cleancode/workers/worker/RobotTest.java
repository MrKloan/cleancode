package fr.esgi.cleancode.workers.worker;

import fr.esgi.cleancode.workers.activity.Activity;
import fr.esgi.cleancode.workers.activity.human.SleepActivity;
import fr.esgi.cleancode.workers.logger.DummyLogger;
import fr.esgi.cleancode.workers.task.Task;
import org.junit.Test;

public class RobotTest {

	@Test(expected = IllegalArgumentException.class)
	public void robotCannotPerformAHumanActivity() throws Exception {
		Task task = new Task("Task 1", "2016-12-04");
		Worker worker = new Robot("Peter");
		Activity activity = new SleepActivity(18, 9);

		worker.assign(task);
		worker.work(activity, new DummyLogger());
	}
}