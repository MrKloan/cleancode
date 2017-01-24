package fr.esgi.cleancode.workers.worker;

import fr.esgi.cleancode.workers.activity.Activity;
import fr.esgi.cleancode.workers.activity.WorkActivity;
import fr.esgi.cleancode.workers.cli.DummyCommand;
import fr.esgi.cleancode.workers.logger.DummyLogger;
import fr.esgi.cleancode.workers.task.Task;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class WorkerTest {

	@Test
	public void workerCanBeAssigned() throws Exception {
		Task task = new Task("Task 1", "2016-12-04");
		Worker worker = new Human("Peter");

		worker.assign(task);

		assertThat(worker.currentTask().getName()).isEqualTo("Task 1");
	}

	@Test(expected = IllegalStateException.class)
	public void workerMustBeAssigned() throws Exception {
		Worker worker = new Human("Peter");
		Activity activity = new WorkActivity(9, 12);

		worker.work(activity, new DummyLogger(), new DummyCommand());
	}

	@Test
	public void workerCanBeAssignedAndWork() throws Exception {
		Task task = new Task("Task 1", "2016-12-04");
		Worker worker = new Human("Peter");
		Activity activity = new WorkActivity(9, 12);

		worker.assign(task);
		String workLog = worker.work(activity, new DummyLogger(), new DummyCommand());

		assertThat(worker.currentTask().getName()).isEqualTo("Task 1");
		assertThat(workLog).isNotBlank();
	}
}