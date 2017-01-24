package fr.esgi.cleancode.workers.logger;

import fr.esgi.cleancode.workers.activity.Activity;
import fr.esgi.cleancode.workers.activity.robot.StandbyActivity;
import fr.esgi.cleancode.workers.task.Task;
import fr.esgi.cleancode.workers.worker.Robot;
import fr.esgi.cleancode.workers.worker.Worker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvLoggerTest {

	private String fileName;

	@Before
	public void setUp() {
		this.fileName = "./worklogs" + new Random().nextInt(100) + ".csv";
	}

	@Test
	public void csvLoggerAppendNewWorkLogs() throws Exception {
		Task task = new Task("Important Task", "2017-01-01");
		Worker worker = new Robot("C3P0");
		Activity activity = new StandbyActivity(9, 18); // Broken robot, y'know

		Logger logger = new CsvLogger(this.fileName);

		worker.assign(task);
		String workLog = worker.work(activity, logger);
		List<String> csvLines = Files.readAllLines(Paths.get(this.fileName));

		assertThat(worker.currentTask().getName()).isEqualTo("Important Task");
		assertThat(worker.currentTask().getDate()).isEqualTo("2017-01-01");
		assertThat(workLog).isNotBlank();
		assertThat(csvLines.size()).isEqualTo(1);
		assertThat(csvLines.get(0)).isEqualTo("activity,Important Task,'2017-01-01',C3P0,Standby,918");
	}

	@After
	public void cleanUp() {
		new File(fileName).delete();
	}
}