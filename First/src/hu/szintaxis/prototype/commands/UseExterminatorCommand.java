package hu.szintaxis.prototype.commands;

public class UseExterminatorCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		if (args.length != 1) {
			throw new Exception("Invalid arguments. \n"
					+ " Usage: useExterminator <Field> \n"
					+ " Example: useExterminator 3,4");
		}
		System.out.println("useExterminator");
	}

}
