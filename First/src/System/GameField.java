package System;

import hu.szintaxis.graphics.AntHillView;
import hu.szintaxis.graphics.AntLionView;
import hu.szintaxis.graphics.FieldView;
import hu.szintaxis.graphics.FoodStoreView;
import hu.szintaxis.graphics.StoneView;
import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Pályát megvalósító osztály.
 */
public class GameField {
	/**
	 * Pályán levõ hangyászok száma.
	 */
	private int anteaterNo;
	/**
	 * Pályán levõ hangyabolyok száma.
	 */
	private int antHillNo;
	/**
	 * Pályán levõ akadályok száma.
	 */
	private int blockNo;
	/**
	 * Pályán levõ ételraktárak száma.
	 */
	private int foodStoreNo;
	/**
	 * Pályát tároló statikus objektum (singleton).
	 */
	private static GameField instance;
	/**
	 * Pálya mezõkoordinátái.
	 */
	private Point size;
	/**
	 * Pályán levõ kavicsok száma.
	 */
	private int stoneNo;
	/**
	 * Pályán levõ frissítendõ objektumok.
	 */
	private ArrayList<Updatable> toUpdate;
	/**
	 * Mezõket tároló lista.
	 */
	public List<Field> fields;

	/**
	 * 
	 */
	// public Game game;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}

	/*
	 * Ez indítja el a teljes view updatet.
	 */
	public void draw(Graphics2D g) {
		// for (Field field : fields) {
		// // field.update();
		// /*
		// * for (Element e : field.getElements()) { (View) e.notify(); }
		// */
		// }

		// int fieldSize = this.size.x * 40;
		//
		// for (int i = 0; i < fieldSize; i += 40) {
		// for (int j = 0, rowCount = 0; j < fieldSize; j += 40, rowCount++) {
		// if (rowCount % 2 == 0) {
		// int[] x = new int[] { i, i + 20, i + 40, i + 40, i + 20, i };
		// int[] y = new int[] { j + 20, j, j + 20, j + 40, j + 60,
		// j + 40 };
		// g.drawPolygon(x, y, x.length);
		// } else {
		// int[] x = new int[] { i + 20, i + 40, i + 60, i + 60,
		// i + 40, i + 20 };
		// int[] y = new int[] { j + 20, j, j + 20, j + 40, j + 60,
		// j + 40 };
		// g.drawPolygon(x, y, x.length);
		// }
		// }
		// }

		for (Field field : this.fields) {
			field.NotifyView(g);
			ArrayList<Element> elements = field.getElements();
			for (Element element : elements) {
				element.NotifyView(g);
				// System.out.println(element.toString());
			}
		}

	}

	/**
	 * Létrehoz egy üres pályát.
	 */
	public GameField() {
		fields = new ArrayList<Field>();
		toUpdate = new ArrayList<Updatable>();
	}

	/**
	 * Létrehoz egy {@code Point} méretû pályát.
	 * 
	 * @param size
	 *            a létrehozandó pálya mérete.
	 */
	public GameField(Point size) {
		this();
		this.size = size;
		System.out.println("Successfully crated gameField of size " + size.x
				+ "," + size.y + ".");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GameField []";
	}

	/**
	 * Hozzáad egy {@code element}-et egy {@code field}-hez.
	 * 
	 * @param element
	 *            Hozzáadandó element.
	 * @param field
	 *            Field, amihez hozzá szeretnénk adni.
	 */
	public void addElementToField(Element element, Field field) {
		for (Field fields : this.fields) {
			if (fields.equals(field) == true) {
				fields.addElement(element);

			}
		}
		if (element instanceof Updatable) {
			Updatable updatable = (Updatable) element;
			toUpdate.add(updatable);
		}

		System.out.println(element.getClass().getSimpleName()
				+ " successfully added at " + field.getPoint().x + ","
				+ field.getPoint().y + ".");
	}

