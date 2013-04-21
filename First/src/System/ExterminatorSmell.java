package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Irt�Szagot megval�s�t� oszt�ly.
 
 */
public class ExterminatorSmell extends Smell {

	public ExterminatorSmell() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		this.intensity = 5;
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	/**
	 * amikor terjed a szag a szomszedoknal, ez a konstruktor van hasznalva
	 * valamint olxyan esetekben, amikor el akarunk terni az alapertelmezett szagerossegtol
	 * @param intensity	A szag erossege
	 */
	public ExterminatorSmell(int intensity) {
		Tracer.Instance().Trace(TracerDirection.Enter);
		this.intensity = intensity;
		Tracer.Instance().Trace(TracerDirection.Leave);
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
		Tracer.Instance().Trace(TracerDirection.Enter);
		ant.addPoisonLevel(intensity);
		this.decrementIntensity();
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Cs�kkenti az irt�szag intenzit�s�t.
	 */
	public void decrementIntensity() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		if (this.intensity > 0) {
			this.intensity--;
		}
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Az irt�szag lek�rdez�s�re szolg�l.
	 * @return az irt�szag intenzit�sa
	 */
	public int getIntensity() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave,intensity);
		return intensity;
	}

	/**
	 * Az irt�szag intenzit�s friss�t�s�t v�gzi.
	 */
	public void update() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}