package hu.szintaxis.prototype.commands;

public class ExitCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		System.exit(0);
	}

}
