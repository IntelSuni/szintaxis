package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Mezõt megvalósító osztály.
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
	
//	private boolean move_blocked;
	
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
	/**
	 * A mezõre felcsatolt megjelenítõ nézetek.
	 */
	private Vector<View> views;

	/**
	 * Létrehozza a mezõt.
	 */
	public Field() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		neighbours = new ArrayList<Field>();
		elements = new ArrayList<Element>();
		smells = new ArrayList<Smell>();
		
		this.views = new Vector<View>();
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	/**
	 * A {@code GameField}-re létrehozza a mezõt, inicializálja a szomszédokat, elemeket és a szagokat.
	 * 
	 * @param gameField a {@code GameField}, amelyen a mezõ van.
	 */
	public Field(GameField gameField) {
		Tracer.Instance().Trace(TracerDirection.Enter, gameField);
		this.gameField = gameField;

		neighbours = new ArrayList<Field>();
		elements = new ArrayList<Element>();
		smells = new ArrayList<Smell>();
		
		this.views = new Vector<View>();
		
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

	/*
	 * (non-Javadoc)
	 * @see System.Element#accept(System.Visitor)
	 */
	public boolean accept(Visitor visitor) {
		Tracer.Instance().Trace(TracerDirection.Enter, visitor);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return false;
	}

	/**
	 * Az {@code Element} objektumot a mezõ {@code Element}-eket tároló listájához adja.
	 * 
	 * @param element az {@code Element}, amelyet a {@code Field}-hez ad
	 */
	public void addElement(Element element) {
		Tracer.Instance().Trace(TracerDirection.Enter, element);
		this.elements.add(element);
		
		// Ha az új elem hangya, akkor a mezõn hagy egy hangyaszagot.
		if (element instanceof Ant) {
			this.addSmell(new AntSmell());
		}
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Hozzáad egy szomszédot a szomszéd listához.
	 * 
	 * @param neighbour
	 *            Hozzáadandó szomszéd.
	 */
	public void addNeighbour(Field neighbour) {
		Tracer.Instance().Trace(TracerDirection.Enter, neighbour);
//		if (this.neighbours.size() < 6) {
			this.neighbours.add(neighbour);
//		}
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Hozzáad egy szagot egy mezõhöz és a mezõ szomszédjaihoz.
	 * 
	 * @param smell
	 *            Hozzáadandó szag.
	 */
	public void addSmell(Smell smell) {
		Tracer.Instance().Trace(TracerDirection.Enter, smell);
		
		smells.add(smell);
		
//		int intensityNeighbours=smell.getIntensity()-1;
//		ArrayList<Field> neighbours = this.getNeighbours();
//		ArrayList<Smell> szSmells=null;
//		for (Field n : neighbours){
//			szSmells=n.getSmells();
//			for(Smell s :szSmells){
//				//ha a szomszedos mezon volt mar ilyen szag
//				if(s.getClass()==smell.getClass()){
//					//es annak az erossege gyengebb mint az ujonnan adogatott
//					if(!(s.getIntensity()<intensityNeighbours)){
//						//aakkor letrehozunk egy uj szagot
//						if(smell instanceof ExterminatorSmell)
//							// StackOwerFlowError-t dob
//							n.addSmell(new ExterminatorSmell(intensityNeighbours));
//						else
//							n.addSmell(new FoodSmell(intensityNeighbours));
//					}
//				}
//			}
//		}
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	/**
	 * A mezõ szomszédjaihoz {@code Smell} szagot ad.
	 * 
	 * @param smell a hozzáadandó szag
	 */
	public void addSmellToNeighbours(Smell smell){
		Tracer.Instance().Trace(TracerDirection.Enter, smell);
		
		smell.decrementIntensity();
		ArrayList<Field> neighbours = this.getNeighbours();
		int nSize = neighbours.size();
		for (int i = 0; i < nSize; i++) {
			ArrayList<Smell> nSmells = neighbours.get(i).getSmells();
			int sSize = nSmells.size();
			for (int j = 0; j < sSize; j++) {
				Smell sSmell = nSmells.get(i);
				if (sSmell.getClass().equals(smell.getClass()) 
						&& sSmell.getIntensity() < smell.intensity) {
					sSmell = smell;
				}
			}
		}
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * {@code ArrayList<Element>} listában megadja a mezõn szereplõ {@code Element} objektumokat.
	 * 
	 * @return a mezõn levõ elemek
	 */
	public ArrayList<Element> getElements() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave, elements);
		return this.elements;
	}

	/**
	 * {@code ArrayList<Field>} listában megadja a mezõ szomszédjait.
	 * 
	 * @return a mezõn szomszédjai
	 */
	public ArrayList<Field> getNeighbours() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave, neighbours);
		return neighbours;
	}

	/**
	 * {@code Point}-ban megadja a mezõn koordinátáit.
	 * 
	 * @return a mezõ koordinátái
	 */
	public Point getPoint() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave, points);
		return points;
	}

	/**
	 * {@code ArrayList<Smell>} listában megadja a mezõn szereplõ {@code Smell} szagokat.
	 * 
	 * @return a mezõn levõ szagok
	 */
	public ArrayList<Smell> getSmells() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave, smells);
		return smells;
	}

	/**
	 * @deprecated
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

	/*
	 * (non-Javadoc)
	 * @see System.Element#onDraw()
	 */
	public void onDraw() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Eltávolítja az {@code Element} objektumot a mezõrõl.
	 * 
	 * @param element  eltávolítandó elem
	 */
	public void removeElement(Element element) {
		Tracer.Instance().Trace(TracerDirection.Enter, element);
		if (this.elements.contains(element)) {
			this.elements.remove(element);
		}
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Eltávolítja az {@code Smell} szagot a mezõrõl.
	 * 
	 * @param smell eltávolítandó szag
	 */
	public void removeSmell(Smell smell) {
		Tracer.Instance().Trace(TracerDirection.Enter, smell);
		this.smells.remove(smell);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	/**
	 * Eltávolítja a mezõrõl a hangya- és ételszag objektumokat.
	 */
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
	 * @deprecated
	 * @param mov_blocked
	 */
	public void set_move_blocked(boolean mov_blocked) {
		Tracer.Instance().Trace(TracerDirection.Enter, mov_blocked);
		Tracer.Instance().Trace(TracerDirection.Leave);
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
		Tracer.Instance().Trace(TracerDirection.Enter, x, y);
		points = new Point(x, y);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/*
	 * (non-Javadoc)
	 * @see System.Element#Attach(System.View)
	 */
	@Override
	public void Attach(View view) {
		if (this.views.isEmpty()) {
			this.views = new Vector<View>();
			this.views.add(view);
		}
		else{
			this.views.add(view);
		}	
	}

	/*
	 * (non-Javadoc)
	 * @see System.Element#Detach(System.View)
	 */
	@Override
	public void Detach(View view) {
		if (this.views.contains(view)) {
			this.views.remove(view);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see System.Element#NotifyView(java.awt.Graphics2D)
	 */
	@Override
	public void NotifyView(Graphics2D g) {
		for (View view : this.views) {
			view.draw(g);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see System.Element#DetachAllViews()
	 */
	@Override
	public void DetachAllViews() {
		this.views.clear();
		this.views = null;
	}

}
