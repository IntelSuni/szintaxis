package hu.szintaxis.prototype.commands;

/**
 * Az exit parancs osztálya. Kilép a prototípusból.
 * 
 * @author Dóczi Róbert
 * 
 */
public class ExitCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		System.out.println("Exiting...");
		System.exit(0);
	}

}
