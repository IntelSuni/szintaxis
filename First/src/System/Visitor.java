package System;

/**
 * Visitor interf�sz.
 * A Visitor tervez�si minta megval�s�t�s�ra szolg�l� olyan interf�sz,
 * amely tartalmazza a Element interf�szt megval�s�t� oszt�lyok visit f�ggv�nyeit.
 */
public interface Visitor {

	/**
	 * A param�terben megkapott {@code Anteater} objektumon h�vja meg sz�ks�ges met�dusokat.
	 * 
	 * @param anteater
	 */
	public void visit(Anteater anteater);

	/**
	 * A param�terben megkapott {@code FoodStore} objektumon h�vja meg sz�ks�ges met�dusokat.
	 * 
	 * @param foodstore
	 */
	public void visit(FoodStore foodstore);

	/**
	 *A param�terben megkapott {@code Antlion} objektumon h�vja meg sz�ks�ges met�dusokat.
	 * 
	 * @param antlion
	 */
	public void visit(Antlion antlion);

	/**
	 * A param�terben megkapott {@code Ant} objektumon h�vja meg sz�ks�ges met�dusokat. 
	 * @param ant
	 */
	public void visit(Ant ant);

	/**
	 * A param�terben megkapott {@code Block} objektumon h�vja meg sz�ks�ges met�dusokat.
	 * 
	 * @param akadaly
	 */
	public void visit(Block akadaly);

}