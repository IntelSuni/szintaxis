package hu.szintaxis.prototype.commands;

import java.awt.Point;

import System.Weapon;
import hu.szintaxis.prototype.Prototype;
import hu.szintaxis.prototype.PrototypeUtil;

/**
 * A useExterminator parancs oszt�lya. Adott mez�re szimul�lja a spr� f�j�s�t.
 * 
 * @author D�czi R�bert
 * 
 */
public class UseExterminatorCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		if (args.length != 1) {
			throw new Exception("Invalid arguments. \n"
					+ " Usage: useExterminator <Field> \n"
					+ " Example: useExterminator 3,4");
		}

		if (Prototype.Instance().getGameField() == null) {
			throw new Exception("GameField not yet initialized.");
		}

		Point point = PrototypeUtil.stringToPoint(args[0]);
		Weapon.InstanceOf().SelectExterminator();
		Weapon.InstanceOf().Use(
				Prototype.Instance().getGameField().getField(point));
	}
}
