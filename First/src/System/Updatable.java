package System;

/**
 * Az interfész frissítési szolgáltatást nyújt a megvalósítandó osztályoknak. 
 * Ezt az interfészt implementáló osztályokat a {@code GameField} beregisztrálja frissítendõ objektumonként.
 */
public interface Updatable {

	/**
	 * A {@code GameField} hívja meg ezt az interfészt megvalósító osztályok metódusát, ha frissíteni kell és a függvény az objektumra specifikus frissítési folyamatot elvégzi.
	 */
	public void update();

}