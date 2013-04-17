package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.Direction;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Mez�t megval�s�t� oszt�ly
 */
public class Field implements Element {

	/**
	 * A mez� ezen a {@code GameField}-en van
	 */
	GameField gameField;
	/**
	 * A mez�n lev� {@code Element}-ek list�ja.
	 */
	private ArrayList<Element> elements;
	private boolean move_blocked;
	/**
	 * A mez�n szomsz�d {@code Element}-jeinek list�ja.
	 */
	private ArrayList<Field> neighbours;
	/**
	 * A mez�n koordin�t�i.
	 */
	private Point points;
	/**
	 * A mez�n lev� {@code Smell}-ek list�ja.
	 */
	private ArrayList<Smell> smells;

	public Field() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}
	
	/**
	 * A {@code GameField}-re l�trehozza a mez�t, inicializ�lja a szomsz�dokat, elemeket �s a szagokat.
	 * 
	 * @param gameField a {@code GameField}, amelyen a mez� van.
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
	 * Visitor tervez�si mint�nak megfelel� accept, a param�terben megkapott {@code Visitor}-on megh�vja annak visit met�dus�t �nmag�val param�terezve.
	 * 
	 * @param visitor visit met�dus�nak megh�v�s�ra
	 */
	public void accept(Visitor visitor) {
		Tracer.Instance().Trace(Direction.Enter, visitor);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Az {@code Element} objektumot a mez� {@code Element}-eket t�rol� list�j�hoz adja.
	 * 
	 * @param element az {@code Element}, amelyet a {@code Field}-hez ad
	 */
	public void addElement(Element element) {
		Tracer.Instance().Trace(Direction.Enter, element);
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

	/**
	 * {@code ArrayList<Element>} list�ban megadja a mez�n szerepl� {@code Element} objektumokat.
	 * 
	 * @return a mez�n lev� elemek
	 */
	public ArrayList<Element> getElements() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave, elements);
		return new ArrayList<Element>(elements);
	}

	/**
	 * {@code ArrayList<Field>} list�ban megadja a mez� szomsz�djait.
	 * 
	 * @return a mez�n szomsz�djai
	 */
	public ArrayList<Field> getNeighbours() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave, neighbours);
		return neighbours;
	}

	/**
	 * {@code Point}-ban megadja a mez�n koordin�t�it.
	 * 
	 * @return a mez� koordin�t�i
	 */
	public Point getPoint() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave, points);
		return points;
	}

	/**
	 * {@code ArrayList<Smell>} list�ban megadja a mez�n szerepl� {@code Smell} szagokat.
	 * 
	 * @return a mez�n lev� szagok
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
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Elt�vol�tja az {@code Element} objektumot a mez�r�l.
	 * 
	 * @param element mez�r�l elt�vol�tand� elem
	 */
	public void removeElement(Element element) {
		Tracer.Instance().Trace(Direction.Enter, element);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Elt�vol�tja az {@code Smell} szagot a mez�r�l.
	 * 
	 * @param smell mez�r�l elt�vol�tand� szag
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
