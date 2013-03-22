package hu.szintaxis;

import System.AntHill;
import System.Field;
import System.GameField;

public class TestCasesContainer {
	
	@Description(orderNumber = 0, description = "Kil�p�s")
	public void exit() {
		System.out.println("A program befejezte fut�s�t!");
		System.exit(0);
	}
	
	@Description(orderNumber = 1, description = "Hangyaboly l�trehoz�sa")
	public void testTestCase1() {
		GameField gameField = new GameField();
		Field field = new Field(gameField);
		AntHill antHill = new AntHill(field);
		
		
		field.addElement(antHill);
		gameField.addField(field);
		antHill.update();
	}
}
