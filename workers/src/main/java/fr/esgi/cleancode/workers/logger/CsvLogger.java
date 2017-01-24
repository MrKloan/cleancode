package fr.esgi.cleancode.workers.logger;

import fr.esgi.cleancode.workers.activity.Activity;
import fr.esgi.cleancode.workers.task.Task;
import fr.esgi.cleancode.workers.worker.Worker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.InvalidPathException;

public class CsvLogger implements Logger {

	private static final boolean APPEND_MODE = true;

	private final String path;

	public CsvLogger(String path) throws InvalidPathException {
		this.path = path;
	}

	@Override
	public void log(Worker worker, Task task, Activity activity) throws LoggerException {
		try(FileWriter fw = new FileWriter(this.path, APPEND_MODE);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter csv = new PrintWriter(bw))
		{
			StringBuilder sb = new StringBuilder("activity,");

			sb.append(task.getName()).append(",")
				.append("'").append(task.getDate()).append("',")
				.append(worker.getName()).append(",")
				.append(activity.toString()).append(",")
				.append(activity.getStart())
				.append(activity.getEnd());

			csv.println(sb.toString());
		}
		catch(IOException e) {
			throw new LoggerException(e.getMessage(), e);
		}
	}
}
