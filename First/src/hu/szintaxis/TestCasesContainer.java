package hu.szintaxis;

import System.AntHill;
import System.Field;
import System.GameField;

public class TestCasesContainer {
	
	@Description(orderNumber = 0, description = "Kilépés")
	public void exit() {
		System.out.println("A program befejezte futását!");
		System.exit(0);
	}
	
	@Description(orderNumber = 1, description = "Hangyaboly létrehozása")
	public void testTestCase1() {
		GameField gameField = new GameField();
		Field field = new Field(gameField);
		AntHill antHill = new AntHill(field);
		
		
		field.addElement(antHill);
		gameField.addField(field);
		antHill.update();
	}
}
