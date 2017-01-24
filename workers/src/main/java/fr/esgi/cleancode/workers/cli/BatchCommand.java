package fr.esgi.cleancode.workers.cli;

import com.google.gson.Gson;
import fr.esgi.cleancode.workers.activity.Activity;
import fr.esgi.cleancode.workers.activity.ActivityFactory;
import fr.esgi.cleancode.workers.logger.Logger;
import fr.esgi.cleancode.workers.task.Task;
import fr.esgi.cleancode.workers.worker.Human;
import fr.esgi.cleancode.workers.worker.Robot;
import fr.esgi.cleancode.workers.worker.Worker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchCommand extends Command {

	public BatchCommand() {
		super("--file");
	}

	@Override
	public void exec(Logger logger, String... parameters) {
		if(parameters.length != 1)
			throw new IllegalArgumentException("A file path was expected");

		try {
			String content = getFileContent(parameters[0]);
			BatchStructure batch = new Gson().fromJson(content, BatchStructure.class);

			Map<String, Worker> workers = parseWorkers(batch);
			assignTasks(batch, workers);

			logActivities(logger, "activity", batch.activities, workers);
			logActivities(logger, "robot", batch.robots, workers);
		}
		catch(IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private String getFileContent(String path) throws IOException {
		StringBuilder sb = new StringBuilder();
		Files.readAllLines(Paths.get(path)).forEach(sb::append);
		return sb.toString();
	}

	private Map<String, Worker> parseWorkers(BatchStructure batch) {
		Map<String, Worker> workers = new HashMap<>();

		batch.activities.forEach(activity -> {
			String name = activity.get("name");
			if(!workers.containsKey(name))
				workers.put(name, new Human(name));
		});
		batch.robots.forEach(robot -> {
			String name = robot.get("name");
			if(!workers.containsKey(name))
				workers.put(name, new Robot(name));
		});

		return workers;
	}

	private void assignTasks(BatchStructure batch, Map<String, Worker> workers) {
		batch.roles.forEach(role -> {
			String name = role.get("name");
			Worker worker = workers.get(name);

			if(worker != null)
				worker.assign(new Task(role.get("role"), role.get("start")));
			else
				System.err.println("Worker " + name + " is assigned to a task but didn't log any activity");
		});
	}

	private void logActivities(Logger logger, String type, List<Map<String, String>> entries, Map<String, Worker> workers) {
		entries.forEach(entry -> {
			String name = entry.get("name");
			Worker worker = workers.get(name);

			if(worker == null || worker.currentTask() == null) {
				System.err.println("Worker " + worker + " is not assigned to any task");
				return;
			}

			Integer start = Integer.parseInt(entry.get("start"));
			Integer end = Integer.parseInt(entry.get("finish"));
			Activity act = ActivityFactory.getActivity(entry.get("activity"), start, end);
			Command cmd = new WorkLogCommand(type);

			worker.work(act, logger, cmd);
		});
	}

	@Override
	public String usage() {
		return "--file [file_path]";
	}

	static class BatchStructure {
		List<Map<String, String>> activities;
		List<Map<String, String>> robots;
		List<Map<String, String>> roles;
	}
}
