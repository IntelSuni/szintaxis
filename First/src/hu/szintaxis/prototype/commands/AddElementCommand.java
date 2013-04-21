package hu.szintaxis.prototype.commands;

import hu.szintaxis.prototype.Prototype;
import hu.szintaxis.prototype.PrototypeUtil;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import System.Ant;
import System.AntHill;
import System.Anteater;
import System.Antlion;
import System.Block;
import System.Element;
import System.Field;
import System.FoodStore;
import System.GameField;
import System.Stone;

/**
 * Az addElement parancs osztálya. Megadott elemet rak egy megadott mezõre.
 * 
 * @author Dóczi Róbert
 * 
 */
public class AddElementCommand extends CommandBase {

	/**
	 * A hozzáadható element típusokat tároló map.
	 */
	Map<String, Class<? extends Element>> elementTypes;

	{
		elementTypes = new HashMap<String, Class<? extends Element>>();
		elementTypes.put("AntHill", AntHill.class);
		elementTypes.put("FoodStore", FoodStore.class);
		elementTypes.put("Anteater", Anteater.class);
		elementTypes.put("Antlion", Antlion.class);
		elementTypes.put("Block", Block.class);
		elementTypes.put("Ant", Ant.class);
		elementTypes.put("Stone", Stone.class);
	}

	@Override
	public void execute(String... args) throws Exception {
		if (args.length != 2) {
			throw new Exception("Not enough arguments. \n"
					+ " Usage: addElement <ElementType> <position> \n"
					+ " Example: addElement AntHill 2,4 \n"
					+ " Element type can be: AntHill, FoodStore, Anteater"
					+ ", Antlion, Block, Ant");
		}

		if (Prototype.Instance().getGameField() == null) {
			throw new Exception("GameField not yet initialized.");
		}

		Point point = PrototypeUtil.stringToPoint(args[1]);
		Field field = Prototype.Instance().getGameField().getField(point);
		if (field == null) {
			throw new Exception("Field not found.");
		}

		Class<? extends Element> elementClass = elementTypes.get(args[0]);
		if (elementClass == null) {
			throw new Exception("Element type not found.");
		}

		Element elementInstance;

		if (elementClass == AntHill.class || elementClass == Ant.class) {
			elementInstance = elementClass.getConstructor(Field.class)
					.newInstance(field);
		} else {
			elementInstance = elementClass.newInstance();
		}

		Prototype.Instance().getGameField()
				.addElementToField(elementInstance, field);
	}

}
