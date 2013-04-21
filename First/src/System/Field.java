package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

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
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		neighbours = new ArrayList<Field>();
		elements = new ArrayList<Element>();
		smells = new ArrayList<Smell>();
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	/**
	 * A {@code GameField}-re l�trehozza a mez�t, inicializ�lja a szomsz�dokat, elemeket �s a szagokat.
	 * 
	 * @param gameField a {@code GameField}, amelyen a mez� van.
	 */
	public Field(GameField gameField) {
		Tracer.Instance().Trace(TracerDirection.Enter, gameField);
		this.gameField = gameField;

		neighbours = new ArrayList<Field>();
		elements = new ArrayList<Element>();
		smells = new ArrayList<Smell>();
		
		Tracer.Instance().Trace(TracerDirection.Leave);
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
	public boolean accept(Visitor visitor) {
		Tracer.Instance().Trace(TracerDirection.Enter, visitor);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return false;
	}

	/**
	 * Az {@code Element} objektumot a mez� {@code Element}-eket t�rol� list�j�hoz adja.
	 * 
	 * @param element az {@code Element}, amelyet a {@code Field}-hez ad
	 */
	public void addElement(Element element) {
		Tracer.Instance().Trace(TracerDirection.Enter, element);
		this.elements.add(element);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Hozz�ad egy szomsz�dot a szomsz�d list�hoz.
	 * 
	 * @param neighbour
	 *            Hozz�adand� szomsz�d.
	 */
	public void addNeighbour(Field neighbour) {
		Tracer.Instance().Trace(TracerDirection.Enter, neighbour);
//		if (this.neighbours.size() < 6) {
			this.neighbours.add(neighbour);
//		}
//		this.neighbours.add(neighbour);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Hozz�ad egy szagot egy mez�h�z �s a mez� szomsz�djaihoz.
	 * 
	 * @param smell
	 *            Hozz�adand� szag.
	 */
	// !!!!
	public void addSmell(Smell smell) {
		Tracer.Instance().Trace(TracerDirection.Enter, smell);
		
		smells.add(smell);
		int intensityNeighbours=smell.getIntensity()-1;
		ArrayList<Field> neighbours = this.getNeighbours();
		ArrayList<Smell> szSmells=null;
		for (Field n : neighbours){
			szSmells=n.getSmells();
			for(Smell s :szSmells){
				//ha a szomszedos mezon volt mar ilyen szag
				if(s.getClass()==smell.getClass()){
					//es annak az erossege gyengebb mint az ujonnan adogatott
					if(!(s.getIntensity()<intensityNeighbours)){
						//aakkor letrehozunk egy uj szagot
						if(smell.getClass()==ExterminatorSmell.class)
							n.addSmell(new ExterminatorSmell(intensityNeighbours));
						else
							n.addSmell(new FoodSmell(intensityNeighbours));
					}
				}
			}
		}
//		smell.decrementIntensity();
//		ArrayList<Field> neighbours = this.getNeighbours();
//		if (smell.getIntensity() > 0) {	
//			for (Field i : neighbours) {
//				if (i.getSmells().contains(smell) == false) {
//					i.addSmell(smell);
//				}
//				
//			}
//		}
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * {@code ArrayList<Element>} list�ban megadja a mez�n szerepl� {@code Element} objektumokat.
	 * 
	 * @return a mez�n lev� elemek
	 */
	public ArrayList<Element> getElements() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave, elements);
		return new ArrayList<Element>(elements);
	}

	/**
	 * {@code ArrayList<Field>} list�ban megadja a mez� szomsz�djait.
	 * 
	 * @return a mez�n szomsz�djai
	 */
	public ArrayList<Field> getNeighbours() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave, neighbours);
		return neighbours;
	}

	/**
	 * {@code Point}-ban megadja a mez�n koordin�t�it.
	 * 
	 * @return a mez� koordin�t�i
	 */
	public Point getPoint() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave, points);
		return points;
	}

	/**
	 * {@code ArrayList<Smell>} list�ban megadja a mez�n szerepl� {@code Smell} szagokat.
	 * 
	 * @return a mez�n lev� szagok
	 */
	public ArrayList<Smell> getSmells() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave, smells);
		return smells;
	}

	/**
	 * 
	 * @param h1 
	 */
	public boolean moveTo(Ant h1) {
		Tracer.Instance().Trace(TracerDirection.Enter, h1);
		for (Element e : this.elements) {
			e.accept(h1);
		}
		Tracer.Instance().Trace(TracerDirection.Leave);
		return false;
	}

	/**
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Elt�vol�tja az {@code Element} objektumot a mez�r�l.
	 * 
	 * @param element mez�r�l elt�vol�tand� elem
	 */
	public void removeElement(Element element) {
		Tracer.Instance().Trace(TracerDirection.Enter, element);
		this.elements.remove(element);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Elt�vol�tja az {@code Smell} szagot a mez�r�l.
	 * 
	 * @param smell mez�r�l elt�vol�tand� szag
	 */
	public void removeSmell(Smell smell) {
		Tracer.Instance().Trace(TracerDirection.Enter, smell);
		this.smells.remove(smell);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	public void removeSmell() {
		Tracer.Instance().Trace(TracerDirection.Enter);

		for (int i = 0; i < this.smells.size(); i++) {
			Smell s = this.smells.get(i);
			if (s instanceof AntSmell || s instanceof FoodSmell) {
				this.smells.remove(s);
			}
		}
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * 
	 * @param mov_blocked
	 */
	public void set_move_blocked(boolean mov_blocked) {
		Tracer.Instance().Trace(TracerDirection.Enter, mov_blocked);
		Tracer.Instance().Trace(TracerDirection.Leave);
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
		Tracer.Instance().Trace(TracerDirection.Enter, x, y);
		points = new Point(x, y);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}
