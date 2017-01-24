package fr.esgi.cleancode.workers.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.InvalidPathException;

public class FileLogger implements Logger {

	private static final boolean APPEND_MODE = true;

	private final String path;

	public FileLogger(String path) throws InvalidPathException {
		this.path = path;
	}

	@Override
	public void log(String message) throws LoggerException {
		try(FileWriter fw = new FileWriter(this.path, APPEND_MODE);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter csv = new PrintWriter(bw))
		{
			csv.println(message);
		}
		catch(IOException e) {
			throw new LoggerException(e.getMessage(), e);
		}
	}
}
