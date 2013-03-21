package System;

/**
 * VisitableElement
 * 
 * @author gbeatrix
 * @version 1.0
 * @created 20-márc.-2013 10:42:47
 */
public interface Element {

	/**
	 * 
	 * @param visitor
	 */
	public void accept(Visitor visitor);

	public abstract void onDraw();

}