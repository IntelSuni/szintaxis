package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * HangyaSzagot megval�s�t� oszt�ly.

 */
public class AntSmell extends Smell {

	public AntSmell() {
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
	}

	/**
	 * Cs�kkenti a hangyaszag intenzit�s�t.
	 */
	public void decrementIntensity() {
		if (this.intensity > 0) {
			this.intensity--;
		}
	}

	/**
	 * A hangyaszag lek�rdez�s�re szolg�l.
	 * @return a hangyszag intenzit�sa
	 */
	public int getIntensity() {
		return intensity;
	}

	/**
	 * Az hangyaszag intenzit�s friss�t�s�t v�gzi.
	 */
	public void update() {
	}

}