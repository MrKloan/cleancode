package fr.esgi.cleancode.workers;

import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {

	private static final String CSV_PATH = "./worklogs.csv";

	@Test
	public void applicationShouldCreateAWorkLog() throws Exception {
		Application app = new Application(new String[] {
			"timetracker.exe",
			"activity",
			"Task1",
			"Peter",
			"Work",
			"9",
			"13",
			"2017-01-01"
		});

		app.run();
		List<String> csvLines = Files.readAllLines(Paths.get(CSV_PATH));

		assertThat(csvLines.size()).isEqualTo(1);
		assertThat(csvLines.get(0)).isEqualTo("activity,Task1,'2017-01-01',Peter,Work,9,13");
	}

	@Test
	public void applicationShouldIgnoreInvalidCmd() throws Exception {
		Application app = new Application(new String[] {
			"timetracker.exe",
			"somecmd",
			"param"
		});

		app.run();

		File csvFile = new File(CSV_PATH);
		assertThat(csvFile.exists()).isFalse();
	}

	@Test(expected = IllegalArgumentException.class)
	public void applicationShouldThrowAnExceptionIfProvidedLessThan3Params() throws Exception {
		new Application(new String[] {
			"timetracker.exe",
			"robot"
		});
	}

	@After
	public void cleanUp() {
		new File(CSV_PATH).delete();
	}
}