package System;

/**
 * Visitor inter�sz.
 * A Visitor tervez�si minta megval�s�t�s�ra szolg�l� olyan interf�z,
 * amely tartalmazza a Element interf�szt megval�s�t� oszt�lyok visit f�ggv�nyeit.
 */
public interface Visitor {

	/**
	 * A param�terben megkapott {@code Anteater} objektumon h�vja meg a sz�ks�ges met�dusokat.
	 * 
	 * @param anteater
	 * @return Lehets�ges e erre a mez�re l�pni.
	 */
	public boolean visit(Anteater anteater);

	/**
	 * A param�terben megkapott {@code FoodStore} objektumon h�vja meg a sz�ks�ges met�dusokat.
	 * 
	 * @param foodstore
	 * @return Lehets�ges e erre a mez�re l�pni.
	 */
	public boolean visit(FoodStore foodstore);

	/**
	 * A param�terben megkapott {@code Antlion antlion} objektumon h�vja meg a sz�ks�ges met�dusokat.
	 * 
	 * @param antlion
	 * @return Lehets�ges e erre a mez�re l�pni.
	 */
	public boolean visit(Antlion antlion);

	/**
	 * A param�terben megkapott {@code Ant} objektumon h�vja meg a sz�ks�ges met�dusokat.
	 * 
	 * @param ant
	 * @return Lehets�ges e erre a mez�re l�pni.
	 */
	public boolean visit(Ant ant);

	/**
	 * A param�terben megkapott {@code Block} objektumon h�vja meg a sz�ks�ges met�dusokat.
	 * 
	 * @param block
	 * @return Lehets�ges e erre a mez�re l�pni.
	 */
	public boolean visit(Block block);
	
	/**
	 * A param�terben megkapott {@code Stone} objektumon h�vja meg a sz�ks�ges met�dusokat.
	 * 
	 * @param stone
	 * @return Lehets�ges e erre a mez�re l�pni.
	 */
	public boolean visit(Stone stone);

	/**
	 * A param�terben megkapott {@code AntHill} objektumon h�vja meg a sz�ks�ges met�dusokat.
	 * 
	 * @param antHill
	 * @return Lehets�ges e erre a mez�re l�pni.
	 */
	public boolean visit(AntHill antHill);

}