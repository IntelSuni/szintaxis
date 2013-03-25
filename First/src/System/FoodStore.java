package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

/**
 * ÉtelRaktárat megvalósító osztály.
 */
public class FoodStore implements Element {
	/**
	 * Az ÉtelRaktár ezen a mezõn van.
	 */
	private Field field; // a mezo amin rajta van kell ahoz hogy amikor kiurul
							// meg lehessen szuntetni.
	/**
	 * Az ÉtelRaktárban levõ ételmennyiség.
	 */
	private int food;

	public FoodStore() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Létrehoz egy ételraktárat a {@code field} mezõn.
	 * 
	 * @param field a mezõ, amelyen az ételraktár létrejön
	 */
	public FoodStore(Field field) {
		Tracer.Instance().Trace(Direction.Enter, field);
		this.field = field;
		Tracer.Instance().Trace(Direction.Leave);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FoodStore []";
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
	 * @param visitor
	 *            a {@code visitor}-on meghívja a class a saját magához tartozó függvényt
	 */
	public void accept(Visitor visitor) {
		Tracer.Instance().Trace(Direction.Enter, visitor);
		visitor.visit(this);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * A hangya, aki meglátogatta ezt a ételraktárat megeszik belõle valamennyit.
	 */
	public void eat() {
		Tracer.Instance().Trace(Direction.Enter);

		food--; // nem tudom mennyit eszik meg a hangya itt 1et vettem le
		if (food <= 0) {
			this.kill();
		}

		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code int} típusban megadja az ételraktárban levõ étel mennyiségét.
	 * 
	 * @return az ételraktárban elérhetõ ételmennyiség
	 */
	public int getFoodLeft() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave, food);
		return food;
	}

	/**
	 * A foodstore eltávolítja saját magát a mezõjérõl.
	 */
	public void kill() {
		Tracer.Instance().Trace(Direction.Enter);
		field.removeElement(this);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Grafikus változathoz kirajzolásához.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

}
