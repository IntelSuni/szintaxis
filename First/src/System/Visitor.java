package System;

/**
 * a visitElement(Visitabel) met�dust kivettem, hiszen a a konkr�t met�dusokat
 * beletett�k
 * @author Vartrass
 * @version 1.0
 * @created 20-m�rc.-2013 10:42:48
 */
public interface Visitor {

	/**
	 * 
	 * @param anteater
	 */
	public void visit(Anteater anteater);

	/**
	 * 
	 * @param foodstore
	 */
	public void visit(FoodStore foodstore);

	/**
	 * 
	 * @param antlion
	 */
	public void visit(Antlion antlion);

	/**
	 * 
	 * @param ant
	 */
	public void visit(Ant ant);

	/**
	 * 
	 * @param akadaly
	 */
	public void visit(Block akadaly);

}