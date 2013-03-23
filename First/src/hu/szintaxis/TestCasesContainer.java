package hu.szintaxis;

import System.Ant;
import System.AntHill;
import System.Anteater;
import System.Field;
import System.Game;
import System.FoodStore;
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

	@Description(orderNumber = 3, description = "Hangya el�ri �telrakt�rat.")
	public void AntFoodStoreTest() {
		GameField gameField = new GameField();
		Field field = new Field(gameField);
		Field field2 = new Field(gameField);
		field.addNeighbour(field2);
		Ant h1 = new Ant(field);
		field.addElement(h1);
		field2.addElement(new FoodStore(field2));

		gameField.registerNewUpdatable(h1);
		h1.update();
	}

	@Description(orderNumber = 4, description = "Decide direction m�k�d�se")
	public void DecideDirTest() {
		GameField gameField = new GameField();
		Field field = new Field(gameField);
		Field field2 = new Field(gameField);
		Ant h1 = new Ant(field);
		field.addNeighbour(field2);
		h1.decideDirection(field.getNeighbours());

	}
	
	@Description(orderNumber = 5, description = "Hangy�sz hangya n�lk�li mez�re l�p")
	public void AnteaterEmptyFieldTest() {
		GameField gameField = new GameField();
		Field field = new Field(gameField);
		Field field2 = new Field(gameField);
		field.addNeighbour(field2);
		Anteater anteater = new Anteater();
		field.addElement(anteater);
		anteater.setField(field);
		
		anteater.update();
	}
}