	/**
	 * Hozzáadja a {@code Field} mezõt a mezõket tároló listához.
	 * 
	 * @param f
	 *            pálya mezõlistájához hozzáadandó mezõ
	 */
	public void addField(Field f) {
		fields.add(f);
	}

	/**
	 * A {@code Points} által meghatározott {@code Field}-et adja meg.
	 * 
	 * @param points
	 *            koordinináták, amely meghatározzák a {@code Field}-et
	 * @return {@code Point} által meghatározott {@code Field}
	 */
	public Field getField(Point points) {
		for (Field field : fields) {
			if (field.getPoint().equals(points)) {
				return field;
			}
		}
		return null;
	}

	/**
	 * Inicializálja a játékos mezõt: létrehozza a pályán található elemeket és
	 * beállítja.
	 */
	public void Initialize() {
		int column = size.x;
		int row = size.y;
		fields = new ArrayList<Field>(column * row);
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < row; j++) {
				Field tempField = new Field(this);
				tempField.setPoint(i, j);
				fields.add(tempField);
			}
		}

		for (Field field : fields) {
			Point pos = field.getPoint();
			FieldView fieldView = new FieldView(field);

			field.Attach(fieldView);

			if (pos.y % 2 == 0) {
				field.addNeighbour(getField(new Point(pos.x - 1, pos.y - 1)));
				field.addNeighbour(getField(new Point(pos.x, pos.y - 1)));
				field.addNeighbour(getField(new Point(pos.x - 1, pos.y)));
				field.addNeighbour(getField(new Point(pos.x + 1, pos.y)));
				field.addNeighbour(getField(new Point(pos.x - 1, pos.y + 1)));
				field.addNeighbour(getField(new Point(pos.x, pos.y + 1)));
			} else {
				field.addNeighbour(getField(new Point(pos.x, pos.y - 1)));
				field.addNeighbour(getField(new Point(pos.x + 1, pos.y - 1)));
				field.addNeighbour(getField(new Point(pos.x - 1, pos.y)));
				field.addNeighbour(getField(new Point(pos.x + 1, pos.y)));
				field.addNeighbour(getField(new Point(pos.x, pos.y + 1)));
				field.addNeighbour(getField(new Point(pos.x + 1, pos.y + 1)));
			}
		}

		/*
		 * Az elemek helyének kisorsolása és hozzáadása.
		 */
		Random rand = new Random();
		// Az AntHill kisoroslása, melyik oldalon legyen, majd hozzáadása
		// (észak,dél,kelet,nyugat)
		int r = rand.nextInt(4);
		AntHill hill;
		AntHillView hillView;
		Field actual;
		switch (r) {
		// dél
		case 0:
			r = rand.nextInt(column);
			actual = fields.get((column * (row - 1)) + r);
			hill = new AntHill(actual);
			hillView = new AntHillView();
			hillView.m_AntHill = hill;
			actual.addElement(hill);
			hill.Attach(hillView);
			this.registerNewUpdatable(hill);
			break;
		// észak
		case 1:
			r = rand.nextInt(column);
			actual = fields.get(r);
			hill = new AntHill(actual);
			hillView = new AntHillView();
			hillView.m_AntHill = hill;
			actual.addElement(hill);
			hill.Attach(hillView);
			this.registerNewUpdatable(hill);
			break;
		// nyugat
		case 2:
			r = rand.nextInt(row);
			actual = fields.get(column * r);
			hill = new AntHill(actual);
			hillView = new AntHillView();
			hillView.m_AntHill = hill;
			actual.addElement(hill);
			hill.Attach(hillView);
			this.registerNewUpdatable(hill);
			break;
		// kelet
		case 3:
			r = rand.nextInt(row);
			actual = fields.get((column - 1) + column * r);
			hill = new AntHill(actual);
			hillView = new AntHillView();
			hillView.m_AntHill = hill;
			actual.addElement(hill);
			hill.Attach(hillView);
			this.registerNewUpdatable(hill);
			break;
		}

		// foodStore rátevése a középsõ cellák valamelyikére. (a felsõ, alsó, és
		// két szélsõ oszlopok kivételével bárhova kerülhet)
		int q;
		boolean success = false;
		while (!success) {
			// a középsõ sorokból kerül ki a gyõztes
			r = rand.nextInt(row - 2);
			// adott soron belül melyik elem lesz a nyerõ
			q = rand.nextInt(column - 2);
			int index = (column + 1) * r + q;
			// csak üres mezõre helyezünk foodstore-t
			if (fields.get(index).getElements().size() == 0) {
				actual = fields.get(index);
				FoodStore foodTemp = new FoodStore();
				foodTemp.setField(actual);

				FoodStoreView fsv = new FoodStoreView();
				fsv.m_FoodStore = foodTemp;
				foodTemp.Attach(fsv);

				// foodTemp.Attach(new FoodStoreView());
				fields.get(index).addElement(foodTemp);
				success = true;
			}
		}

		// 3db hangyalesõt helyezünk a pályára
		for (int i = 0; i < 3; i++) {
			success = false;
			while (!success) {
				r = rand.nextInt(row * column);
				// csak akkor helyezzük rá ha üres a kisorsolt mezõ
				if (fields.get(r).getElements().size() == 0) {
					actual = fields.get(r);
					Antlion spider = new Antlion(actual);
					spider.setField(actual);

					AntLionView antLionView = new AntLionView();
					antLionView.m_AntLion = spider;
					spider.Attach(antLionView);
					actual.addElement(spider);
					success = true;
				}
			}
		}

		// 5db kavicsot helyezünk a pályára
		for (int i = 0; i < 5; i++) {
			success = false;
			while (!success) {
				r = rand.nextInt(row * column);
				// csak akkor helyezzük rá ha üres a kisorsolt mezõ
				if (fields.get(r).getElements().size() == 0) {
					actual = fields.get(r);

					Stone stone = new Stone(actual);
					StoneView stoneView = new StoneView();
					stoneView.m_Stone = stone;
					stone.Attach(stoneView);
					actual.addElement(stone);
					success = true;
				}
			}
		}
	}

	/**
	 * Magát a pályát adja meg.
	 * 
	 * @return {@code GameField} osztálypéldány
	 */
	public static GameField instanceOf() {
		if (instance == null)
			instance = new GameField(new Point(10, 10));
		return instance;
	}

	/**
	 * Beregisztrálja a pályára a {@code Updatable} frissítendõ objektumot.
	 * 
	 * @param element
	 *            frissítendõ objektum
	 */
	public void registerNewUpdatable(Updatable element) {
		this.toUpdate.add(element);
	}

	/**
	 * Eltávolítja az elementet a frissítendõ objektumok közül.
	 * 
	 * @param element
	 */
	public void unregisterUpdatable(Updatable element) {
		Tracer.Instance().Trace(TracerDirection.Enter);
		// if (this.toUpdate.contains(element)) {
		this.toUpdate.remove(element);

		int fSize = this.fields.size();
		for (int i = 0; i < fSize; i++) {
			Field field = this.fields.get(i);
			ArrayList<Element> elements = field.getElements();
			int eSize = elements.size();
			for (int j = 0; j < eSize; j++) {
				if (elements.get(j).equals(element)) {
					elements.remove(element);
				}
			}
		}
		// }
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Frissíti a pálya frissítendõ objektumait.
	 */
	public void updateUpdatables() {
		int tUS = this.toUpdate.size();
		for (int i = 0; i < tUS; i++) {
			Updatable updatable = this.toUpdate.get(i);
			updatable.update();
		}
		// System.out.println(this.toUpdate.toString());
		// for (Updatable updatables : this.toUpdate) {
		// updatables.update();
		// }
	}

}
