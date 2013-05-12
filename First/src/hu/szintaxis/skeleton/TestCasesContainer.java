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
 * Val�s�gos use-case-eket megval�s�t� f�ggv�nyeket �sszefog� oszt�ly.
 */
public class TestCasesContainer {

	@Description(orderNumber = 0, description = "Kil�p�s")
	public void exit() {
		System.out.println("A program befejezte fut�s�t!");
		System.exit(0);
	}

	@Description(orderNumber = 1, description = "5.3.1. szekvencia diagram: Hangya l�trehoz�sa")
	public void AntCreationTest() {
		GameField gameField = new GameField();
		Field field = new Field(gameField);
		AntHill antHill = new AntHill(field);

		field.addElement(antHill);
		gameField.addField(field);
		antHill.update();
	}

	@Description(orderNumber = 2, description = "5.3.2. szekvencia diagram: J�t�k inicializ�l�sa")
	public void InitializeTest() {
		Game game = new Game();
		game.newGame();
	}

	@Description(orderNumber = 3, description = "5.3.5. szekvencia diagram: Hangya el�ri �telrakt�rat")
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

	@Description(orderNumber = 4, description = "5.3.3. szekvencia diagram: Decide direction m�k�d�se")
	public void DecideDirTest() {
		GameField gameField = new GameField();
		Field field = new Field(gameField);
		Field field2 = new Field(gameField);
		Ant h1 = new Ant(field);
		field.addNeighbour(field2);
		h1.decideDirection(field.getNeighbours());

	}
	
	@Description(orderNumber = 5, description = "5.3.9. szekvencia diagram: Hangy�sz hangya n�lk�li mez�re l�p")
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
	
	@Description(orderNumber = 6, description = "5.3.10. szekvencia diagram: Hangy�sz hangy�ra l�p")
	public void AntEaterAntFieldTest() {
		GameField gameField = new GameField();
		Field m1 = new Field(gameField);
		Field current = new Field(gameField);
		Ant h1 = new Ant(m1);
		Anteater aeater = new Anteater();
		
		aeater.setField(current);	//AntEater current Fielden van
		current.addNeighbour(m1);	//current Fieldnek van 1db szomsz�dja (m1)
		gameField.registerNewUpdatable(h1);	//Ant van a p�ly�n
		
		aeater.update();	//AntEater l�p
	}
	
	@Description(orderNumber=7, description = "5.3.4. szekvencia diagram: Hangya hangy�ra l�p")
	public void AnttoAntTest() {
		GameField gameField = new GameField();
		Field m1 = new Field(gameField);
		Field current = new Field(gameField);
		Ant h1 = new Ant(current);
		Ant h2 = new Ant(m1);
		
		gameField.registerNewUpdatable(h1);	//hangya 1 
		gameField.registerNewUpdatable(h2);	//hangya 2
		current.addNeighbour(m1);	//current-nek 1db szomsz�dja van
		h1.update();
	}
	
	@Description(orderNumber = 8, description = "5.3.6. szekvencia diagram: Hangya hangyales�re l�p")
	public void AntMovesToAntlionTest(){
		GameField p = new GameField();
		Field current = new Field(p); // aktu�lis Field a GameField-en
		Field m1 = new Field(p); // m�sik Field a GameField-en
		Antlion antlion = new Antlion();
		Ant a1 = new Ant(current); //hangya az aktu�lis Field-en
		
		current.addNeighbour(m1); //aktu�lis Field szomsz�dja a m�sik mez�
		m1.addElement(antlion); // a m�sik mez�n egy Antlion van
		antlion.setField(m1); // az Antlion a m�sik mez�n van
		
		a1.update();
	}
	
	@Description(orderNumber = 9, description = "5.3.11. szekvencia diagram: Spray f�j�s")
	public void SprayUsageTest(){
		GameField gameField = new GameField();
		Field m1 = new Field(gameField); // aktu�lis Field a GameField-ne
		Field neighbour = new Field(gameField); // m�sik mez� a GameField-en
		m1.addNeighbour(neighbour); //az aktu�lis mez� szomsz�dja a m�sik mez�
		
		Weapon.InstanceOf().Use(m1); // fegyver haszn�lata a mez�n
	}

	@Description(orderNumber = 10, description = "5.3.7. szekvencia diagram: Hangya hangy�szra l�p")
	public void AntMovesToAnteaterTest(){
		GameField p = new GameField();
		Field current = new Field(p); // aktu�lis Field a GameField-en
		Field m1 = new Field(p); // m�sik Field a GameField-en
		Anteater anteater = new Anteater();
		Ant h1 = new Ant(current); //hangya az aktu�lis Field-en
		
		current.addNeighbour(m1); //aktu�lis mez� szomsz�dja a m�sik mez�
		m1.addElement(anteater); // a m�sik mez�n egy hangy�sz van
		anteater.setField(m1); // a hangy�sz a m�sik mez�n van
		
		h1.update(); // a hangya l�p
	}

	@Description(orderNumber = 11, description = "5.3.8. szekvencia diagram: Hangya m�rgezett mez�re l�p")
	public void AntMovesToPoisonedFieldTest(){
		GameField p = new GameField();
		Field currentField = new Field(p); // aktu�lis Field a GameField-en
		Field f1 = new Field(p); // m�sik Field a GameField-en
		ExterminatorSmell smell = new ExterminatorSmell(f1); // m�reg
		Ant h1 = new Ant(currentField); //hangya az aktu�lis Field-en
		
		currentField.addNeighbour(f1); //aktu�lis mez� szomsz�dja a m�sik mez�
		f1.addSmell(smell); // a m�sik mez�n m�reg van
		
		h1.update(); // a hangya l�p
	}
}