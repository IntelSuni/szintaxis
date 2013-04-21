package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * IrtóSzagot megvalósító osztály.
 
 */
public class ExterminatorSmell extends Smell {

	public ExterminatorSmell() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		this.intensity = 5;
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
	 * Beállítja a paraméterként kapott hangya mérgezettségi szintjét.
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
	 * Csökkenti az irtószag intenzitását.
	 */
	public void decrementIntensity() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		if (this.intensity > 0) {
			this.intensity--;
		}
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Az irtószag lekérdezésére szolgál.
	 * @return az irtószag intenzitása
	 */
	public int getIntensity() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave,intensity);
		return intensity;
	}

	/**
	 * Az irtószag intenzitás frissítését végzi.
	 */
	public void update() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}