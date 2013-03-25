package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

/**
 * �telRakt�rat megval�s�t� oszt�ly.
 */
public class FoodStore implements Element {
	/**
	 * Az �telRakt�r ezen a mez�n van.
	 */
	private Field field; // a mezo amin rajta van kell ahoz hogy amikor kiurul
							// meg lehessen szuntetni.
	/**
	 * Az �telRakt�rban lev� �telmennyis�g.
	 */
	private int food;

	public FoodStore() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * L�trehoz egy �telrakt�rat a {@code field} mez�n.
	 * 
	 * @param field a mez�, amelyen az �telrakt�r l�trej�n
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
	 * Visitor tervez�si mint�nak megfelel� accept, a param�terben megkapott {@code Visitor}-on megh�vja annak visit met�dus�t �nmag�val param�terezve.
	 *
	 * @param visitor
	 *            a {@code visitor}-on megh�vja a class a saj�t mag�hoz tartoz� f�ggv�nyt
	 */
	public void accept(Visitor visitor) {
		Tracer.Instance().Trace(Direction.Enter, visitor);
		visitor.visit(this);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * A hangya, aki megl�togatta ezt a �telrakt�rat megeszik bel�le valamennyit.
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
	 * {@code int} t�pusban megadja az �telrakt�rban lev� �tel mennyis�g�t.
	 * 
	 * @return az �telrakt�rban el�rhet� �telmennyis�g
	 */
	public int getFoodLeft() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave, food);
		return food;
	}

	/**
	 * A foodstore elt�vol�tja saj�t mag�t a mez�j�r�l.
	 */
	public void kill() {
		Tracer.Instance().Trace(Direction.Enter);
		field.removeElement(this);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

}
