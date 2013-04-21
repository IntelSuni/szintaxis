package System;

import java.util.ArrayList;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Hangyaszag semleges�t�t megval�s�t� oszt�ly.

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
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
	 */
	public void onDraw(){
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * A {@code Field} param�terre �s szomsz�djaira {@code ExterminatorSmell} szagot rak.
	 * 
	 * @param mezoelt�vol�tja a mez�r�l �s a szomsz�djair�l a hangyaszagot
	 */
	public void use(Field mezo){
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		if (this.capacity > 0) {
//			// Elt�nteti a mez�r�l a hangyaszagot.
//			ArrayList<Smell> Smells = mezo.getSmells();
//			for (Smell smells : Smells) {
//				if (smells.getClass().getName().contains("AntSmell")) {
//					mezo.removeSmell();
//					System.out.println("Itt kell elt�vol�tani.");
//				}
//			}
//			//Elt�nteti a mez� szomsz�djair�l a hangyaszagot.
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