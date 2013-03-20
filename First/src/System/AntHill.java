package System;

/**
 * HangyaBoly
 * @author gbeatrix
 * @version 1.0
 * @created 20-márc.-2013 10:42:46
 */
public class AntHill implements Updatable, Element {

	private Field field;

	public AntHill(){
		super();
		System.out.println(getClass().getName() + " created.");
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param field
	 */
	public AntHill(Field field){
		this.field = field;
		System.out.println(getClass().getName() + " created to " + field.getClass().getName() + " field.");
	}

	/**
	 * 
	 * @param visitor
	 */
	public void accept(Visitor visitor){

	}

	public void onDraw(){

	}

	public void update(){

		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println(getClass().getName() + " " + ste[ste.length - 1 - 1].getMethodName() + "() method called.");
		
		Ant ant = new Ant();
		AntSmell antSmell = new AntSmell();
		
		field.addElement(ant);
		field.addSmell(antSmell);
		
		this.field.gameField.registerNewUpdatable(ant);
		
	}

}