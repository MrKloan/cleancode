package fr.esgi.cleancode.workers.cli;

import fr.esgi.cleancode.workers.logger.Logger;

public abstract class Command {

	private final String name;

	Command(final String name) {
		this.name = name;
	}

	public abstract void exec(Logger logger, String... parameters);
	public abstract String usage();

	public String getName() {
		return name;
	}
}
