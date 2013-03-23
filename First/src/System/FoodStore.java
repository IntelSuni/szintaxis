package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

/**
 * kivettem a kill() metódust, hiszen õ hívja meg a hangyán, nem pedig rajta !
 * 
 * @author gbeatrix
 * @version 1.0
 * @created 20-márc.-2013 10:42:47
 */
public class FoodStore implements Element {
	private Field field; //a mezo amin rajta van kell ahoz hogy amikor kiurul meg lehessen szuntetni.
	private int food;

	public FoodStore() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FoodStore []";
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param visitor
	 * a visitoron meghívja a class a saját magához tartozó függvényt
	 */
	public void accept(Visitor visitor) {
		Tracer.Instance().Trace(Direction.Enter,visitor);
		visitor.visit(this);
		Tracer.Instance().Trace(Direction.Leave);
	}
	/**
	 * a hangya aki meglátogatta ezt a kajaraktárat megeszik belõle valamennyit
	 * van még ellenõrzés benne arról hogy a raktár kifogyott e
	 */
	public void eat() {
		Tracer.Instance().Trace(Direction.Enter);
		
		food--;		//nem tudom mennyit eszik meg a hangya itt 1et vettem le
		if (food<=0){
			this.kill();
		}
		
		Tracer.Instance().Trace(Direction.Leave);
	}

	public int getFoodLeft() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave,food);
		return food;
	}
	
	/**
	 * a foodstore eltávolítja saját magát
	 */
	public void kill() {
		Tracer.Instance().Trace(Direction.Enter);
		field.removeElement(this);
		Tracer.Instance().Trace(Direction.Leave);
	}

	public void onDraw() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

}