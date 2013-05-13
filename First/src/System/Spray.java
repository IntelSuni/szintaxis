package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Sprayt megvalósító õsosztály.
 */
public class Spray {
	/**
	 * A spray kapacitása.
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
	 * Grafikus változathoz kirajzolásához.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * /**
	 * A {@code Field} paraméterre {@code Smell} szagot rak.
	 * 
	 * @param mezo spray használata ezen a mezõn
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
	 * Visszaadja a spray kapacitását.
	 * @return a spray kapacitása
	 */
	public int getCapacity(){
		return this.capacity;
	}

}