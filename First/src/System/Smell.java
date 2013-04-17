package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.Direction;

/**
 * Szagot megval�s�t� oszt�ly.
 */
public abstract class Smell implements Updatable {

	/**
	 * A szag intenzit�sa.
	 */
	protected int intensity;

	public Smell() {	
		Tracer.Instance().Trace(Direction.Enter);
		this.intensity = 10;
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
	 * Be�ll�tja a szagot.
	 * 
	 * @param ant a hangya, amire hatunk
	 */
	public void activate(Ant ant) {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Cs�kkenti a szag intenzit�s�t.
	 */
	public void decrementIntensity() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * A szag lek�rdez�s�re szolg�l.
	 * @return a szag intenzit�sa
	 */
	public int getIntensity() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave,intensity);
		return intensity;
	}

	/**
	 * A szag intenzit�s friss�t�s�t v�gzi.
	 */
	public void update() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

}