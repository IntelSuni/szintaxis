package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Hangy�szt megval�s�t� oszt�ly.
 */
public class Anteater implements Updatable, Element, Visitor {

	/**
	 * A hangy�sz ezen a mez�n van.
	 */
	private Field currentField;
	/**
	 * A hangy�sz �ltal megevett hangy�k sz�ma.
	 */
	private int eatenAnts;
	/**
	 * A hangy�sz halad�si ir�nya
	 */
	private Direction direction;
	/**
	 * A hangy�szra felcsatolt megjelen�t� n�zetek.
	 */
	private Vector<View> views;

	/**
	 *  A hangy�szt l�trehozza alap�rtelmezett keleti ir�ny�
	 *  halad�si ir�nnyal.
	 */
	public Anteater() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		eatenAnts=0;
		currentField=null;
		direction=Direction.east;
		this.views = new Vector<View>();
//		GameField.instanceOf().registerNewUpdatable(this);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * A hangy�szt l�trehozza a mez�n.
	 * @param field a hangy�sz erre a mez�re ker�lt l�trehoz�sra
	 */
	public Anteater(Field field){
		eatenAnts=0;
		currentField=field;
		direction=Direction.east;
		this.views = new Vector<View>();
//		GameField.instanceOf().registerNewUpdatable(this);
	}
	/**
	 * Az alap ir�ny megv�laszt�sa l�trehoz�skor.
	 * 
	 * @param field a hangy�sz erre a mez�re ker�l l�trehoz�sra
	 * @param defDirection a hangy�sz halad�si ir�ny�nak be�ll�t�sa
	 */
	public Anteater(Field field, Direction defDirection){
		eatenAnts=0;
		currentField=field;
		direction=defDirection;
//		GameField.instanceOf().registerNewUpdatable(this);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Anteater []";
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
	 * Megadja a hangy�sz melyik mez�n van.
	 * @return <code>Field</code> ezen a mez�n van a hangy�sz
	 */
	public Field getField(){
		return this.currentField;
	}

	/*
	 * (non-Javadoc)
	 * @see System.Element#accept(System.Visitor)
	 */
	public boolean accept(Visitor visiting) {
		Tracer.Instance().Trace(TracerDirection.Enter, visiting);
		boolean result=visiting.visit(this);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return result;
	}

	/**
	 * Eld�nti �s {@code Field}-ben visszaadja, hogy a {@code ArrayList<Field>} k�z�l a hangy�sz hova l�pjen.
	 * 
	 * @param fields a mez�k list�ja, amelyek k�z��l kiv�lasztja a k�vetkez� mez�t
	 * @return Field a k�vetkez� mez�, amelyre a hangya l�p
	 */
	public Field decideDirection(ArrayList<Field> fields) {
		Tracer.Instance().Trace(TracerDirection.Enter, fields);
		Field result = null;
		int x,y;
		x=currentField.getPoint().x;
		y=currentField.getPoint().y;
		
		switch (direction) {
		case east:	
			for(Field f : fields){
				if (f != null) {
					if (f.getPoint().y==y){
						//y-t lecser�ltem x-re, mert k�l�nben nem adott vissz eredm�nyt
						if(f.getPoint().x>x)result=f;
					}
				}	
			}
			break;
		case northEast:		
			for(Field f : fields){
				if (f != null) {
					if (f.getPoint().y>=y){
						if(f.getPoint().x>x)result=f;
					}
				}
			}
			break;
		case northWest:		
			for(Field f : fields){
				if (f != null) {
					if (f.getPoint().y<=y){
						if(f.getPoint().x<x)result=f;
					}
				}
			}
			break;
		case west:
			for(Field f : fields){
				if (f != null) {
					if (f.getPoint().y==y){
						if(f.getPoint().x<x)result=f;
					}
				}
				if (f.getPoint().y==y){
					if(f.getPoint().x<x)result=f;
				}
			}
			break;
		case southWest:		
			for(Field f : fields){
				if (f != null) {
					if (f.getPoint().y<=y){
						if(f.getPoint().x<y)result=f;
					}
				}
			}
			break;
		case southEast:		
			for(Field f : fields){
				if (f != null) {
					if (f.getPoint().y<=y){
						if(f.getPoint().x>y)result=f;
					}
				}
			}
			break;

		default:
			break;

		}
		Tracer.Instance().Trace(TracerDirection.Leave, result);
		return result;
	}

	/**
	 * N�veli a megevett hangy�k sz�m�t, ha m�g ehet ({@code eatenAnts} < 3) 
	 * �s meg�li a mez�n szerepl� hangy�t
	 * @param ant a hangya, amelyet megeszik
	 */
	public void eat(Ant ant) {
		Tracer.Instance().Trace(TracerDirection.Enter);
		if (this.eatenAnts < 3) {
			this.eatenAnts++;
			ant.kill();
			ant = null;
			System.out.println("\tAnt killed by Anteater.");
			System.out.println("\tAnteater ate an Ant.");
		}
		Tracer.Instance().Trace(TracerDirection.Leave, this.eatenAnts);
	
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
	 * Be�ll�tja a {@code Field} param�tert a saj�t mez�j�re.
	 * 
	 * @param field a mez�, amelyre be�ll�tja a saj�t mez�j�t
	 */
	public void setField(Field field) {
		Tracer.Instance().Trace(TracerDirection.Enter, field);
		currentField = field;
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Megk�ri az aktu�lis mez�t mondja meg ki a 
	 * szomsz�dja. Az eredm�nyen megh�vja a DecideDirection f�ggv�nyt, majd t�rli a hangy�sz
	 * mag�t a aktu�lis mez�b�l �s hozz�adja mag�t a m�sik mez�re. 
	 * Ha a mez�n hangya van, akkor megeszi.
	 */
	public void update() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		ArrayList<Field> neighbours = currentField.getNeighbours();
		Field target = decideDirection(neighbours);
		
		if (target != null) {
			Field prev=currentField;
			
			System.out.println("\tAnteater moved from " + this.currentField.getPoint().x + "," + this.currentField.getPoint().y + ".");

			currentField.removeElement(this);
			target.addElement(this);
			this.setField(target);

			System.out.println("\tAnteater moved to " + this.currentField.getPoint().x + "," + this.currentField.getPoint().y + ".");
			
			ArrayList<Element> elements = target.getElements();

			// ConcurentModificationException megsz�ntet�se
//			for (Element element : elements) {
//				if(!element.accept(this)){
//					currentField=prev;
//					target.removeElement(this);
//					currentField.addElement(this);
//					direction=direction.negate();
//				}
//			}
			
			int eSize = elements.size();
			for (int i = 0; i < eSize - 1; i++) {
				Element element = elements.get(i);
				if (!element.accept(this)) {
					currentField = prev;
					target.removeElement(this);
					currentField.addElement(this);
					direction = direction.negate();
				}
			}
		}
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/*
	 * (non-Javadoc)
	 * @see System.Visitor#visit(System.Antlion)
	 */
	public boolean visit(Antlion antlion) {
		Tracer.Instance().Trace(TracerDirection.Enter, antlion);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see System.Visitor#visit(System.Ant)
	 */
	public boolean visit(Ant ant) {
		Tracer.Instance().Trace(TracerDirection.Enter, ant);
		eat(ant);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see System.Visitor#visit(System.Block)
	 */
	public boolean visit(Block akadaly) {
		Tracer.Instance().Trace(TracerDirection.Enter, akadaly);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see System.Visitor#visit(System.FoodStore)
	 */
	public boolean visit(FoodStore foodstore) {
		Tracer.Instance().Trace(TracerDirection.Enter, foodstore);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see System.Visitor#visit(System.Anteater)
	 */
	public boolean visit(Anteater anteater) {
		Tracer.Instance().Trace(TracerDirection.Enter, anteater);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see System.Visitor#visit(System.Stone)
	 */
	@Override
	public boolean visit(Stone stone) {
		Tracer.Instance().Trace(TracerDirection.Enter, stone);
		
		boolean result=stone.moving(direction);
		if (result == true) {
			System.out.println("\tAnteater moved stone.");
		}
		else{
			System.out.println("\tAnteater cannot moved stone.");
		}
		Tracer.Instance().Trace(TracerDirection.Leave);
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * @see System.Visitor#visit(System.AntHill)
	 */
	@Override
	public boolean visit(AntHill antHill) {
		return true;
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
