package fr.esgi.cleancode.workers.logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class FileLoggerTest {

	private String fileName;

	@Before
	public void setUp() {
		this.fileName = "./test" + new Random().nextInt(100) + ".log";
	}

	@Test
	public void fileLoggerAppendNewLine() throws Exception {
		Logger logger = new FileLogger(this.fileName);

		logger.log("Ceci est un test !");
		List<String> csvLines = Files.readAllLines(Paths.get(this.fileName));

		assertThat(csvLines.size()).isEqualTo(1);
		assertThat(csvLines.get(0)).isEqualTo("Ceci est un test !");
	}

	@After
	public void cleanUp() {
		new File(fileName).delete();
	}
}