package System;

import java.awt.Graphics2D;

/**
 * Element interf�sz.
 */
public interface Element {

	/**
	 * Visitor tervez�si mint�nak megfelel� accept, a param�terben megkapott {@code Visitor}-on megh�vja annak visit met�dus�t �nmag�val param�terezve.
	 * 
	 * @param visitor visit met�dus�nak megh�v�s�ra
	 */
	public boolean accept(Visitor visitor);

	/**
	 * @deprecated
	 * Grafikus v�ltozathoz kirajzol�shoz.
	 */
	public abstract void onDraw();

	/**
	 * A modellre felcsatolja a n�zetet.
	 * @param view a n�zet, amelyet felcsatol.
	 */
	public void Attach(View view);

	/**
	 * A modellr�l lecsatolja a n�zetet.
	 * @param view a n�zet, amelyet lecsatol
	 */
	public void Detach(View view);
	
	/**
	 * Az �sszes felcsatolt <code>View</code> n�zetet lecsatolja.
	 */
	public void DetachAllViews();

	/**
	 * �rtes�ti a <code>View</code> n�zeteket, hogy az objektumban v�ltoz�s t�rt�nt, �s 
	 * a n�zet�t �jra kell rajzolni.
	 * @param g a n�zetet erre az objektumra kell rajzolni
	 */
	public void NotifyView(Graphics2D g);
	
}