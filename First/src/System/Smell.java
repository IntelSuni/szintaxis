package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Szagot megval�s�t� oszt�ly.
 */
public abstract class Smell implements Updatable {

	/**
	 * A szag intenzit�sa.
	 */
	protected int intensity;

	public Smell() {	
		this.intensity = 10;
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
	}

	/**
	 * Cs�kkenti a szag intenzit�s�t.
	 */
	public void decrementIntensity() {

	}

	/**
	 * A szag lek�rdez�s�re szolg�l.
	 * @return a szag intenzit�sa
	 */
	public int getIntensity() {
		return intensity;
	}

	/**
	 * A szag intenzit�s friss�t�s�t v�gzi.
	 */
	public void update() {
	}

}