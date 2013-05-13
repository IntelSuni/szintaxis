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
		Tracer.Instance().Trace(TracerDirection.Enter);
		this.capacity = 20;
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
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * /**
	 * A {@code Field} param�terre {@code Smell} szagot rak.
	 * 
	 * @param mezo spray haszn�lata ezen a mez�n
	 */
	public void use(Field mezo) {
		Tracer.Instance().Trace(TracerDirection.Enter,mezo);
		
//		if(this.capacity > 0){
//			mezo.addSmell(new ExterminatorSmell());
//		}
//		
//		this.capacity--;
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	/**
	 * Visszaadja a spray kapacit�s�t.
	 * @return a spray kapacit�sa
	 */
	public int getCapacity(){
		return this.capacity;
	}

}