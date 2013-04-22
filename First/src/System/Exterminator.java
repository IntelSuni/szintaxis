package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Hangyairtót megvalósító osztály.
 */
public class Exterminator extends Spray {

	public Exterminator() {
		super();
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Exterminator []";
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
	 * A {@code Field} paraméterre és szomszédjaira {@code ExterminatorSmell} szagot rak.
	 * 
	 * @param mezo rá helyezei el az {@code ExterminatorSmell} szagot
	 */
	public void use(Field mezo) {
		Tracer.Instance().Trace(TracerDirection.Enter,mezo);
		
		if(this.capacity > 0){
			ExterminatorSmell exterminatorSmell = new ExterminatorSmell();
			// A mezõre tesz Irtószagot
			mezo.addSmell(exterminatorSmell);
//			mezo.addSmellToNeighbours(exterminatorSmell);
			
			// A mezõ hangya elemein aktiválja az irtószagot.
			for (Element e : mezo.getElements()) {
				if (e instanceof Ant) {
					exterminatorSmell.activate((Ant) e);
				}
			}
			
			// A mezõ szomszédjaira tesz irtószagot
			for (Field neighbours : mezo.getNeighbours()) {
				neighbours.addSmell(exterminatorSmell);
				for (Element e : neighbours.getElements()) {
					if (e instanceof Ant) {
						exterminatorSmell.activate((Ant) e);
					}
				}
			}
			this.capacity--;
			System.out.println(this.getClass().getSimpleName() + " used successfully on " + mezo.getPoint().x + "," + mezo.getPoint().y + " and its neighbours.");
		}
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}