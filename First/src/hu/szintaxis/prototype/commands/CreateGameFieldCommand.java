package hu.szintaxis.prototype.commands;

import java.awt.Point;

import System.GameField;
import hu.szintaxis.prototype.Prototype;
import hu.szintaxis.prototype.PrototypeUtil;

/**
 * A createGameField parancs oszt�lya. L�trehoz egy megadott m�ret� p�ly�t.
 * 
 * @author D�czi R�bert
 * 
 */
public class CreateGameFieldCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		if (args.length != 1) {
			throw new Exception("Not enough arguments. \n"
					+ " Usage: createGameField <Dimensions> \n"
					+ " Example: createGameField 10,10");
		}		
		Point point = PrototypeUtil.stringToPoint(args[0]);
		
		Prototype.Instance().setGameField(new GameField(point));
		Prototype.Instance().getGameField().Initialize();
	}

}
