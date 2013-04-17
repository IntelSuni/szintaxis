package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.Direction;

import java.util.List;

/**
 * Hangyászt megvalósító osztály.
 */
public class Anteater implements Updatable, Element, Visitor {

	/**
	 * A hangyász ezen a mezõn van.
	 */
	private Field currentField;
	/**
	 * A hangyász által megevett hangyák száma.
	 */
	private int eatenAnts;

	public Anteater() {
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
		return "Anteater []";
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
	 * Eldönti és {@code Field}-ben visszaadja, hogy a {@code ArrayList<Field>} közül a hangyász hova lépjen.
	 * 
	 * @param fields a mezõk listája, amelyek közül kiválasztja a következõ mezõt
	 * @return Field a következõ mezõ, amelyre a hangya lép
	 */
	public Field decideDirection(List<Field> fields) {
		Tracer.Instance().Trace(Direction.Enter, fields);
		Field result = null;
		Tracer.Instance().Trace(Direction.Leave, result);
		return result;
	}

	/**
	 * Növeli a megevett hangyák számát, ha még ehet ({@code eatenAnts} < 3) 
	 * és megöli a mezõn szereplõ hangyát
	 */
	public void eat() {
		Tracer.Instance().Trace(Direction.Enter);
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
		Tracer.Instance().Trace(Direction.Enter, field);
		currentField = field;
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Megkéri az aktuális mezõt mondja meg ki a 
	 * szomszédja. Az eredményen meghívja a DecideDirection függvényt, majd törli a hangyász
	 * magát a aktuális mezõbõl és hozzáadja magát a másik mezõre. 
	 * Ha a mezõn hangya van, akkor megeszi.
	 */
	public void update() {
		Tracer.Instance().Trace(Direction.Enter);
		List<Field> neighbours = currentField.getNeighbours();
		Field target = decideDirection(neighbours);

		// A teszt miatt, mivel a decideDirection még nincs implementálva.
		target = neighbours.get(0);

		target.addElement(this);

		setField(target);

		List<Element> elements = target.getElements();

		for (Element element : elements) {
			element.accept(this);
		}

		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code Antlion} látogatása.
	 * 
	 * @param antlion visitáló objektum
	 */
	public void visit(Antlion antlion) {
		Tracer.Instance().Trace(Direction.Enter, antlion);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code Ant} látogatása.
	 * 
	 * @param ant visitáló objektum
	 */
	public void visit(Ant ant) {
		Tracer.Instance().Trace(Direction.Enter, ant);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code Block} látogatása.
	 * 
	 * @param akadaly visitáló objektum
	 */
	public void visit(Block akadaly) {
		Tracer.Instance().Trace(Direction.Enter, akadaly);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code FoodStore} látogatása.
	 * 
	 * @param foodstore visitáló objektum
	 */
	public void visit(FoodStore foodstore) {
		Tracer.Instance().Trace(Direction.Enter, foodstore);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code Anteater} látogatása esetén a hangya meghal.
	 * 
	 * @param anteater visitáló objektum
	 */
	public void visit(Anteater anteater) {
		Tracer.Instance().Trace(Direction.Enter, anteater);
		Tracer.Instance().Trace(Direction.Leave);
	}

}
