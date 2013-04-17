package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.Direction;

/**
 * Hangyalesõt megvalósító objektum.
 
 */
public class Antlion implements Element {

	/**
	 * A hangyalesõ ezen a mezõn van.
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
	 * Visitor tervezési mintának megfelelõ accept, a paraméterben megkapott {@code Visitor}-on meghívja annak visit metódusát önmagával paraméterezve.
	 * 
	 * @param visiting visit metódusának meghívására
	 */
	public void accept(Visitor visiting) {
		Tracer.Instance().Trace(Direction.Enter, visiting);
		visiting.visit(this);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Grafikus változathoz kirajzolásához.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Beállítja a {@code Field} paramétert a saját mezõjére.
	 * 
	 * @param field a mezõ, amelyre beállítja a saját mezõjét
	 */
	public void setField(Field field) {
		Tracer.Instance().Trace(Direction.Enter);
		this.currentField = field;
		Tracer.Instance().Trace(Direction.Leave, field);
	}

}