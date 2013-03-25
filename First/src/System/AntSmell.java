package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

/**
 * HangyaSzagot megval�s�t� oszt�ly.

 */
public class AntSmell extends Smell {

	public AntSmell() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
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
	 * Be�ll�tja a hangyaszagot.
	 * 
	 * @param ant a hangya, amire a szag hat
	 */
	public void activate(Ant ant) {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Cs�kkenti a hangyaszag intenzit�s�t.
	 */
	public void decrementIntensity() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * A hangyaszag lek�rdez�s�re szolg�l.
	 * @return a hangyszag intenzit�sa
	 */
	public int getIntensity() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave,intensity);
		return intensity;
	}

	/**
	 * Az hangyaszag intenzit�s friss�t�s�t v�gzi.
	 */
	public void update() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

}