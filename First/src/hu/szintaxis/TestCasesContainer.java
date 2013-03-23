package hu.szintaxis;

import System.AntHill;
import System.Field;
import System.Game;
import System.GameField;

public class TestCasesContainer {
	
	@Description(orderNumber = 0, description = "Kilépés")
	public void exit() {
		System.out.println("A program befejezte futását!");
		System.exit(0);
	}
	
	@Description(orderNumber = 1, description = "Hangya létrehozása")
	public void AntCreationTest() {
		GameField gameField = new GameField();
		Field field = new Field(gameField);
		AntHill antHill = new AntHill(field);
		
		
		field.addElement(antHill);
		gameField.addField(field);
		antHill.update();
	}
	
	@Description(orderNumber = 2, description = "Játék inicializálása")
	public void InitializeTest() {
		Game game = new Game();
		game.newGame();
	}
}
