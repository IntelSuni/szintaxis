package System;

import java.awt.Graphics2D;
import java.util.Vector;

import hu.szintaxis.graphics.AntView;
import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Hangyabolyt megval�s�t� oszt�ly.
 */
public class AntHill implements Updatable, Element {

	/**
	 * A Hangyaboly ezen a mez�n van.
	 */
	private Field field;
	/**
	 * A hangybolyra felcsatolt megjelen�t� n�zetek.
	 */	
	private Vector<View> views;
	
	/**
	 * L�trehoz egy hangyabolyt.
	 */
	public AntHill() {
		super();
		this.views = new Vector<View>();
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AntHill []";
	}

	/**
	 * L�trehoz egy hangyabolyt a {@code field} mez�n.
	 * 
	 * @param field a mez�, amelyen a hangyaboly l�trej�n
	 */
	public AntHill(Field field) {
//		Tracer.Instance().Trace(TracerDirection.Enter, field);
		this.field = field;
		this.views = new Vector<View>();
//		System.out.println("Anteater successfully added at " + this.field.getPoint().x + "," + this.field.getPoint().y + ".");
//		Tracer.Instance().Trace(TracerDirection.Leave);
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
	 * Visszaadja a hangyaboly aktu�lis mez�j�t.
	 * @return a hangyaboly mez�je
	 */
	public Field getField(){
		return this.field;
	}
	
	/**
	 * Be�ll�tja a hangyaboly mez�j�t.
	 * @param field a hangyaboly �j mez�je
	 */
	public void setField(Field field){
		this.field = field;
	}
	
	/*
	 * (non-Javadoc)
	 * @see System.Element#accept(System.Visitor)
	 */
	public boolean accept(Visitor visitor) {
		Tracer.Instance().Trace(TracerDirection.Enter, visitor);
		boolean result=visitor.visit(this);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return result;
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
	 * L�trehoz egy �j hangy�t �s hangszagot, elhelyezi egy hangyabolyhoz 
	 * k�zeli mez�n �s a j�t�kos p�ly�ra is beregisztr�lja.
	 */
	public void update() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		// Ha nem siker�l szomsz�dra elhelyezni, akkor a saj�t mez�j�re rakja
		Ant ant = new Ant(field);
		AntSmell antSmell = new AntSmell();
		AntView antView = new AntView();
		antView.m_Ant = ant;
		ant.Attach(antView);

		field.addElement(ant);
		field.addSmell(antSmell);

		this.field.gameField.registerNewUpdatable(ant);
		System.out.println("Ant created.");

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
