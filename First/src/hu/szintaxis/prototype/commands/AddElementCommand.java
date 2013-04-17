package hu.szintaxis.prototype.commands;

public class AddElementCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		if (args.length != 2) {
			throw new Exception("Not enough arguments. \n"
					+ " Usage: addElement <ElementType> <position> \n"
					+ " Example: addElement AntHill 2,4");
		}
		System.out.println("addElement");
	}

}
