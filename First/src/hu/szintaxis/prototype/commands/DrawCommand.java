package hu.szintaxis.prototype.commands;

/**
 * Draw parancs oszt�lya. Kirajzolja a megadott mez�h�z k�pest a megadott sugar�
 * k�rben lev� mez�ket.
 * 
 * @author Lexan
 * 
 */
public class DrawCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		if (args.length != 2) {
			throw new Exception("Not enough arguments. \n Usage:"
					+ " Draw <Field> <Radius> \n Example: Draw 5,5 3");
		}
		System.out.println("DRAWING! " + args[0]);
	}

}
