package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

/**
 * IrtóSzagot megvalósító osztály.
 
 */
public class ExterminatorSmell extends Smell {

	public ExterminatorSmell() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
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
	 * Beállítja a paraméterként kapott hangya mérgezettségi szintjét.
	 * 
	 * @param ant a hangya, amire hatunk
	 */
	public void activate(Ant ant) {
		Tracer.Instance().Trace(Direction.Enter);
		ant.addPoisonLevel(intensity);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Csökkenti az irtószag intenzitását.
	 */
	public void decrementIntensity() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Az irtószag lekérdezésére szolgál.
	 * @return az irtószag intenzitása
	 */
	public int getIntensity() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave,intensity);
		return intensity;
	}

	/**
	 * Az irtószag intenzitás frissítését végzi.
	 */
	public void update() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

}