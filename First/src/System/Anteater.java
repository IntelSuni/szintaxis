package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

import java.util.List;

/**
 * evés: növeli a megevett számlálót, ha eléri a 3-at, nem eszik többet.
 * Hangyász
 * 
 * @author gbeatrix
 * @version 1.0
 * @created 20-márc.-2013 10:42:46
 */
public class Anteater implements Updatable, Element, Visitor {

	private Field currentField;
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

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param visiting
	 */
	public void accept(Visitor visiting) {
		Tracer.Instance().Trace(Direction.Enter, visiting);
		visiting.visit(this);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param fields
	 */
	public Field decideDirection(List<Field> fields) {
		Tracer.Instance().Trace(Direction.Enter, fields);
		Field result = null;
		Tracer.Instance().Trace(Direction.Leave, result);
		return result;
	}

	public void eat() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	public void onDraw() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param field
	 */
	public void setField(Field field) {
		Tracer.Instance().Trace(Direction.Enter, field);
		currentField = field;
		Tracer.Instance().Trace(Direction.Leave);
	}

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
	 * 
	 * @param antlion
	 */
	public void visit(Antlion antlion) {
		Tracer.Instance().Trace(Direction.Enter, antlion);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param ant
	 */
	public void visit(Ant ant) {
		Tracer.Instance().Trace(Direction.Enter, ant);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param akadaly
	 */
	public void visit(Block akadaly) {
		Tracer.Instance().Trace(Direction.Enter, akadaly);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param foodstore
	 */
	public void visit(FoodStore foodstore) {
		Tracer.Instance().Trace(Direction.Enter, foodstore);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param anteater
	 */
	public void visit(Anteater anteater) {
		Tracer.Instance().Trace(Direction.Enter, anteater);
		Tracer.Instance().Trace(Direction.Leave);
	}

}
