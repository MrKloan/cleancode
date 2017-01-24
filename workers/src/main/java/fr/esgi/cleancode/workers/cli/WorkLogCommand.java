package fr.esgi.cleancode.workers.cli;

import fr.esgi.cleancode.workers.logger.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkLogCommand extends Command {

	private static final int TASK = 0;
	private static final int WORKER = 1;
	private static final int ACTIVITY = 2;
	private static final int START = 3;
	private static final int END = 4;
	private static final int DATE = 5;

	private static final int MIN_LENGTH = 5;
	private static final int MAX_LENGTH = 6;

	public WorkLogCommand(String name) {
		super(name);
	}

	@Override
	public void exec(Logger logger, String... parameters) {
		if(parameters.length < MIN_LENGTH || parameters.length > MAX_LENGTH)
			throw new IllegalArgumentException(this.usage());

		String date;
		if(parameters.length == MIN_LENGTH)
			date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		else
			date = parameters[DATE];

		StringBuilder sb = new StringBuilder();
		sb.append(this.getName()).append(",")
			.append(parameters[TASK]).append(",")
			.append("'").append(date).append("',")
			.append(parameters[WORKER]).append(",")
			.append(parameters[ACTIVITY]).append(",")
			.append(parameters[START]).append(",")
			.append(parameters[END]);

		logger.log(sb.toString());
	}

	@Override
	public String usage() {
		return this.getName() + " [task] [worker] [activity] [start] [end] {date}";
	}
}
