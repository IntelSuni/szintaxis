package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.Direction;

/**
 * Sprayt megvalósító õsosztály.
 */
public class Spray {
	/**
	 * A spray kapacitása.
	 */
	private int capacity;

	public Spray() {
		Tracer.Instance().Trace(Direction.Enter);
		this.capacity = 20;
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
	 * Grafikus változathoz kirajzolásához.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * /**
	 * A {@code Field} paraméterre {@code Smell} szagot rak.
	 * 
	 * @param mezo spray használata ezen a mezõn
	 */
	public void use(Field mezo) {
		Tracer.Instance().Trace(Direction.Enter,mezo);
		
		if(this.capacity > 0){
			mezo.addSmell(new ExterminatorSmell());
		}
		
		Tracer.Instance().Trace(Direction.Leave);
	}

}