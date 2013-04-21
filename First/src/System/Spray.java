package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Sprayt megval�s�t� �soszt�ly.
 */
public class Spray {
	/**
	 * A spray kapacit�sa.
	 */
	protected int capacity;

	public Spray() {
		this.capacity = 20;
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
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
	 */
	public void onDraw() {
	}

	/**
	 * /**
	 * A {@code Field} param�terre {@code Smell} szagot rak.
	 * 
	 * @param mezo spray haszn�lata ezen a mez�n
	 */
	public void use(Field mezo) {
//		if(this.capacity > 0){
//			mezo.addSmell(new ExterminatorSmell());
//		}
	}

}