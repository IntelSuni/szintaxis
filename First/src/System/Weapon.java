package System;

import java.awt.Point;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

/**
 * @author Dóczi Róbert
 * @version 1.0
 * @created 20-márc.-2013 10:42:48
 */
public class Weapon {

	private static Weapon Instance;
	public Spray m_Spray;

	public void finalize() throws Throwable {
		super.finalize();
	}

	
	private  Weapon() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	public static Weapon InstanceOf() {
		Tracer.Instance().Trace(Direction.Enter);
		
		if(Instance==null)Instance=new Weapon();
		Tracer.Instance().Trace(Direction.Leave);
		return  Instance;
	}

	/**
	 * 
	 * @param field
	 */
	public void Use(Field field) {
		Tracer.Instance().Trace(Direction.Enter,field);
		
		GameField.instanceOf().getField(new Point());
		Spray current = new Spray();
		current.use(field);
		
		Tracer.Instance().Trace(Direction.Leave);
	}

}