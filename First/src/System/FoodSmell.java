package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * �telSzagot megval�s�t� oszt�ly
 */
public class FoodSmell extends Smell {

	public FoodSmell() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	public FoodSmell(int intensity) {
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
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Cs�kkenti az �telszag intenzit�s�t.
	 */
	public void decrementIntensity() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Az �telszag lek�rdez�s�re szolg�l.
	 * @return az �telszag intenzit�sa
	 */
	public int getIntensity() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave,intensity);
		return intensity;
	}

	/**
	 * Az �telszag intenzit�s friss�t�s�t v�gzi.
	 */
	public void update() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}