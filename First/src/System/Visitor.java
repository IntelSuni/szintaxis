package System;

/**
 * Visitor interész.
 * A Visitor tervezési minta megvalósítására szolgáló olyan interféz,
 * amely tartalmazza a Element interfészt megvalósító osztályok visit függvényeit.
 */
public interface Visitor {

	/**
	 * A paraméterben megkapott {@code Anteater} objektumon hívja meg a szükséges metódusokat.
	 * 
	 * @param anteater
	 * @return Lehetséges e erre a mezõre lépni.
	 */
	public boolean visit(Anteater anteater);

	/**
	 * A paraméterben megkapott {@code FoodStore} objektumon hívja meg a szükséges metódusokat.
	 * 
	 * @param foodstore
	 * @return Lehetséges e erre a mezõre lépni.
	 */
	public boolean visit(FoodStore foodstore);

	/**
	 * A paraméterben megkapott {@code Antlion antlion} objektumon hívja meg a szükséges metódusokat.
	 * 
	 * @param antlion
	 * @return Lehetséges e erre a mezõre lépni.
	 */
	public boolean visit(Antlion antlion);

	/**
	 * A paraméterben megkapott {@code Ant} objektumon hívja meg a szükséges metódusokat.
	 * 
	 * @param ant
	 * @return Lehetséges e erre a mezõre lépni.
	 */
	public boolean visit(Ant ant);

	/**
	 * A paraméterben megkapott {@code Block} objektumon hívja meg a szükséges metódusokat.
	 * 
	 * @param block
	 * @return Lehetséges e erre a mezõre lépni.
	 */
	public boolean visit(Block block);
	
	/**
	 * A paraméterben megkapott {@code Stone} objektumon hívja meg a szükséges metódusokat.
	 * 
	 * @param stone
	 * @return Lehetséges e erre a mezõre lépni.
	 */
	public boolean visit(Stone stone);

	/**
	 * A paraméterben megkapott {@code AntHill} objektumon hívja meg a szükséges metódusokat.
	 * 
	 * @param antHill
	 * @return Lehetséges e erre a mezõre lépni.
	 */
	public boolean visit(AntHill antHill);

}