package hu.szintaxis.prototype.commands;

/**
 * Az exit parancs oszt�lya. Kil�p a protot�pusb�l.
 * 
 * @author D�czi R�bert
 * 
 */
public class ExitCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		System.out.println("Exiting...");
		System.exit(0);
	}

}
