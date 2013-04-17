package hu.szintaxis.prototype.commands;

/**
 * A startWriteCommands parancs oszt�lya. Elkezdi ki�rni a kimenetet egy fileba.
 * 
 * @author D�czi R�bert
 * 
 */
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