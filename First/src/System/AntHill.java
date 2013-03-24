package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

/**
 * HangyaBolyt megvalósító osztály
 */
public class AntHill implements Updatable, Element {

	/**
	 * A HangyaBoly ezen a mezõn van.
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
	 * Létrehoz egy hangyabolyt a {@code field} mezõn.
	 * 
	 * @param field a mezõ, amelyen a hangyaboly létrejön
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
	 * Visitor tervezési mintának megfelelõ accept, a paraméterben megkapott {@code Visitor}-on meghívja annak visit metódusát önmagával paraméterezve.
	 * 
	 * @param visitor visit metódusának meghívására
	 */
	public void accept(Visitor visitor) {
		Tracer.Instance().Trace(Direction.Enter, visitor);
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
	 * Létrehoz egy új hangyát és hangszagot, elhelyezi egy hangyabolyhoz 
	 * közeli mezõn és a játékos pályára is beregisztrálja.
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
