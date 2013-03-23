package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

/**
 * Hangyairt�
 * 
 * @author gbeatrix
 * @version 1.0
 * @created 20-m�rc.-2013 10:42:47
 */
public class Exterminator extends Spray {

	public Exterminator() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Exterminator []";
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