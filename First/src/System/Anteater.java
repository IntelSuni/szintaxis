package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Hangyászt megvalósító osztály.
 */
public class Anteater implements Updatable, Element, Visitor {

	/**
	 * A hangyász ezen a mezõn van.
	 */
	private Field currentField;
	/**
	 * A hangyász által megevett hangyák száma.
	 */
	private int eatenAnts;
	/**
	 * A hangyász haladási iránya
	 */
	private Direction direction;
	/**
	 * A hangyászra felcsatolt megjelenítõ nézetek.
	 */
	private Vector<View> views;

	/**
	 *  A hangyászt létrehozza alapértelmezett keleti irányú
	 *  haladási iránnyal.
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
	 * A hangyászt létrehozza a mezõn.
	 * @param field a hangyász erre a mezõre került létrehozásra
	 */
	public Anteater(Field field){
		eatenAnts=0;
		currentField=field;
		direction=Direction.east;
		this.views = new Vector<View>();
//		GameField.instanceOf().registerNewUpdatable(this);
	}
	/**
	 * Az alap irány megválasztása létrehozáskor.
	 * 
	 * @param field a hangyász erre a mezõre kerül létrehozásra
	 * @param defDirection a hangyász haladási irányának beállítása
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
	 * Megadja a hangyász melyik mezõn van.
	 * @return <code>Field</code> ezen a mezõn van a hangyász
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
	 * Eldönti és {@code Field}-ben visszaadja, hogy a {@code ArrayList<Field>} küzül a hangyász hova lépjen.
	 * 
	 * @param fields a mezõk listája, amelyek közïül kiválasztja a következõ mezõt
	 * @return Field a következõ mezõ, amelyre a hangya lép
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
						//y-t lecseréltem x-re, mert különben nem adott vissz eredményt
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
	 * Növeli a megevett hangyák számát, ha még ehet ({@code eatenAnts} < 3) 
	 * és megöli a mezõn szereplõ hangyát
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
	 * Beállítja a {@code Field} paramétert a saját mezõjére.
	 * 
	 * @param field a mezõ, amelyre beállítja a saját mezõjét
	 */
	public void setField(Field field) {
		Tracer.Instance().Trace(TracerDirection.Enter, field);
		currentField = field;
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Megkéri az aktuális mezõt mondja meg ki a 
	 * szomszédja. Az eredményen meghívja a DecideDirection függvényt, majd törli a hangyász
	 * magát a aktuális mezõbõl és hozzáadja magát a másik mezõre. 
	 * Ha a mezõn hangya van, akkor megeszi.
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

			// ConcurentModificationException megszüntetése
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
