package System;

import java.awt.Graphics2D;
import java.util.Vector;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Hangyalesõt megvalósító osztály.
 
 */
public class Antlion implements Element {

	/**
	 * A hangyalesõ ezen a mezõn van.
	 */
	private Field currentField;
	/**
	 * A hangyalesõre felcsatolt megjelenítõ nézetek.
	 */
	private Vector<View> views;

	/**
	 * Létrehoz egy hangyalesõt.
	 */
	public Antlion() {
//		Tracer.Instance().Trace(TracerDirection.Enter);
		this.views = new Vector<View>();
//		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	/**
	 * Létrehoz egy hangyalesõt, a megadott mezõn.
	 * @param field a hangyalesõt ezen a mezõn hozza létre
	 */
	public Antlion(Field field) {
//		Tracer.Instance().Trace(TracerDirection.Enter);
		this.currentField = field;
		this.views = new Vector<View>();
//		System.out.println("Anteater successfully added at " + this.currentField.getPoint().x + "," + this.currentField.getPoint().y + ".");
//		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	/**
	 * Megadja a hangyalesõ melyik mezõn van.
	 * @return <code>Field</code> ezen a mezõn van a hangyalesõ
	 */
	public Field getField(){
		return this.currentField;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Antlion []";
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
	public boolean accept(Visitor visiting) {
		Tracer.Instance().Trace(TracerDirection.Enter, visiting);
		boolean result=visiting.visit(this);
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
	 * Beállítja a {@code Field} paramétert a saját mezõjére.
	 * 
	 * @param field a mezõ, amelyre beállítja a saját mezõjét
	 */
	public void setField(Field field) {
//		Tracer.Instance().Trace(TracerDirection.Enter);
		this.currentField = field;
//		System.out.println("Anteater successfully added at " + this.currentField.getPoint().x + "," + this.currentField.getPoint().y + ".");
//		Tracer.Instance().Trace(TracerDirection.Leave, field);
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