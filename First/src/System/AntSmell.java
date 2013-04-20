package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * HangyaSzagot megvalósító osztály.

 */
public class AntSmell extends Smell {

	public AntSmell() {
		Tracer.Instance().Trace(TracerDirection.Enter);
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
	 * Beállítja a hangyaszagot.
	 * 
	 * @param ant a hangya, amire a szag hat
	 */
	public void activate(Ant ant) {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Csökkenti a hangyaszag intenzitását.
	 */
	public void decrementIntensity() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		if (this.intensity > 0) {
			this.intensity--;
		}
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * A hangyaszag lekérdezésére szolgál.
	 * @return a hangyszag intenzitása
	 */
	public int getIntensity() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave,intensity);
		return intensity;
	}

	/**
	 * Az hangyaszag intenzitás frissítését végzi.
	 */
	public void update() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}