package fr.esgi.cleancode.workers.cli;

import fr.esgi.cleancode.workers.logger.DummyLogger;
import fr.esgi.cleancode.workers.logger.FileLogger;
import fr.esgi.cleancode.workers.logger.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class WorkLogCommandTest {

	private String fileName;

	@Before
	public void setUp() {
		this.fileName = "./worklogs" + new Random().nextInt(100) + ".csv";
	}

	@Test
	public void activityCommandCreatesANewWorkLogUsingGivenDate() throws Exception {
		Command cmd = new WorkLogCommand("activity");
		Logger logger = new FileLogger(this.fileName);

		cmd.exec(logger, "Task1", "Peter", "Work", "9", "13", "2017-01-01");
		List<String> csvLines = Files.readAllLines(Paths.get(this.fileName));

		assertThat(csvLines.size()).isEqualTo(1);
		assertThat(csvLines.get(0)).isEqualTo("activity,Task1,'2017-01-01',Peter,Work,9,13");
	}

	@Test(expected = IllegalArgumentException.class)
	public void workLogCommandShouldHaveAtLeast5Params() throws Exception {
		Command cmd = new WorkLogCommand("shortCommand");
		Logger logger = new DummyLogger();

		cmd.exec(logger, "some", "parameters");
	}

	@Test(expected = IllegalArgumentException.class)
	public void workLogCommandShouldHaveLessThan6Params() throws Exception {
		Command cmd = new WorkLogCommand("longCommand");
		Logger logger = new DummyLogger();

		cmd.exec(logger, "some", "parameter", "with", "a", "lot", "of", "friends");
	}

	@After
	public void cleanUp() {
		new File(fileName).delete();
	}
}