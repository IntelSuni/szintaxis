package System;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Mez�
 * t�rolja, hogy r� lehet l�pni
 * maxim�lt m�rgez�si szintje van, ha t�bbsz�r f�jsz r�
 * a m�regszint cs�kken, ha hangy �tmegy rajta
 * �t lehet e rajta haladni, vagy nem
 * ----
 * getElements() visszaadja hogy milyen elemek vannak rajta, (pl Hangyales�,
 * Hangy�sz) stb..
 * @author gbeatrix
 * @version 1.0
 * @created 20-m�rc.-2013 10:42:47
 */
public class Field implements Element {

	/**
	 * Elem �s Visitable egy interface
	 */
	
	//ez �j
	GameField gameField;
	
	private ArrayList<Element> element;
	private boolean move_blocked;
	private ArrayList<Field> neighbours;
	private Point points;
	private ArrayList<Smell> smells;
	public Smell m_Smell;
	public Element m_Element;

	public Field(){
		System.out.println(getClass().getName() + " created.");
	}
	
	public Field(GameField gameField){
		this.gameField = gameField;
		System.out.println(getClass().getName() + " created.");
	}
	

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param visitor
	 */
	public void accept(Visitor visitor){

	}

	/**
	 * 
	 * @param element
	 */
	public void addElement(Element element){
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println(getClass().getName() + " " + ste[ste.length - 1 - 2].getMethodName() + "() method called with " 
				+ element.getClass().getName() + " parameter.");
	}

	/**
	 * 
	 * @param neighbour
	 */
	public void addNeighbour(Field neighbour){

	}

	/**
	 * 
	 * @param smell
	 */
	public void addSmell(Smell smell){
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println(getClass().getName() + " " + ste[ste.length - 1 - 2].getMethodName() + "() method called with " 
				+ smell.getClass().getName() + " parameter.");
	}

	public ArrayList<Element> getElements(){
		return null;
	}

	public ArrayList<Field> getNeighbours(){
		return null;
	}

	public Point getPoint(){
		return null;
	}

	public ArrayList<Smell> getSmells(){
		return null;
	}

	/**
	 * 
	 * @param h1
	 */
	public boolean moveTo(Ant h1){
		return false;
	}

	public void onDraw(){

	}

	/**
	 * 
	 * @param element
	 */
	public void removeElement(Element element){

	}

	/**
	 * 
	 * @param smell
	 */
	public void removeSmell(Smell smell){

	}

	/**
	 * 
	 * @param mov_blocked
	 */
	public void set_move_blocked(boolean mov_blocked){

	}

	/**
	 * 
	 * @param y
	 * @param x
	 */
	public void setPoint(int y, int x){

	}

}