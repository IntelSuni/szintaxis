package System;

import java.util.ArrayList;

/**
 * ev�s: n�veli a megevett sz�ml�l�t, ha el�ri a 3-at, nem eszik t�bbet.
 * Hangy�sz
 * @author gbeatrix
 * @version 1.0
 * @created 20-m�rc.-2013 10:42:46
 */
public class Anteater implements Updatable, Element, Visitor {

	private Field currentField;
	private int eatenAnts;

	public Anteater(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param visiting
	 */
	public void accept(Visitor visiting){

	}

	/**
	 * 
	 * @param fields
	 */
	public Field decideDirection(ArrayList<Field> fields){
		return null;
	}

	public void eat(){

	}

	public void onDraw(){

	}

	/**
	 * 
	 * @param field
	 */
	public void setField(Field field){

	}

	public void update(){

	}

	/**
	 * 
	 * @param antlion
	 */
	public void visit(Antlion antlion){

	}

	/**
	 * 
	 * @param ant
	 */
	public void visit(Ant ant){

	}

	/**
	 * 
	 * @param akadaly
	 */
	public void visit(Block akadaly){

	}

	/**
	 * 
	 * @param foodstore
	 */
	public void visit(FoodStore foodstore){

	}

	/**
	 * 
	 * @param anteater
	 */
	public void visit(Anteater anteater){

	}

}