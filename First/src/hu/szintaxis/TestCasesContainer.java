package hu.szintaxis;

import System.AntHill;
import System.Field;
import System.Game;
import System.GameField;

public class TestCasesContainer {
	
	@Description(orderNumber = 0, description = "Kil�p�s")
	public void exit() {
		System.out.println("A program befejezte fut�s�t!");
		System.exit(0);
	}
	
	@Description(orderNumber = 1, description = "Hangya l�trehoz�sa")
	public void AntCreationTest() {
		GameField gameField = new GameField();
		Field field = new Field(gameField);
		AntHill antHill = new AntHill(field);
		
		
		field.addElement(antHill);
		gameField.addField(field);
		antHill.update();
	}
	
	@Description(orderNumber = 2, description = "J�t�k inicializ�l�sa")
	public void InitializeTest() {
		Game game = new Game();
		game.newGame();
	}
}
