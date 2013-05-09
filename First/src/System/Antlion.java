package System;

import java.util.Vector;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Hangyales�t megval�s�t� objektum.
 
 */
public class Antlion implements Element {

	/**
	 * A hangyales� ezen a mez�n van.
	 */
	private Field currentField;
	
	private Vector<View> views;

	public Antlion() {
//		Tracer.Instance().Trace(TracerDirection.Enter);
		this.views = new Vector<View>();
//		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	public Antlion(Field field) {
//		Tracer.Instance().Trace(TracerDirection.Enter);
		this.currentField = field;
		this.views = new Vector<View>();
		this.NotifyView();
//		System.out.println("Anteater successfully added at " + this.currentField.getPoint().x + "," + this.currentField.getPoint().y + ".");
//		Tracer.Instance().Trace(TracerDirection.Leave);
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

	/**
	 * Visitor tervez�si mint�nak megfelel� accept, a param�terben megkapott {@code Visitor}-on megh�vja annak visit met�dus�t �nmag�val param�terezve.
	 * 
	 * @param visiting visit met�dus�nak megh�v�s�ra
	 */
	public boolean accept(Visitor visiting) {
		Tracer.Instance().Trace(TracerDirection.Enter, visiting);
		boolean result=visiting.visit(this);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return result;
	}

	/**
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
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
//		Tracer.Instance().Trace(TracerDirection.Enter);
		this.currentField = field;
//		System.out.println("Anteater successfully added at " + this.currentField.getPoint().x + "," + this.currentField.getPoint().y + ".");
//		Tracer.Instance().Trace(TracerDirection.Leave, field);
	}

	@Override
	public void Attach(View view) {
		if (this.views.isEmpty()) {
			this.views = new Vector<View>();
		}
		else{
			this.views.add(view);
		}	
	}

	@Override
	public void Detach(View view) {
		if (this.views.contains(view)) {
			this.views.remove(view);
		}
	}

	@Override
	public void NotifyView() {
		for (View view : this.views) {
			view.Update();
		}
	}

}