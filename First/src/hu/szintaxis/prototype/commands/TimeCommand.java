package hu.szintaxis.prototype.commands;

import hu.szintaxis.prototype.Prototype;

/**
 * A time parancs osztálya. Lefuttat megadott számú (default 0) szimulációt.
 * 
 * @author Dóczi Róbert
 * 
 */
public class TimeCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		int times;
		if (args.length == 0) {
			times = 1;
		} else {
			times = Integer.parseInt(args[0]);	
		}
		
		if (Prototype.Instance().getGameField() == null) {
			throw new Exception("GameField not yet initialized.");
		}
		
		System.out.println(times + " step(s) simulated."); 
		
		for (int i = 0; i < times; i++) {
			Prototype.Instance().getGameField().updateUpdatables();
		}
	}
}
