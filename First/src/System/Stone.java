package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Kavicsot megval�s�t� oszt�ly.
 */
public class Stone extends Block {

	/**
	 * A hangy�szra felcsatolt megjelen�t� n�zetek.
	 */
	private Vector<View> views;
	
	/**
	 * L�trehoz egy kavics objektumot.
	 */
	public Stone() {
		this.views = new Vector<View>();
	}
	
	/**
	 * L�trehoz egy kavics objektumot a megadott mez�re.
	 * @param field a mez�, amelyen a kavics l�trej�n
	 */
	public Stone(Field field) {
		this.currentField = field;
		this.views = new Vector<View>();
	}
	
	/**
	 * A kavics ezen a mez�n van.
	 */
	private Field currentField;
	
	public Field getField(){
		return this.currentField;
	}
	
	/* (non-Javadoc)
	 * @see System.Block#accept(System.Visitor)
	 */
	@Override
	public boolean accept(Visitor visitor) {
		return visitor.visit(this);
	}
	/**
	 * K� mozgat�sa a direction parameter altal mutatott iranyba, returns false ha nem tud oda kovet rakni
	 * @param direction az ir�ny ahov� mozgatni szeretn�nk
	 * @return <code>true</code>, ha lehet az ir�nyba mozgatni
	 */
	boolean moving (Direction direction){
		Tracer.Instance().Trace(TracerDirection.Enter, direction);
		ArrayList<Field> fields = this.currentField.getNeighbours();
		//ez tartalmazza a masik mezot amire at kellene rakni a kavicsot
		Field result = null;
		int x,y;
		x=this.currentField.getPoint().x;
		y=this.currentField.getPoint().y;
		
		
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
		ArrayList<Element> elements=result.getElements();
		//megnezni hogy lehet e oda mozgatni a kovet
		for(Element e : elements){
			if(e.getClass()== Ant.class) continue;
			else if(e.getClass()== Anteater.class) continue;
			else if(e.getClass()== AntHill.class) return false;
			else if(e.getClass()== Antlion.class) return false;
			else if(e.getClass()== Block.class) return false;
			else if(e.getClass()== FoodStore.class) return false;
			else if(e.getClass()== Stone.class) return false;
			else if(e.getClass()== Antlion.class) return false;
		}
		//eddig nem jut el, ha volt valami mas mint hangya a mezon
		//ha volt hangya ott
		for(Element e:elements){
			if(e.getClass()== Ant.class) result.removeElement(e);
			}
		
		System.out.println("\tStone moved from " + this.currentField.getPoint().x + "," + this.currentField.getPoint().y + ".");
		//ko mozgatasa
		result.addElement(this);
		
		System.out.println("\tStone moved to " + result.getPoint().x + "," + result.getPoint().y + ".");

		currentField.removeElement(this);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see System.Block#Attach(System.View)
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
	 * @see System.Block#Detach(System.View)
	 */
	@Override
	public void Detach(View view) {
		if (this.views.contains(view)) {
			this.views.remove(view);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see System.Block#NotifyView(java.awt.Graphics2D)
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
