package hu.szintaxis.prototype.commands;

public class StopWriteCommandsCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		if (args.length != 1) {
			throw new Exception("Invalid arguments. \n" 
					+ " Usage: stopWriteCommands <File> \n" 
					+ " Example: stopWriteCommands C:/testout.txt");
		}
		System.out.println("stopWriteCommand");
	}

}
