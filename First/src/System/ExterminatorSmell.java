package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * IrtóSzagot megvalósító osztály.
 */
public class ExterminatorSmell extends Smell {

	/**
	 * Az irtószag ezen a mezõn van.
	 */
	Field field;

	/**
	 * Irtószagot hoz létre a magadott mezõn.
	 * 
	 * @param field az irtószagot erre a mezõre hozza létre
	 */
	public ExterminatorSmell(Field field) {
		Tracer.Instance().Trace(TracerDirection.Enter);
		this.intensity = 5;
		this.field = field;
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Amikor terjed a szag a szomszedoknal, ez a konstruktor van hasznalva
	 * valamint olyan esetekben, amikor el akarunk terni az alapertelmezett
	 * szagerossegtol.
	 * 
	 * @param intensity
	 *            A szag erõssége
	 */
	public ExterminatorSmell(int intensity) {
		Tracer.Instance().Trace(TracerDirection.Enter);
		this.intensity = intensity;
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/*
	 * (non-Javadoc)
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
	 * Beállítja a paraméterként kapott hangya mérgezettségi
	 * szintjét.
	 * 
	 * @param ant
	 *            a hangya, amire hat
	 */
	public void activate(Ant ant) {
		Tracer.Instance().Trace(TracerDirection.Enter);
		ant.addPoisonLevel(intensity);
		System.out.println("\tAnt get poisoned.");
		this.decrementIntensity();
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Csökkenti az irtószag intenzitását.
	 */
	public void decrementIntensity() {
		// Tracer.Instance().Trace(TracerDirection.Enter);

		if (this.intensity > 0) {
			this.intensity--;
		}
		if (intensity == 0) {
			field.removeSmell(this);
		}

		// Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Az irtószag lekérdezésére szolgál.
	 * 
	 * @return az irtószag intenzitása
	 */
	public int getIntensity() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave, intensity);
		return intensity;
	}

	/**
	 * Az irtószag intenzitás frissítését végzi.
	 */
	public void update() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		decrementIntensity();
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}