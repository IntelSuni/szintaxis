package hu.szintaxis.skeleton;

import System.Ant;
import System.AntHill;
import System.Anteater;
import System.Antlion;
import System.Field;
import System.Game;
import System.FoodStore;
import System.GameField;
import System.Weapon;
import System.ExterminatorSmell;

/**
 * Valóságos use-case-eket megvalósító függvényeket összefogó osztály.
 */
public class TestCasesContainer {

	@Description(orderNumber = 0, description = "Kilépés")
	public void exit() {
		System.out.println("A program befejezte futását!");
		System.exit(0);
	}

	@Description(orderNumber = 1, description = "5.3.1. szekvencia diagram: Hangya létrehozása")
	public void AntCreationTest() {
		GameField gameField = new GameField();
		Field field = new Field(gameField);
		AntHill antHill = new AntHill(field);

		field.addElement(antHill);
		gameField.addField(field);
		antHill.update();
	}

	@Description(orderNumber = 2, description = "5.3.2. szekvencia diagram: Játék inicializálása")
	public void InitializeTest() {
		Game game = new Game();
		game.newGame();
	}

	@Description(orderNumber = 3, description = "5.3.5. szekvencia diagram: Hangya eléri ételraktárat")
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

	@Description(orderNumber = 4, description = "5.3.3. szekvencia diagram: Decide direction mûködése")
	public void DecideDirTest() {
		GameField gameField = new GameField();
		Field field = new Field(gameField);
		Field field2 = new Field(gameField);
		Ant h1 = new Ant(field);
		field.addNeighbour(field2);
		h1.decideDirection(field.getNeighbours());

	}
	
	@Description(orderNumber = 5, description = "5.3.9. szekvencia diagram: Hangyász hangya nélküli mezõre lép")
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
	
	@Description(orderNumber = 6, description = "5.3.10. szekvencia diagram: Hangyász hangyára lép")
	public void AntEaterAntFieldTest() {
		GameField gameField = new GameField();
		Field m1 = new Field(gameField);
		Field current = new Field(gameField);
		Ant h1 = new Ant(m1);
		Anteater aeater = new Anteater();
		
		aeater.setField(current);	//AntEater current Fielden van
		current.addNeighbour(m1);	//current Fieldnek van 1db szomszédja (m1)
		gameField.registerNewUpdatable(h1);	//Ant van a pályán
		
		aeater.update();	//AntEater lép
	}
	
	@Description(orderNumber=7, description = "5.3.4. szekvencia diagram: Hangya hangyára lép")
	public void AnttoAntTest() {
		GameField gameField = new GameField();
		Field m1 = new Field(gameField);
		Field current = new Field(gameField);
		Ant h1 = new Ant(current);
		Ant h2 = new Ant(m1);
		
		gameField.registerNewUpdatable(h1);	//hangya 1 
		gameField.registerNewUpdatable(h2);	//hangya 2
		current.addNeighbour(m1);	//current-nek 1db szomszédja van
		h1.update();
	}
	
	@Description(orderNumber = 8, description = "5.3.6. szekvencia diagram: Hangya hangyalesõre lép")
	public void AntMovesToAntlionTest(){
		GameField p = new GameField();
		Field current = new Field(p); // aktuális Field a GameField-en
		Field m1 = new Field(p); // másik Field a GameField-en
		Antlion antlion = new Antlion();
		Ant a1 = new Ant(current); //hangya az aktuális Field-en
		
		current.addNeighbour(m1); //aktuális Field szomszédja a másik mezõ
		m1.addElement(antlion); // a másik mezõn egy Antlion van
		antlion.setField(m1); // az Antlion a másik mezõn van
		
		a1.update();
	}
	
	@Description(orderNumber = 9, description = "5.3.11. szekvencia diagram: Spray fújás")
	public void SprayUsageTest(){
		GameField gameField = new GameField();
		Field m1 = new Field(gameField); // aktuális Field a GameField-ne
		Field neighbour = new Field(gameField); // másik mezõ a GameField-en
		m1.addNeighbour(neighbour); //az aktuális mezõ szomszédja a másik mezõ
		
		Weapon.InstanceOf().Use(m1); // fegyver használata a mezõn
	}

	@Description(orderNumber = 10, description = "5.3.7. szekvencia diagram: Hangya hangyászra lép")
	public void AntMovesToAnteaterTest(){
		GameField p = new GameField();
		Field current = new Field(p); // aktuális Field a GameField-en
		Field m1 = new Field(p); // másik Field a GameField-en
		Anteater anteater = new Anteater();
		Ant h1 = new Ant(current); //hangya az aktuális Field-en
		
		current.addNeighbour(m1); //aktuális mezõ szomszédja a másik mezõ
		m1.addElement(anteater); // a másik mezõn egy hangyász van
		anteater.setField(m1); // a hangyász a másik mezõn van
		
		h1.update(); // a hangya lép
	}

	@Description(orderNumber = 11, description = "5.3.8. szekvencia diagram: Hangya mérgezett mezõre lép")
	public void AntMovesToPoisonedFieldTest(){
		GameField p = new GameField();
		Field currentField = new Field(p); // aktuális Field a GameField-en
		Field f1 = new Field(p); // másik Field a GameField-en
		ExterminatorSmell smell = new ExterminatorSmell(f1); // méreg
		Ant h1 = new Ant(currentField); //hangya az aktuális Field-en
		
		currentField.addNeighbour(f1); //aktuális mezõ szomszédja a másik mezõ
		f1.addSmell(smell); // a másik mezõn méreg van
		
		h1.update(); // a hangya lép
	}
}