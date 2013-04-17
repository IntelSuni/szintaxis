package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.Direction;

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
	 * Pályán levõ frissítendõ objektumok.
	 */
	private List<Updatable> toUpdate;
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
		Tracer.Instance().Trace(Direction.Enter);
		fields = new ArrayList<Field>();
		Tracer.Instance().Trace(Direction.Leave);
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
		Tracer.Instance().Trace(Direction.Enter, element, field);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Hozzáadja a {@code Field} mezõt a mezõket tároló listához.
	 * 
	 * @param f pályán mezõlistához hozzáadandó mezõ
	 */
	public void addField(Field f) {
		Tracer.Instance().Trace(Direction.Enter, f);
		fields.add(f);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * A {@code Points} által meghatározott {@code Field}-et adja meg.
	 * 
	 * @param points koordináták, amely meghatározza a {@code Field}-et
	 * @return {@code Point} által meghatározott {@code Field}
	 */
	public Field getField(Point points) {
		Tracer.Instance().Trace(Direction.Enter, points);
		Tracer.Instance().Trace(Direction.Leave);
		return null;
	}

	/**
	 * Inicializálja a játékos mezõt:
	 * létrehozza a pályán található elemeket és beállítja õket.
	 */
	public void Initialize() {
		Tracer.Instance().Trace(Direction.Enter);
		
		Field field1 = new Field(this);
		field1.setPoint(1, 1);
		
		Field neighbour1 = new Field(this);
		Field neighbour2 = new Field(this);
		Field neighbour3 = new Field(this);
		Field neighbour4 = new Field(this);
		Field neighbour5 = new Field(this);
		Field neighbour6 = new Field(this);
		
		neighbour1.setPoint(0, 1);
		neighbour2.setPoint(0, 2);
		neighbour3.setPoint(1, 0);
		neighbour4.setPoint(1, 2);
		neighbour5.setPoint(2, 1);
		neighbour6.setPoint(2, 2);
		
		field1.addNeighbour(neighbour1);
		field1.addNeighbour(neighbour2);
		field1.addNeighbour(neighbour3);
		field1.addNeighbour(neighbour4);
		field1.addNeighbour(neighbour5);
		field1.addNeighbour(neighbour6);
		
		FoodStore foodStore = new FoodStore();
		FoodSmell foodSmell = new FoodSmell();
		
		addElementToField(foodStore, field1);
		field1.addSmell(foodSmell);
		
		neighbour1.addSmell(new FoodSmell());
		neighbour2.addSmell(new FoodSmell());
		neighbour3.addSmell(new FoodSmell());
		neighbour4.addSmell(new FoodSmell());
		neighbour5.addSmell(new FoodSmell());
		neighbour6.addSmell(new FoodSmell());
		
		AntHill antHill = new AntHill();
		addElementToField(antHill, neighbour1);
		
		Block block = new Block();
		addElementToField(block, neighbour4);
		
		
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Magát a pályát adja meg.
	 * 
	 * @return {@code GameField} osztálypéldány
	 */
	public static GameField instanceOf() {
		Tracer.Instance().Trace(Direction.Enter);
		if (instance == null)
			instance = new GameField();

		Tracer.Instance().Trace(Direction.Leave, instance);
		return instance;
	}

	/**
	 * Beregisztrálja a pályára a {@code Updatable} frissítendõ objektumot.
	 * 
	 * @param element frissítendõ objektum
	 */
	public void registerNewUpdatable(Updatable element) {
		Tracer.Instance().Trace(Direction.Enter, element);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Frissíti a pálya frissítendõ objektumait.
	 */
	public void updateUpdatables() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

}