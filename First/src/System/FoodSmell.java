package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

/**
 * ÉtelSzagot megvalósító osztály
 */
public class FoodSmell extends Smell {

	public FoodSmell() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
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
	 * Beállítja az ételszagot.
	 * 
	 * @param ant a hangya, amire a szag hat
	 */
	public void activate(Ant ant) {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Csökkenti az ételszag intenzitását.
	 */
	public void decrementIntensity() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Az ételszag lekérdezésére szolgál.
	 * @return az ételszag intenzitása
	 */
	public int getIntensity() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave,intensity);
		return intensity;
	}

	/**
	 * Az ételszag intenzitás frissítését végzi.
	 */
	public void update() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

}