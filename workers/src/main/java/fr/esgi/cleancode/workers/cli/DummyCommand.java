package fr.esgi.cleancode.workers.cli;

import fr.esgi.cleancode.workers.logger.Logger;

public class DummyCommand extends Command {

	public DummyCommand() {
		super("dummy");
	}

	@Override
	public void exec(Logger logger, String... parameters) {
		/* For testing puroposes only */
	}

	@Override
	public String usage() {
		return null;
	}
}
