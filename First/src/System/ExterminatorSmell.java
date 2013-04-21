package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Irt�Szagot megval�s�t� oszt�ly.
 
 */
public class ExterminatorSmell extends Smell {

	public ExterminatorSmell() {
		this.intensity = 5;
	}
	/**
	 * amikor terjed a szag a szomszedoknal, ez a konstruktor van hasznalva
	 * valamint olxyan esetekben, amikor el akarunk terni az alapertelmezett szagerossegtol
	 * @param intensity	A szag erossege
	 */
	public ExterminatorSmell(int intensity) {
		this.intensity = intensity;
	}
	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExterminatorSmell []";
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
	 * Be�ll�tja a param�terk�nt kapott hangya m�rgezetts�gi szintj�t.
	 * 
	 * @param ant a hangya, amire hatunk
	 */
	public void activate(Ant ant) {
		ant.addPoisonLevel(intensity);
		this.decrementIntensity();
	}

	/**
	 * Cs�kkenti az irt�szag intenzit�s�t.
	 */
	public void decrementIntensity() {
		if (this.intensity > 0) {
			this.intensity--;
		}
	
	}

	/**
	 * Az irt�szag lek�rdez�s�re szolg�l.
	 * @return az irt�szag intenzit�sa
	 */
	public int getIntensity() {
		return intensity;
	}

	/**
	 * Az irt�szag intenzit�s friss�t�s�t v�gzi.
	 */
	public void update() {
	
	}

}