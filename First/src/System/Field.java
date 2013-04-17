package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.Direction;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Mezõt megvalósító osztály
 */
public class Field implements Element {

	/**
	 * A mezõ ezen a {@code GameField}-en van
	 */
	GameField gameField;
	/**
	 * A mezõn levõ {@code Element}-ek listája.
	 */
	private ArrayList<Element> elements;
	private boolean move_blocked;
	/**
	 * A mezõn szomszéd {@code Element}-jeinek listája.
	 */
	private ArrayList<Field> neighbours;
	/**
	 * A mezõn koordinátái.
	 */
	private Point points;
	/**
	 * A mezõn levõ {@code Smell}-ek listája.
	 */
	private ArrayList<Smell> smells;

	public Field() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}
	
	/**
	 * A {@code GameField}-re létrehozza a mezõt, inicializálja a szomszédokat, elemeket és a szagokat.
	 * 
	 * @param gameField a {@code GameField}, amelyen a mezõ van.
	 */
	public Field(GameField gameField) {
		Tracer.Instance().Trace(Direction.Enter, gameField);
		this.gameField = gameField;

		neighbours = new ArrayList<Field>();
		elements = new ArrayList<Element>();
		smells = new ArrayList<Smell>();
		
		Tracer.Instance().Trace(Direction.Leave);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Field [points=" + points + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * Visitor tervezési mintának megfelelõ accept, a paraméterben megkapott {@code Visitor}-on meghívja annak visit metódusát önmagával paraméterezve.
	 * 
	 * @param visitor visit metódusának meghívására
	 */
	public void accept(Visitor visitor) {
		Tracer.Instance().Trace(Direction.Enter, visitor);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Az {@code Element} objektumot a mezõ {@code Element}-eket tároló listájához adja.
	 * 
	 * @param element az {@code Element}, amelyet a {@code Field}-hez ad
	 */
	public void addElement(Element element) {
		Tracer.Instance().Trace(Direction.Enter, element);
		this.elements.add(element);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Hozzáad egy szomszédot a szomszéd listához.
	 * 
	 * @param neighbour
	 *            Hozzáadandó szomszéd.
	 */
	public void addNeighbour(Field neighbour) {
		Tracer.Instance().Trace(Direction.Enter, neighbour);
		neighbour.addElement(neighbour);
		neighbours.add(neighbour);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Hozzáad egy szagot egy mezõhöz és a mezõ szomszádjaihoz.
	 * 
	 * @param smell
	 *            Hozzáadandó szag.
	 */
	public void addSmell(Smell smell) {
		Tracer.Instance().Trace(Direction.Enter, smell);
		
		if (smell.getIntensity() > 0) {
			smell.decrementIntensity();
			for (Field i : this.getNeighbours()) {
				i.addSmell(smell);
			}
			smells.add(smell);
		}
		
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code ArrayList<Element>} listában megadja a mezõn szereplõ {@code Element} objektumokat.
	 * 
	 * @return a mezõn levõ elemek
	 */
	public ArrayList<Element> getElements() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave, elements);
		return new ArrayList<Element>(elements);
	}

	/**
	 * {@code ArrayList<Field>} listában megadja a mezõ szomszédjait.
	 * 
	 * @return a mezõn szomszédjai
	 */
	public ArrayList<Field> getNeighbours() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave, neighbours);
		return neighbours;
	}

	/**
	 * {@code Point}-ban megadja a mezõn koordinátáit.
	 * 
	 * @return a mezõ koordinátái
	 */
	public Point getPoint() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave, points);
		return points;
	}

	/**
	 * {@code ArrayList<Smell>} listában megadja a mezõn szereplõ {@code Smell} szagokat.
	 * 
	 * @return a mezõn levõ szagok
	 */
	public ArrayList<Smell> getSmells() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave, smells);
		return smells;
	}

	/**
	 * 
	 * @param h1 
	 */
	public boolean moveTo(Ant h1) {
		Tracer.Instance().Trace(Direction.Enter, h1);
		Tracer.Instance().Trace(Direction.Leave);
		return false;
	}

	/**
	 * Grafikus változathoz kirajzolásához.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Eltávolítja az {@code Element} objektumot a mezõrõl.
	 * 
	 * @param element mezõrõl eltávolítandó elem
	 */
	public void removeElement(Element element) {
		Tracer.Instance().Trace(Direction.Enter, element);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Eltávolítja az {@code Smell} szagot a mezõrõl.
	 * 
	 * @param smell mezõrõl eltávolítandó szag
	 */
	public void removeSmell(Smell smell) {
		Tracer.Instance().Trace(Direction.Enter, smell);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param mov_blocked
	 */
	public void set_move_blocked(boolean mov_blocked) {
		Tracer.Instance().Trace(Direction.Enter, mov_blocked);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Beállítja a mezõ koordinátáit
	 * 
	 * @param x
	 *            X koordináta.
	 * @param y
	 *            Y koordináta.
	 */
	public void setPoint(int x, int y) {
		Tracer.Instance().Trace(Direction.Enter, x, y);
		points = new Point(x, y);
		Tracer.Instance().Trace(Direction.Leave);
	}

}
