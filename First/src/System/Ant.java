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
		super.finalize();
	}

	/**
	 * 
	 * @param visiting
	 */
	public void accept(Visitor visiting) {
		Tracer.Instance().Trace(Direction.Enter,visiting);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param level
	 */
	public void addPoisonLevel(int level) {
		Tracer.Instance().Trace(Direction.Enter,level);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param f
	 */
	public void blocked_direction(Field f) {
		Tracer.Instance().Trace(Direction.Enter,f);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param a
	 */
	public Field decideDirection(ArrayList<Field> a) {
		Tracer.Instance().Trace(Direction.Enter,a);
		Tracer.Instance().Trace(Direction.Leave,field);
		return null;
	}

	public void decreaseHealtPoint() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	public void kill() {
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
		Tracer.Instance().Trace(Direction.Enter,field);
		Tracer.Instance().Trace(Direction.Leave);
	}

	public void update() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param antlion
	 */
	public void visit(Antlion antlion) {
		Tracer.Instance().Trace(Direction.Enter,antlion);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param ant
	 */
	public void visit(Ant ant) {
		Tracer.Instance().Trace(Direction.Enter,ant);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param akadaly
	 */
	public void visit(Block akadaly) {
		Tracer.Instance().Trace(Direction.Enter,akadaly);
		Tracer.Instance().Trace(Direction.Leave);

	}

	/**
	 * 
	 * @param foodstore
	 */
	public void visit(FoodStore foodstore) {
		Tracer.Instance().Trace(Direction.Enter,foodstore);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param anteater
	 */
	public void visit(Anteater anteater) {
		Tracer.Instance().Trace(Direction.Enter,anteater);
		Tracer.Instance().Trace(Direction.Leave);
	}

}