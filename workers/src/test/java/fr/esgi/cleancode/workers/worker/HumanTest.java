package fr.esgi.cleancode.workers.worker;

import fr.esgi.cleancode.workers.activity.Activity;
import fr.esgi.cleancode.workers.activity.robot.StandbyActivity;
import fr.esgi.cleancode.workers.logger.DummyLogger;
import fr.esgi.cleancode.workers.task.Task;
import org.junit.Test;

public class HumanTest {

	@Test(expected = IllegalArgumentException.class)
	public void humanCannotPerformARobotActivity() throws Exception {
		Task task = new Task("Task 1", "2016-12-04");
		Worker worker = new Human("Peter");
		Activity activity = new StandbyActivity(18, 9);

		worker.assign(task);
		worker.work(activity, new DummyLogger());
	}
}