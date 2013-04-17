package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.Direction;

/**
 * Hangyales�t megval�s�t� objektum.
 
 */
public class Antlion implements Element {

	/**
	 * A hangyales� ezen a mez�n van.
	 */
	private Field currentField;

	public Antlion() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
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
	public void accept(Visitor visiting) {
		Tracer.Instance().Trace(Direction.Enter, visiting);
		visiting.visit(this);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Be�ll�tja a {@code Field} param�tert a saj�t mez�j�re.
	 * 
	 * @param field a mez�, amelyre be�ll�tja a saj�t mez�j�t
	 */
	public void setField(Field field) {
		Tracer.Instance().Trace(Direction.Enter);
		this.currentField = field;
		Tracer.Instance().Trace(Direction.Leave, field);
	}

}