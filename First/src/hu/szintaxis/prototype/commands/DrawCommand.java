package hu.szintaxis.prototype.commands;

import hu.szintaxis.prototype.Prototype;
import hu.szintaxis.prototype.PrototypeUtil;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import System.Ant;
import System.AntHill;
import System.Anteater;
import System.Antlion;
import System.Block;
import System.Element;
import System.Field;
import System.FoodStore;
import System.Stone;

/**
 * Draw parancs osztálya. Kirajzolja a megadott mezõhöz képest a megadott sugarú
 * körben levõ mezõket.
 * 
 * @author Dóczi Róbert
 * 
 */
public class DrawCommand extends CommandBase {

	Map<Class<? extends Element>, String> elementTypes;

	{
		elementTypes = new HashMap<Class<? extends Element>, String>();
		elementTypes.put(AntHill.class, "AH");
		elementTypes.put(FoodStore.class, "F");
		elementTypes.put(Anteater.class, "AE");
		elementTypes.put(Antlion.class, "AL");
		elementTypes.put(Block.class, "B");
		elementTypes.put(Ant.class, "A");
		elementTypes.put(Stone.class, "S");
	}

	@Override
	public void execute(String... args) throws Exception {
		if (args.length != 2) {
			throw new Exception("Not enough arguments. \n"
					+ " Usage: draw <Field> <Radius> \n"
					+ " Example: draw 5,5 3");
		}

		Point point = PrototypeUtil.stringToPoint(args[0]);
		int rad = Integer.parseInt(args[1]);

		Set<Field> f = getFields(rad, Prototype.Instance().getGameField()
				.getField(point));
		List<Field> fields = new ArrayList<Field>();
		fields.addAll(f);

		Collections.sort(fields, new Comparator<Field>() {
			@Override
			public int compare(Field o1, Field o2) {
				if (o1.getPoint().y < o2.getPoint().y) {
					return -1;
				} else if (o1.getPoint().y > o2.getPoint().y) {
					return 1;
				} else if (o1.getPoint().y == o2.getPoint().y) {
					if (o1.getPoint().x < o2.getPoint().x) {
						return -1;
					} else if (o1.getPoint().x > o2.getPoint().x) {
						return 1;
					} else if (o1.getPoint().x == o2.getPoint().x) {
						return 0;
					}
				}
				return 0;
			}
		});

		int zeroRow = point.y;
		int row = -1;

		StringBuilder sb = new StringBuilder();

		for (Field field : fields) {
			if (field.getPoint().y != row) {
				row = field.getPoint().y;
				sb.append("\n");

				int i = Math.abs(row - zeroRow);
				for (int j = 0; j < i; j++) {
					sb.append(" ");
				}
			}

			sb.append("_");

			Element element = null;
			if (!field.getElements().isEmpty()) {
				element = field.getElements().get(0);
			}

			String elementString = null;
			if (element != null) {
				elementString = elementTypes.get(element.getClass());
			}

			sb.append((elementString == null) ? ' ' : elementString);
		}

		System.out.println(sb.toString());
	}

	private Set<Field> getFields(int depth, Field root) {
		Set<Field> fields = new HashSet<Field>();
		if (depth > 0) {
			List<Field> neighbours = root.getNeighbours();
			for (Field field : neighbours) {
				if (field == null)
					continue;
				fields.addAll(getFields(depth - 1, field));
			}
			fields.add(root);
			return fields;
		} else {
			if (root == null) {
				System.out.println("ANYÁD");
			}
			fields.add(root);
			return fields;
		}
	}
}
