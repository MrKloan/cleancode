package fr.esgi.cleancode.workers.logger;

public class LoggerException extends RuntimeException {

	public LoggerException(String msg, Throwable t) {
		super(msg, t);
	}
}
