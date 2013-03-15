package System;

/**
 * Pálya
 * @author gbeatrix
 * @version 1.0
 * @created 15-márc.-2013 11:58:20
 */
public class GameField {

	private int anteaterNo;
	private int antHillNo;
	private int blockNo;
	private int foodStoreNo;
	private static GameField instance;
	private Point size;
	private ArrayList<Updatable> toUpdate;
	public Field m_Field;
	public Updatable m_Updatable;
	public Game m_Game;



	public void finalize() throws Throwable {

	}

	private GameField(){

	}

	/**
	 * 
	 * @param element
	 * @param field
	 */
	public void addElementToField(Element element, Field field){

	}

	/**
	 * 
	 * @param f
	 */
	public void addField(Field f){

	}

	/**
	 * 
	 * @param points
	 */
	public Field getField(Point points){
		return null;
	}

	public void Initialize(){

	}

	public static GameField instanceOf(){
		return null;
	}

	/**
	 * 
	 * @param element
	 */
	public void registerNewUpdatable(Updatable element){

	}

	public void updateUpdatables(){

	}

}