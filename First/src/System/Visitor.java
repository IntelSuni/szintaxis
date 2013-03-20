package System;

/**
 * a visitElement(Visitabel) metódust kivettem, hiszen a a konkrét metódusokat
 * beletettük
 * @author Vartrass
 * @version 1.0
 * @created 20-márc.-2013 10:42:48
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