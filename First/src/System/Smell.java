package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Szagot megvalósító osztály.
 */
public abstract class Smell implements Updatable {

	/**
	 * A szag intenzitása.
	 */
	protected int intensity;

	public Smell() {	
		Tracer.Instance().Trace(TracerDirection.Enter);
		this.intensity = 10;
		Tracer.Instance().Trace(TracerDirection.Leave);
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
	 * Beállítja a szagot.
	 * 
	 * @param ant a hangya, amire hatunk
	 */
	public void activate(Ant ant) {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Csökkenti a szag intenzitását.
	 */
	public void decrementIntensity() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * A szag lekérdezésére szolgál.
	 * @return a szag intenzitása
	 */
	public int getIntensity() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave,intensity);
		return intensity;
	}

	/**
	 * A szag intenzitás frissítését végzi.
	 */
	public void update() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}