package hu.szintaxis.prototype.commands;

public class LoadCommandsCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		if (args.length != 1) {
			throw new Exception("Invalid arguments. \n" 
					+ " Usage: loadCommands <File> \n" 
					+ " Example: loadCommands C:/test1.txt");
		}
		System.out.println("loadCommands");
	}

}
