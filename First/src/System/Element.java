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
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
	 */
	public abstract void onDraw();

	/**
	 * 
	 * @param view
	 */
	public void Attach(View view);

	/**
	 * 
	 * @param view
	 */
	public void Detach(View view);

	/**
	 * 
	 */
	public void NotifyView(Graphics2D g);
	
}