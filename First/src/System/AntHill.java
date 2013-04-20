package System;

import java.util.ArrayList;
import java.util.Random;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

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
	 * Létrehoz egy hangyabolyt a {@code field} mezõn.
	 * 
	 * @param field a mezõ, amelyen a hangyaboly létrejön
	 */
	public AntHill(Field field) {
		Tracer.Instance().Trace(TracerDirection.Enter, field);
		this.field = field;
		Tracer.Instance().Trace(TracerDirection.Leave);
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
		Tracer.Instance().Trace(TracerDirection.Enter, visitor);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	/**
	 * Grafikus változathoz kirajzolásához.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Létrehoz egy új hangyát és hangszagot, elhelyezi egy hangyabolyhoz 
	 * közeli mezõn és a játékos pályára is beregisztrálja.
	 */
	public void update() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		// 1-6 közötti random számot generál
//		int randomFieldNum = new Random().nextInt(6 - 1 + 1) + 1;
//		
//		// A mezõ szomszédjai alapján kiválasztja az új hangya mezõjét
//		ArrayList<Field> neighbours = this.field.getNeighbours();
//		if (neighbours.size() >= randomFieldNum) {
//			Field randomField = neighbours.get(randomFieldNum - 1);
//			
//			Ant ant = new Ant(randomField);
//			randomField.addElement(ant);
//			
//			AntSmell antSmell = new AntSmell();
//			randomField.addSmell(antSmell);
//			
//			this.field.gameField.registerNewUpdatable(ant);
//		}
		
		// Ha nem sikerül szomszédra elhelyezni, akkor a saját mezõjére rakja
		Ant ant = new Ant(field);
		AntSmell antSmell = new AntSmell();

		field.addElement(ant);
		field.addSmell(antSmell);

		this.field.gameField.registerNewUpdatable(ant);

		Tracer.Instance().Trace(TracerDirection.Leave);
	}
}
