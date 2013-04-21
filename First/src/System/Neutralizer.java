package System;

import java.util.ArrayList;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Hangyaszag semlegesítõt megvalósító osztály.

 */
public class Neutralizer extends Spray {

	public Neutralizer(){
		super();
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Neutralizer []";
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
	public void onDraw(){
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * A {@code Field} paraméterre és szomszédjaira {@code ExterminatorSmell} szagot rak.
	 * 
	 * @param mezoeltávolítja a mezõrõl és a szomszédjairól a hangyaszagot
	 */
	public void use(Field mezo){
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		if (this.capacity > 0) {
//			// Eltünteti a mezõrõl a hangyaszagot.
//			ArrayList<Smell> Smells = mezo.getSmells();
//			for (Smell smells : Smells) {
//				if (smells.getClass().getName().contains("AntSmell")) {
//					mezo.removeSmell();
//					System.out.println("Itt kell eltávolítani.");
//				}
//			}
//			//Eltünteti a mezõ szomszédjairól a hangyaszagot.
//			ArrayList<Field> neighbours = mezo.getNeighbours();
//			for (Field field : neighbours) {
//				ArrayList<Smell> nSmells = mezo.getSmells();
//				for (Smell smells : nSmells) {
//					if (smells.getClass().getName().contains("AntSmell")) {
//						mezo.removeSmell();;
//					}
//				}
//			}
			mezo.removeSmell();
			this.capacity--;
		}
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}