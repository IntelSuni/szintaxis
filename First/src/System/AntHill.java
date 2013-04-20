package System;

import java.util.ArrayList;
import java.util.Random;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.Direction;

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
		
		// 1-6 k�z�tti random sz�mot gener�l
		int randomFieldNum = new Random().nextInt(6 - 1 + 1) + 1;
		
		// A mez� szomsz�djai alapj�n kiv�lasztja az �j hangya mez�j�t
		ArrayList<Field> neighbours = this.field.getNeighbours();
		if (neighbours.size() >= randomFieldNum) {
			Field randomField = neighbours.get(randomFieldNum - 1);
			
			Ant ant = new Ant(randomField);
			randomField.addElement(ant);
			
			AntSmell antSmell = new AntSmell();
			randomField.addSmell(antSmell);
			
			this.field.gameField.registerNewUpdatable(ant);
		}
		
		// Ha nem siker�l szomsz�dra elhelyezni, akkor a saj�t mez�j�re rakja
		Ant ant = new Ant(field);
		AntSmell antSmell = new AntSmell();

		field.addElement(ant);
		field.addSmell(antSmell);

		this.field.gameField.registerNewUpdatable(ant);

		Tracer.Instance().Trace(Direction.Leave);
	}
}
