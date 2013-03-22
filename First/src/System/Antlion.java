package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

/**
 * Hangyales�
 * 
 * @author gbeatrix
 * @version 1.0
 * @created 20-m�rc.-2013 10:42:46
 */
public class Antlion implements Element {

	private Field currentField;

	public Antlion() {
		Tracer.Instance().Trace(Direction.Enter);
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

	public void onDraw() {

	}

	/**
	 * 
	 * @param field
	 */
	public void setField(Field field) {

	}

}