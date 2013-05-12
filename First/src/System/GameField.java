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
 * P�ly�t megval�s�t� oszt�ly.
 */
public class GameField {
	/**
	 * P�ly�n lev� hangy�szok sz�ma.
	 */
	private int anteaterNo;
	/**
	 * P�ly�n lev� hangyabolyok sz�ma.
	 */
	private int antHillNo;
	/**
	 * P�ly�n lev� akad�lyok sz�ma.
	 */
	private int blockNo;
	/**
	 * P�ly�n lev� �telrakt�rak sz�ma.
	 */
	private int foodStoreNo;
	/**
	 * P�ly�t t�rol� statikus objektum (singleton).
	 */
	private static GameField instance;
	/**
	 * P�lya mez�koordin�t�i.
	 */
	private Point size;
	/**
	 * P�ly�n lev� kavicsok sz�ma.
	 */
	private int stoneNo;
	/**
	 * P�ly�n lev� friss�tend� objektumok.
	 */
	private ArrayList<Updatable> toUpdate;
	/**
	 * Mez�ket t�rol� lista.
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
	 * Ez ind�tja el a teljes view updatet.
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
	 * L�trehoz egy �res p�ly�t.
	 */
	public GameField() {
		fields = new ArrayList<Field>();
		toUpdate = new ArrayList<Updatable>();
	}

	/**
	 * L�trehoz egy {@code Point} m�ret� p�ly�t.
	 * 
	 * @param size
	 *            a l�trehozand� p�lya m�rete.
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
	 * Hozz�ad egy {@code element}-et egy {@code field}-hez.
	 * 
	 * @param element
	 *            Hozz�adand� element.
	 * @param field
	 *            Field, amihez hozz� szeretn�nk adni.
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
	 * Hozz�adja a {@code Field} mez�t a mez�ket t�rol� list�hoz.
	 * 
	 * @param f
	 *            p�lya mez�list�j�hoz hozz�adand� mez�
	 */
	public void addField(Field f) {
		fields.add(f);
	}

	/**
	 * A {@code Points} �ltal meghat�rozott {@code Field}-et adja meg.
	 * 
	 * @param points
	 *            koordinin�t�k, amely meghat�rozz�k a {@code Field}-et
	 * @return {@code Point} �ltal meghat�rozott {@code Field}
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
	 * Inicializ�lja a j�t�kos mez�t: l�trehozza a p�ly�n tal�lhat� elemeket �s
	 * be�ll�tja.
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
		 * Az elemek hely�nek kisorsol�sa �s hozz�ad�sa.
		 */
		Random rand = new Random();
		// Az AntHill kisorosl�sa, melyik oldalon legyen, majd hozz�ad�sa
		// (�szak,d�l,kelet,nyugat)
		int r = rand.nextInt(4);
		AntHill hill;
		AntHillView hillView;
		Field actual;
		switch (r) {
		// d�l
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
		// �szak
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

		// foodStore r�tev�se a k�z�ps� cell�k valamelyik�re. (a fels�, als�, �s
		// k�t sz�ls� oszlopok kiv�tel�vel b�rhova ker�lhet)
		int q;
		boolean success = false;
		while (!success) {
			// a k�z�ps� sorokb�l ker�l ki a gy�ztes
			r = rand.nextInt(row - 2);
			// adott soron bel�l melyik elem lesz a nyer�
			q = rand.nextInt(column - 2);
			int index = (column + 1) * r + q;
			// csak �res mez�re helyez�nk foodstore-t
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

		// 3db hangyales�t helyez�nk a p�ly�ra
		for (int i = 0; i < 3; i++) {
			success = false;
			while (!success) {
				r = rand.nextInt(row * column);
				// csak akkor helyezz�k r� ha �res a kisorsolt mez�
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

		// 5db kavicsot helyez�nk a p�ly�ra
		for (int i = 0; i < 5; i++) {
			success = false;
			while (!success) {
				r = rand.nextInt(row * column);
				// csak akkor helyezz�k r� ha �res a kisorsolt mez�
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
	 * Mag�t a p�ly�t adja meg.
	 * 
	 * @return {@code GameField} oszt�lyp�ld�ny
	 */
	public static GameField instanceOf() {
		if (instance == null)
			instance = new GameField(new Point(10, 10));
		return instance;
	}

	/**
	 * Beregisztr�lja a p�ly�ra a {@code Updatable} friss�tend� objektumot.
	 * 
	 * @param element
	 *            friss�tend� objektum
	 */
	public void registerNewUpdatable(Updatable element) {
		this.toUpdate.add(element);
	}

	/**
	 * Elt�vol�tja az elementet a friss�tend� objektumok k�z�l.
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
	 * Friss�ti a p�lya friss�tend� objektumait.
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
