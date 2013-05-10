package System;

import hu.szintaxis.graphics.AntHillView;
import hu.szintaxis.graphics.AntLionView;
import hu.szintaxis.graphics.FieldView;
import hu.szintaxis.graphics.FoodStoreView;
import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.print.attribute.Size2DSyntax;

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
	 * P�lya m�retkoordin�t�i.
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
	public Game game;

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
		for (Field field : fields) {
			// field.update();
			/*
			 * for (Element e : field.getElements()) { (View) e.notify(); }
			 */
		}
	}

	// csak a tesztek miatt public, eredetileg private !
	public GameField() {
		fields = new ArrayList<Field>();
		toUpdate = new ArrayList<Updatable>();
	}

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
	 *            Hozz�adant� element.
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

			// boolean antAddable = false, anteaterAddable = false;
			// for (Updatable u : this.toUpdate) {
			// if (u instanceof Anteater) {
			// antAddable = true;
			// }
			// else{
			// antAddable = false;
			// }
			// if (u instanceof Ant) {
			// anteaterAddable = true;
			// } else {
			// anteaterAddable = false;
			// }
			// }

			// if (antAddable == true && element instanceof Ant) {
			// Updatable updatable = (Updatable) element;
			// toUpdate.add(updatable);
			// }
			// if (anteaterAddable == true && element instanceof Anteater) {
			// Updatable updatable = (Updatable) element;
			// toUpdate.add(updatable);
			// }

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
	 *            p�ly�n mez�list�hoz hozz�adand� mez�
	 */
	public void addField(Field f) {
		fields.add(f);
	}

	/**
	 * A {@code Points} �ltal meghat�rozott {@code Field}-et adja meg.
	 * 
	 * @param points
	 *            koordin�t�k, amely meghat�rozza a {@code Field}-et
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
	 * Inicializ�lja a j�t�kos mez�t: l�trehozza a p�ly�n
	 * tal�lhat� elemeket �s be�ll�tja �ket.
	 */
	public void Initialize() {
		int column = size.x;
		int row = size.y;
		fields = new ArrayList<Field>(column * row);
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < row; j++) {
				Field tempField = new Field(this);
				tempField.setPoint(i, j);

				// /View l�trehoz�sa a Field-nek, �s hozz�csatol�sa
				FieldView tempFieldView = new FieldView();
				tempField.Attach(tempFieldView);
				tempFieldView.m_Field = tempField;
				// /

				fields.add(tempField);
			}
		}

		for (Field field : fields) {
			Point pos = field.getPoint();

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
		AntHill hill = new AntHill();
		switch (r) {
		// d�l
		case 0:
			r = rand.nextInt(column);
			fields.get((column * (row - 1)) + r).addElement(hill);
			hill.Attach(new AntHillView());
			break;
		// �szak
		case 1:
			r = rand.nextInt(column);
			fields.get(r).addElement(hill);
			hill.Attach(new AntHillView());
			break;
		// nyugat
		case 2:
			r = rand.nextInt(row);
			fields.get(column * r).addElement(hill);
			hill.Attach(new AntHillView());
			break;
		// kelet
		case 3:
			r = rand.nextInt(row);
			fields.get((column - 1) + column * r).addElement(hill);
			hill.Attach(new AntHillView());
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
				FoodStore foodTemp = new FoodStore();
				foodTemp.Attach(new FoodStoreView());
				fields.get(index).addElement(foodTemp);
				success = true;
			}
		}

		// 3db hangyales�t helyez�nk a p�ly�ra
		for (int i = 0; i < 3; i++) {
			success = false;
			while (!success) {
				r = rand.nextInt(row*column);
				//csak akkor helyezz�k r� ha �res a kisorsolt mez�
				if (fields.get(r).getElements().size()==0) {
					Antlion spider = new Antlion();
					spider.Attach(new AntLionView());
					fields.get(r).addElement(spider);
					success = true;
				}
			}
		}

		// int numOfFields = fields.size();
		// for (int i = 0; i < numOfFields; i++) {
		// Field tempField = fields.get(i);
		// int x=tempField.getPoint().x;
		// int y=tempField.getPoint().y;
		//
		//
		//
		// // Nem t�k�letes, t�bb szomsz�dot is hozz�ad !!!
		// for (int j = 0; j < numOfFields ; j++) {
		// Field tTempField = fields.get(j);
		//
		// if (tTempField.getPoint().x==x){
		// if(tTempField.getPoint().y==y) continue;//ekkor onmaga
		// if(tTempField.getPoint().y==y+1)
		// tempField.addNeighbour(tTempField);//ekkor egyik szomszed
		// if(tTempField.getPoint().y==y-1)
		// tempField.addNeighbour(tTempField);//ekkor masik szomszed
		//
		// }
		// if (tTempField.getPoint().y==y){
		// if(tTempField.getPoint().x==x) continue;//ekkor onmaga
		// if(tTempField.getPoint().x==x+1)
		// tempField.addNeighbour(tTempField);//ekkor harmadik szomszed
		// if(tTempField.getPoint().x==x-1)
		// tempField.addNeighbour(tTempField);//ekkor negyedik szomszed
		//
		// }
		// //meg hianyzik a +1,+1 es a -1,-1 modositoju szomszed
		// if
		// ((tTempField.getPoint().y==y-1)&&(tTempField.getPoint().x==x-1))tempField.addNeighbour(tTempField);//ekkor
		// otodik szomszed
		// if
		// ((tTempField.getPoint().y==y+1)&&(tTempField.getPoint().x==x+1))tempField.addNeighbour(tTempField);//ekkor
		// hatodik szomszed
		// }
		/*
		 * if ((((tTempField.getPoint().x - tempField.getPoint().x) == 0) &&
		 * (Math.abs((tTempField.getPoint().y - tempField.getPoint().y))) == 1)
		 * || (((Math.abs((tTempField.getPoint().x - tempField.getPoint().x)))
		 * == 1) && ((tTempField.getPoint().y - tempField.getPoint().y) == 0))
		 * || (((Math.abs((tTempField.getPoint().x - tempField.getPoint().x)))
		 * == 1) && (Math.abs((tTempField.getPoint().y -
		 * tempField.getPoint().y)) == 1)) // && (((tTempField.getPoint().x -
		 * tempField.getPoint().x) != -1) && // ((tTempField.getPoint().y -
		 * tempField.getPoint().y) != 1)) && // (((tTempField.getPoint().x -
		 * tempField.getPoint().x) != 1) && // ((tTempField.getPoint().y -
		 * tempField.getPoint().y) != -1)) ) {
		 * tempField.addNeighbour(tTempField); } }
		 */

		// System.out.println(fields.get(i).getNeighbours().toString());
		// }
	}

	/**
	 * Mag�t a p�ly�t adja meg.
	 * 
	 * @return {@code GameField} oszt�lyp�ld�ny
	 */
	public static GameField instanceOf() {
		if (instance == null)
			instance = new GameField();
		return instance;
	}

	/**
	 * Beregisztr�lja a p�ly�ra a {@code Updatable} friss�tend�
	 * objektumot.
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
		// for (Updatable updatables : this.toUpdate) {
		// updatables.update();
		// }
	}

}