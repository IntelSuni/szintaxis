/**
 * 
 */
package System;

/**
 * @author Martin
 *
 */
public class Stone extends Block {

	/**
	 * A kavics ezen a mez�n van.
	 */
	private Field currentField;
	
	/* (non-Javadoc)
	 * @see System.Block#accept(System.Visitor)
	 */
	@Override
	public boolean accept(Visitor visitor) {
		return visitor.visit(this);
	}
	
	boolean moving (Direction direction){
		
		return false;
	}
	
}
