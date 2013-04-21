package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * �telSzagot megval�s�t� oszt�ly
 */
public class FoodSmell extends Smell {

	public FoodSmell() {
	}
	
	public FoodSmell(int intensity) {
		this.intensity = intensity;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FoodSmell []";
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
	 * Be�ll�tja az �telszagot.
	 * 
	 * @param ant a hangya, amire a szag hat
	 */
	public void activate(Ant ant) {
	}

	/**
	 * Cs�kkenti az �telszag intenzit�s�t.
	 */
	public void decrementIntensity() {
	}

	/**
	 * Az �telszag lek�rdez�s�re szolg�l.
	 * @return az �telszag intenzit�sa
	 */
	public int getIntensity() {
		return intensity;
	}

	/**
	 * Az �telszag intenzit�s friss�t�s�t v�gzi.
	 */
	public void update() {
	}

}