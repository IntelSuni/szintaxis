package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

/**
 * HangyaBoly
 * 
 * @author gbeatrix
 * @version 1.0
 * @created 20-m�rc.-2013 10:42:46
 */
public class AntHill implements Updatable, Element {

	private Field field;

	public AntHill() {
		super();
		Tracer.Instance().Trace(Direction.Enter);
		// System.out.println(getClass().getName() + " created.");
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
	 * 
	 * @param field
	 */
	public AntHill(Field field) {
		Tracer.Instance().Trace(Direction.Enter, field);
		this.field = field;
		// System.out.println(getClass().getName() + " created to "
		// + field.getClass().getName() + " field.");
		Tracer.Instance().Trace(Direction.Leave);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param visitor
	 */
	public void accept(Visitor visitor) {
		Tracer.Instance().Trace(Direction.Enter, visitor);
		Tracer.Instance().Trace(Direction.Leave);
	}

	public void onDraw() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	public void update() {

		Tracer.Instance().Trace(Direction.Enter);
		// final StackTraceElement[] ste =
		// Thread.currentThread().getStackTrace();
		// System.out.println(getClass().getName() + " " + ste[ste.length - 1 -
		// 1].getMethodName() + "() method called.");
		Ant ant = new Ant();
		AntSmell antSmell = new AntSmell();

		field.addElement(ant);
		field.addSmell(antSmell);

		this.field.gameField.registerNewUpdatable(ant);

		Tracer.Instance().Trace(Direction.Leave);
	}

}