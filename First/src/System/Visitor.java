package System;

/**
 * Visitor interfész.
 * A Visitor tervezési minta megvalósítására szolgáló olyan interfész,
 * amely tartalmazza a Element interfészt megvalósító osztályok visit függvényeit.
 */
public interface Visitor {

	/**
	 * A paraméterben megkapott {@code Anteater} objektumon hívja meg szükséges metódusokat.
	 * 
	 * @param anteater
	 */
	public void visit(Anteater anteater);

	/**
	 * A paraméterben megkapott {@code FoodStore} objektumon hívja meg szükséges metódusokat.
	 * 
	 * @param foodstore
	 */
	public void visit(FoodStore foodstore);

	/**
	 *A paraméterben megkapott {@code Antlion} objektumon hívja meg szükséges metódusokat.
	 * 
	 * @param antlion
	 */
	public void visit(Antlion antlion);

	/**
	 * A paraméterben megkapott {@code Ant} objektumon hívja meg szükséges metódusokat. 
	 * @param ant
	 */
	public void visit(Ant ant);

	/**
	 * A paraméterben megkapott {@code Block} objektumon hívja meg szükséges metódusokat.
	 * 
	 * @param akadaly
	 */
	public void visit(Block akadaly);

}