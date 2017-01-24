package fr.esgi.cleancode.workers.cli;

import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BatchCommandTest {

	private BatchCommand.BatchStructure batch;

	@Before
	private void setUp() {
		batch = new BatchCommand.BatchStructure();

		// Roles
		batch.roles = new ArrayList<>();

		Map<String, String> role1 = new HashMap<>();
		role1.put("name", "Peter");
		role1.put("role", "Task1");
		role1.put("start", "2017-01-01");
		batch.roles.add(role1);

		Map<String, String> role2 = new HashMap<>();
		role1.put("name", "R2D2");
		role1.put("role", "Task2");
		role1.put("start", "2017-02-01");
		batch.roles.add(role2);

		// Activities
		batch.activities = new ArrayList<>();

		Map<String, String> activity1 = new HashMap<>();

		// Robots
	}
}