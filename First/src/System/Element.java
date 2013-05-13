package System;

import java.awt.Graphics2D;

/**
 * Element interfész.
 */
public interface Element {

	/**
	 * Visitor tervezési mintának megfelelõ accept, a paraméterben megkapott {@code Visitor}-on meghívja annak visit metódusát önmagával paraméterezve.
	 * 
	 * @param visitor visit metódusának meghívására
	 */
	public boolean accept(Visitor visitor);

	/**
	 * @deprecated
	 * Grafikus változathoz kirajzoláshoz.
	 */
	public abstract void onDraw();

	/**
	 * A modellre felcsatolja a nézetet.
	 * @param view a nézet, amelyet felcsatol.
	 */
	public void Attach(View view);

	/**
	 * A modellrõl lecsatolja a nézetet.
	 * @param view a nézet, amelyet lecsatol
	 */
	public void Detach(View view);
	
	/**
	 * Az összes felcsatolt <code>View</code> nézetet lecsatolja.
	 */
	public void DetachAllViews();

	/**
	 * Értesíti a <code>View</code> nézeteket, hogy az objektumban változás történt, és 
	 * a nézetét újra kell rajzolni.
	 * @param g a nézetet erre az objektumra kell rajzolni
	 */
	public void NotifyView(Graphics2D g);
	
}