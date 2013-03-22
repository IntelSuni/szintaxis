package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Mezõ tárolja, hogy rá lehet lépni maximált mérgezési szintje van, ha többször
 * fújsz rá a méregszint csökken, ha hangy átmegy rajta át lehet e rajta
 * haladni, vagy nem ---- getElements() visszaadja hogy milyen elemek vannak
 * rajta, (pl Hangyalesõ, Hangyász) stb..
 * 
 * @author gbeatrix
 * @version 1.0
 * @created 20-márc.-2013 10:42:47
 */
public class Field implements Element {

	/**
	 * Elem és Visitable egy interface
	 */

	// ez új
	GameField gameField;

	private ArrayList<Element> element;
	private boolean move_blocked;
	private ArrayList<Field> neighbours;
	private Point points;
	private ArrayList<Smell> smells;
	public Smell m_Smell;
	public Element m_Element;

	public Field() {
		Tracer.Instance().Trace(Direction.Enter);
		// System.out.println(getClass().getName() + " created.");
		Tracer.Instance().Trace(Direction.Leave);
	}

	public Field(GameField gameField) {
		Tracer.Instance().Trace(Direction.Enter, gameField);
		this.gameField = gameField;
		// System.out.println(getClass().getName() + " created.");
		Tracer.Instance().Trace(Direction.Leave);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param visitor
	 */
	public void accept(Visitor visitor) {
		Tracer.Instance().Trace(Direction.Enter,visitor);
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
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param neighbour
	 */
	public void addNeighbour(Field neighbour) {
		Tracer.Instance().Trace(Direction.Enter,neighbour);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param smell
	 */
	public void addSmell(Smell smell) {
		Tracer.Instance().Trace(Direction.Enter, smell);
		// final StackTraceElement[] ste =
		// Thread.currentThread().getStackTrace();
		// System.out.println(getClass().getName() + " " + ste[ste.length - 1 -
		// 2].getMethodName() + "() method called with "
		// + smell.getClass().getName() + " parameter.");
		Tracer.Instance().Trace(Direction.Leave);
	}

	public ArrayList<Element> getElements() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave,element);
		return element;
	}

	public ArrayList<Field> getNeighbours() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave,neighbours);
		return neighbours;
	}

	public Point getPoint() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave,points);
		return points;
	}

	public ArrayList<Smell> getSmells() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave,smells);
		return smells;
	}

	/**
	 * 
	 * @param h1
	 */
	public boolean moveTo(Ant h1) {
		Tracer.Instance().Trace(Direction.Enter,h1);
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
		Tracer.Instance().Trace(Direction.Enter,element);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param smell
	 */
	public void removeSmell(Smell smell) {
		Tracer.Instance().Trace(Direction.Enter,smell);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param mov_blocked
	 */
	public void set_move_blocked(boolean mov_blocked) {
		Tracer.Instance().Trace(Direction.Enter,mov_blocked);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param y
	 * @param x
	 */
	public void setPoint(int y, int x) {
		Tracer.Instance().Trace(Direction.Enter,x,y);
		Tracer.Instance().Trace(Direction.Leave);
	}

}