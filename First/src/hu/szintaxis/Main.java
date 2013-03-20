package hu.szintaxis;

import System.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GameField gameField = new GameField();
		Field field = new Field(gameField);
		AntHill antHill = new AntHill(field);
		
		
		field.addElement(antHill);
		gameField.addField(field);
		antHill.update();
		
	}

}
