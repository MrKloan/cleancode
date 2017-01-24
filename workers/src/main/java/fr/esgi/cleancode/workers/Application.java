package fr.esgi.cleancode.workers;

import fr.esgi.cleancode.workers.cli.Command;
import fr.esgi.cleancode.workers.cli.WorkLogCommand;
import fr.esgi.cleancode.workers.logger.FileLogger;
import fr.esgi.cleancode.workers.logger.Logger;
import fr.esgi.cleancode.workers.task.Task;

import java.util.Arrays;

public class Application implements Runnable {

	private final String[] args;
	private final Command[] commands;
	private final Logger logger;

	public Application(String[] args) {
		if(args.length < 3)
			throw new IllegalArgumentException("You must supply at least a command with its argument(s)");

		this.args = Arrays.copyOfRange(args, 1, args.length);
		this.commands = new Command[] {
			new WorkLogCommand("activity"),
			new WorkLogCommand("robot")
		};

		this.logger = new FileLogger("./worklogs.csv");
	}

	@Override
	public void run() {
		Arrays.stream(commands)
			.filter(cmd -> cmd.getName().equals(args[0]))
			.forEach(cmd -> {
				cmd.exec(logger, Arrays.copyOfRange(args, 1, args.length));
				System.out.println("Command executed successfully!");
			});
	}

	public static void main(String[] args) {
		new Application(args).run();
	}
}
