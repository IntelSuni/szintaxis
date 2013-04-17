package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.Direction;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

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
	 * P�ly�n lev� friss�tend� objektumok.
	 */
	private List<Updatable> toUpdate;
	/**
	 * Mez�ket t�rol� lista.
	 */
	public List<Field> fields;
	/**
	 * P�ly�n lev� friss�tend� objektumok.
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
	 * Hozz�ad egy {@code element}-et egy {@code field}-hez.
	 * @param element Hozz�adant� element.
	 * @param field Field, amihez hozz� szeretn�nk adni.
	 */
	public void addElementToField(Element element, Field field) {
		Tracer.Instance().Trace(Direction.Enter, element, field);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Hozz�adja a {@code Field} mez�t a mez�ket t�rol� list�hoz.
	 * 
	 * @param f p�ly�n mez�list�hoz hozz�adand� mez�
	 */
	public void addField(Field f) {
		Tracer.Instance().Trace(Direction.Enter, f);
		fields.add(f);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * A {@code Points} �ltal meghat�rozott {@code Field}-et adja meg.
	 * 
	 * @param points koordin�t�k, amely meghat�rozza a {@code Field}-et
	 * @return {@code Point} �ltal meghat�rozott {@code Field}
	 */
	public Field getField(Point points) {
		Tracer.Instance().Trace(Direction.Enter, points);
		Tracer.Instance().Trace(Direction.Leave);
		return null;
	}

	/**
	 * Inicializ�lja a j�t�kos mez�t:
	 * l�trehozza a p�ly�n tal�lhat� elemeket �s be�ll�tja �ket.
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
	 * Mag�t a p�ly�t adja meg.
	 * 
	 * @return {@code GameField} oszt�lyp�ld�ny
	 */
	public static GameField instanceOf() {
		Tracer.Instance().Trace(Direction.Enter);
		if (instance == null)
			instance = new GameField();

		Tracer.Instance().Trace(Direction.Leave, instance);
		return instance;
	}

	/**
	 * Beregisztr�lja a p�ly�ra a {@code Updatable} friss�tend� objektumot.
	 * 
	 * @param element friss�tend� objektum
	 */
	public void registerNewUpdatable(Updatable element) {
		Tracer.Instance().Trace(Direction.Enter, element);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Friss�ti a p�lya friss�tend� objektumait.
	 */
	public void updateUpdatables() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

}