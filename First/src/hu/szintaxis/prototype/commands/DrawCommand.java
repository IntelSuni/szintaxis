package hu.szintaxis.prototype.commands;

/**
 * Draw parancs osztálya. Kirajzolja a megadott mezõhöz képest a megadott sugarú
 * körben levõ mezõket.
 * 
 * @author Dóczi Róbert
 * 
 */
public class DrawCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		if (args.length != 2) {
			throw new Exception("Not enough arguments. \n"
					+ " Usage: draw <Field> <Radius> \n"
					+ " Example: draw 5,5 3");
		}
		System.out.println("DRAWING! " + args[0]);
	}

}
