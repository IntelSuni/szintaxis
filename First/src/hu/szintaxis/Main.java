package hu.szintaxis;

import hu.szintaxis.Tracer.Direction;
import System.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tracer.Instance().Trace(Direction.Enter, args);

		GameField gameField = new GameField();
		Field field = new Field(gameField);
		AntHill antHill = new AntHill(field);
		
		
		field.addElement(antHill);
		gameField.addField(field);
		antHill.update();
		
		Tracer.Instance().Trace(Direction.Leave);
	}

}
