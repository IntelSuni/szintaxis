package System;

/**
 * kivettem a kill() metódust, hiszen õ hívja meg a hangyán, nem pedig rajta !
 * @author gbeatrix
 * @version 1.0
 * @created 20-márc.-2013 10:42:47
 */
public class FoodStore implements Element {

	private int food;

	public FoodStore(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param visitor
	 */
	public void accept(Visitor visitor){

	}

	public void eat(){

	}

	public int getFoodLeft(){
		return 0;
	}

	public void kill(){

	}

	public void onDraw(){

	}

}