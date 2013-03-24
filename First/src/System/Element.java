package System;

/**
 * Element interfész.
 */
public interface Element {

	/**
	 * Visitor tervezési mintának megfelelõ accept, a paraméterben megkapott {@code Visitor}-on meghívja annak visit metódusát önmagával paraméterezve.
	 * 
	 * @param visitor visit metódusának meghívására
	 */
	public void accept(Visitor visitor);

	/**
	 * Grafikus változathoz kirajzolásához.
	 */
	public abstract void onDraw();

}