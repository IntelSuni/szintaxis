package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

/**
 * HangyaBolyt megval�s�t� oszt�ly
 */
public class AntHill implements Updatable, Element {

	/**
	 * A HangyaBoly ezen a mez�n van.
	 */
	private Field field;

	public AntHill() {
		super();
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
		return "AntHill []";
	}

	/**
	 * L�trehoz egy hangyabolyt a {@code field} mez�n.
	 * 
	 * @param field a mez�, amelyen a hangyaboly l�trej�n
	 */
	public AntHill(Field field) {
		Tracer.Instance().Trace(Direction.Enter, field);
		this.field = field;
		Tracer.Instance().Trace(Direction.Leave);
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
	 * @param visitor visit met�dus�nak megh�v�s�ra
	 */
	public void accept(Visitor visitor) {
		Tracer.Instance().Trace(Direction.Enter, visitor);
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
	 * L�trehoz egy �j hangy�t �s hangszagot, elhelyezi egy hangyabolyhoz 
	 * k�zeli mez�n �s a j�t�kos p�ly�ra is beregisztr�lja.
	 */
	public void update() {
		Tracer.Instance().Trace(Direction.Enter);
		
		Ant ant = new Ant(field);
		AntSmell antSmell = new AntSmell();

		field.addElement(ant);
		field.addSmell(antSmell);

		this.field.gameField.registerNewUpdatable(ant);

		Tracer.Instance().Trace(Direction.Leave);
	}
}
