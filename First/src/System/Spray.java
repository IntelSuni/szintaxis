package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

/**
 * Fegyver interf�sz, a spray helyett
 * 
 * @author gbeatrix
 * @version 1.0
 * @created 20-m�rc.-2013 10:42:48
 */
public class Spray {

	private int capacity;

	public Spray() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void onDraw() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param mezo
	 */
	public void use(Field mezo) {
		Tracer.Instance().Trace(Direction.Enter,mezo);
		Tracer.Instance().Trace(Direction.Leave);
	}

}