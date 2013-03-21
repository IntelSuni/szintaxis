package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

import java.util.ArrayList;

/**
 * bool változó tárolja, hogy a hangya mérgezett e; csökkenti az életét
 * 
 * @author gbeatrix
 * @version 1.0
 * @created 20-márc.-2013 10:42:45
 */
public class Ant implements Updatable, Visitor, Element {

	private Field field;
	private int HealtPoint;
	private int poisonLevel;
	private ArrayList<Field> visitedFields;

	public Ant() {
		Tracer.Instance().Trace(Direction.Enter);
		// System.out.println(getClass().getName() + " created.");
		Tracer.Instance().Trace(Direction.Leave);
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param visiting
	 */
	public void accept(Visitor visiting) {

	}

	/**
	 * 
	 * @param level
	 */
	public void addPoisonLevel(int level) {

	}

	/**
	 * 
	 * @param f
	 */
	public void blocked_direction(Field f) {

	}

	/**
	 * 
	 * @param a
	 */
	public Field decideDirection(ArrayList<Field> a) {
		return null;
	}

	public void decreaseHealtPoint() {

	}

	public void kill() {

	}

	public void onDraw() {

	}

	/**
	 * 
	 * @param field
	 */
	public void setField(Field field) {

	}

	public void update() {

	}

	/**
	 * 
	 * @param antlion
	 */
	public void visit(Antlion antlion) {

	}

	/**
	 * 
	 * @param ant
	 */
	public void visit(Ant ant) {

	}

	/**
	 * 
	 * @param akadaly
	 */
	public void visit(Block akadaly) {

	}

	/**
	 * 
	 * @param foodstore
	 */
	public void visit(FoodStore foodstore) {

	}

	/**
	 * 
	 * @param anteater
	 */
	public void visit(Anteater anteater) {

	}

}