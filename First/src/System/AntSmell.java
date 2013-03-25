package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

/**
 * HangyaSzagot megvalósító osztály.

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
	 * Beállítja a hangyaszagot.
	 * 
	 * @param ant a hangya, amire a szag hat
	 */
	public void activate(Ant ant) {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Csökkenti a hangyaszag intenzitását.
	 */
	public void decrementIntensity() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * A hangyaszag lekérdezésére szolgál.
	 * @return a hangyszag intenzitása
	 */
	public int getIntensity() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave,intensity);
		return intensity;
	}

	/**
	 * Az hangyaszag intenzitás frissítését végzi.
	 */
	public void update() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

}