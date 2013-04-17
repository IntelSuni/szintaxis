package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.Direction;

/**
 * Hangyairt�t megval�s�t� oszt�ly.
 */
public class Exterminator extends Spray {

	public Exterminator() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Exterminator []";
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
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * A {@code Field} param�terre �s szomsz�djaira {@code ExterminatorSmell} szagot rak.
	 * 
	 * @param mezo r� helyezei el az {@code ExterminatorSmell} szagot
	 */
	public void use(Field mezo) {
		Tracer.Instance().Trace(Direction.Enter,mezo);
		Tracer.Instance().Trace(Direction.Leave);
	}

}