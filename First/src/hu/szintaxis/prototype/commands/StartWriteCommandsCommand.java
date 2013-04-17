package hu.szintaxis.prototype.commands;

public class StartWriteCommandsCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		if (args.length != 1) {
			throw new Exception("Invalid arguments. \n"
					+ " Usage: startWriteCommands <File> \n"
					+ " Example: startWriteCommands C:/testout.txt");
		}
		System.out.println("startWriteCommand");
	}

}
