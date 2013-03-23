package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Pálya
 * 
 * @author gbeatrix
 * @version 1.0
 * @created 20-márc.-2013 10:42:47
 */
public class GameField {

	private int anteaterNo;
	private int antHillNo;
	private int blockNo;
	private int foodStoreNo;
	private static GameField instance;
	private Point size;
	private List<Updatable> toUpdate;
	public List<Field> fields;
	public List<Updatable> updatables;
	public Game game;

	public void finalize() throws Throwable {
		super.finalize();
	}

	// csak a próba miatt public, eredetileg private !
	public GameField() {
		Tracer.Instance().Trace(Direction.Enter);
		fields = new ArrayList<Field>();
		Tracer.Instance().Trace(Direction.Leave);
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
	 * 
	 * @param f
	 */
	public void addField(Field f) {
		Tracer.Instance().Trace(Direction.Enter, f);
		fields.add(f);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param points
	 */
	public Field getField(Point points) {
		Tracer.Instance().Trace(Direction.Enter, points);
		Tracer.Instance().Trace(Direction.Leave);
		return null;
	}

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

	public static GameField instanceOf() {
		Tracer.Instance().Trace(Direction.Enter);
		if (instance == null)
			instance = new GameField();

		Tracer.Instance().Trace(Direction.Leave, instance);
		return instance;
	}

	/**
	 * 
	 * @param element
	 */
	public void registerNewUpdatable(Updatable element) {
		Tracer.Instance().Trace(Direction.Enter, element);
		Tracer.Instance().Trace(Direction.Leave);
	}

	public void updateUpdatables() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

}