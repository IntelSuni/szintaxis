package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.Size2DSyntax;

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
	 * Pálya méretkoordinátái.
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
	 * Pályán levõ frissítendõ objektumok.
	 */
	public List<Updatable> updatables;
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

	// csak a tesztek miatt public, eredetileg private !
	public GameField() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		fields = new ArrayList<Field>();
		toUpdate = new ArrayList<Updatable>();
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	public GameField(Point size) {
		this();
		this.size = size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GameField []";
	}

	/**
	 * Hozzáad egy {@code element}-et egy {@code field}-hez.
	 * @param element Hozzáadantó element.
	 * @param field Field, amihez hozzá szeretnénk adni.
	 */
	public void addElementToField(Element element, Field field) {
		Tracer.Instance().Trace(TracerDirection.Enter, element, field);
		for (Field fields : this.fields) {
			if (fields.equals(field) == true) {
				fields.addElement(element);
			}
		}
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Hozzáadja a {@code Field} mezõt a mezõket tároló listához.
	 * 
	 * @param f pályán mezõlistához hozzáadandó mezõ
	 */
	public void addField(Field f) {
		Tracer.Instance().Trace(TracerDirection.Enter, f);
		fields.add(f);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * A {@code Points} által meghatározott {@code Field}-et adja meg.
	 * 
	 * @param points koordináták, amely meghatározza a {@code Field}-et
	 * @return {@code Point} által meghatározott {@code Field}
	 */
	public Field getField(Point points) {
		Tracer.Instance().Trace(TracerDirection.Enter, points);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return null;
	}

	/**
	 * Inicializálja a játékos mezõt:
	 * létrehozza a pályán található elemeket és beállítja õket.
	 */
	public void Initialize() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		
		ArrayList<Field> fields = new ArrayList<Field>(9);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Field tempField = new Field();
				tempField.setPoint(i, j);
				
				fields.add(tempField);
			}
		}
		
		System.out.println(fields.toString());
		
		int numOfFields = fields.size();
		for (int i = 0; i < numOfFields; i++) {
			Field tempField = fields.get(i);
			
			// Nem tökéletes, több szomszédot is hozzáad !!!
			for (int j = 0; j < numOfFields ; j++) {
				Field tTempField = fields.get(j);
				if ((((tTempField.getPoint().x - tempField.getPoint().x) == 0) &&
						(Math.abs((tTempField.getPoint().y - tempField.getPoint().y))) == 1) ||
						(((Math.abs((tTempField.getPoint().x - tempField.getPoint().x))) == 1) &&
						((tTempField.getPoint().y - tempField.getPoint().y) == 0)) ||
						(((Math.abs((tTempField.getPoint().x - tempField.getPoint().x))) == 1) &&
						(Math.abs((tTempField.getPoint().y - tempField.getPoint().y)) == 1)) 
//						 && (((tTempField.getPoint().x - tempField.getPoint().x) != -1) &&
//						((tTempField.getPoint().y - tempField.getPoint().y) != 1)) &&
//						(((tTempField.getPoint().x - tempField.getPoint().x) != 1) &&
//						((tTempField.getPoint().y - tempField.getPoint().y) != -1))
						) {
					tempField.addNeighbour(tTempField);
				}
			}
			
			System.out.println(fields.get(i).getNeighbours().toString());			
		}
		
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Magát a pályát adja meg.
	 * 
	 * @return {@code GameField} osztálypéldány
	 */
	public static GameField instanceOf() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		if (instance == null)
			instance = new GameField();

		Tracer.Instance().Trace(TracerDirection.Leave, instance);
		return instance;
	}

	/**
	 * Beregisztrálja a pályára a {@code Updatable} frissítendõ objektumot.
	 * 
	 * @param element frissítendõ objektum
	 */
	public void registerNewUpdatable(Updatable element) {
		Tracer.Instance().Trace(TracerDirection.Enter, element);
		this.toUpdate.add(element);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Frissíti a pálya frissítendõ objektumait.
	 */
	public void updateUpdatables() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		for (Updatable updatables : this.toUpdate) {
			updatables.update();
		}
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}