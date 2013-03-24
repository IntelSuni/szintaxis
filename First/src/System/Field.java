package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Mez� t�rolja, hogy r� lehet l�pni maxim�lt m�rgez�si szintje van, ha t�bbsz�r
 * f�jsz r� a m�regszint cs�kken, ha hangy �tmegy rajta �t lehet e rajta
 * haladni, vagy nem ---- getElements() visszaadja hogy milyen elemek vannak
 * rajta, (pl Hangyales�, Hangy�sz) stb..
 * 
 * @author gbeatrix
 * @version 1.0
 * @created 20-m�rc.-2013 10:42:47
 */
public class Field implements Element {

	/**
	 * Elem �s Visitable egy interface
	 */

	// ez �j
	GameField gameField;

	private ArrayList<Element> elements;
	private boolean move_blocked;
	private ArrayList<Field> neighbours;
	private Point points;
	private ArrayList<Smell> smells;

	public Field() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	public Field(GameField gameField) {
		Tracer.Instance().Trace(Direction.Enter, gameField);
		this.gameField = gameField;

		neighbours = new ArrayList<Field>();
		elements = new ArrayList<Element>();
		smells = new ArrayList<Smell>();
		// System.out.println(getClass().getName() + " created.");
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

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param visitor
	 */
	public void accept(Visitor visitor) {
		Tracer.Instance().Trace(Direction.Enter, visitor);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param element
	 */
	public void addElement(Element element) {
		Tracer.Instance().Trace(Direction.Enter, element);
		// final StackTraceElement[] ste =
		// Thread.currentThread().getStackTrace();
		// System.out.println(getClass().getName() + " " + ste[ste.length - 1 -
		// 2].getMethodName() + "() method called with "
		// + element.getClass().getName() + " parameter.");
		this.elements.add(element);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Hozz�ad egy szomsz�dot a szomsz�d list�hoz.
	 * 
	 * @param neighbour
	 *            Hozz�adand� szomsz�d.
	 */
	public void addNeighbour(Field neighbour) {
		Tracer.Instance().Trace(Direction.Enter, neighbour);
		neighbour.addElement(neighbour);
		neighbours.add(neighbour);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Hozz�ad egy szagot egy mez�h�z �s a mez� szomsz�djaihoz.
	 * 
	 * @param smell
	 *            Hozz�adand� szag.
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

	public ArrayList<Element> getElements() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave, elements);
		return new ArrayList<Element>(elements);

	}

	public ArrayList<Field> getNeighbours() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave, neighbours);
		return neighbours;
	}

	public Point getPoint() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave, points);
		return points;
	}

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

	public void onDraw() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param element
	 */
	public void removeElement(Element element) {
		Tracer.Instance().Trace(Direction.Enter, element);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param smell
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
	 * Be�ll�tja a mez� koordin�t�it
	 * 
	 * @param x
	 *            X koordin�ta.
	 * @param y
	 *            Y koordin�ta.
	 */
	public void setPoint(int x, int y) {
		Tracer.Instance().Trace(Direction.Enter, x, y);
		points = new Point(x, y);
		Tracer.Instance().Trace(Direction.Leave);
	}

}
