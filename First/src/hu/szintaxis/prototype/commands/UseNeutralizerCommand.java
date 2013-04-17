package hu.szintaxis.prototype.commands;

public class UseNeutralizerCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		if (args.length != 1) {
			throw new Exception("Invalid arguments. \n"
					+ " Usage: useNeutralizer <Field> \n"
					+ " Example: useNeutralizer 3,4");
		}
		System.out.println("useNeutralizer");
	}

}
