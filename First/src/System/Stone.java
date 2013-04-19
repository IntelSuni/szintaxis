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
	 * A kavics ezen a mezõn van.
	 */
	private Field currentField;
	
	/* (non-Javadoc)
	 * @see System.Block#accept(System.Visitor)
	 */
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
	
	boolean moving (Direction direction){
		
		return false;
	}
	
}
