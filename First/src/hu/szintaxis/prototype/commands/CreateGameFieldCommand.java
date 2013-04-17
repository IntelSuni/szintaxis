package hu.szintaxis.prototype.commands;

public class CreateGameFieldCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		if (args.length != 2) {
			throw new Exception("Not enough arguments. \n"
					+ " Usage: createGameField <Dimensions> \n"
					+ " Example: createGameField 10,10");
		}
		System.out.println("createGameField");
	}

}
