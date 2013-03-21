package game.wireTest;

import java.lang.invoke.MethodHandle;

import sun.reflect.misc.MethodUtil;

import com.sun.org.apache.regexp.internal.recompile;

/*
 * Tracer oszt�ly a szkeletonhoz a met�dusok k�vet�s�re.
 */
public class Tracer {

	public enum Direction {
		Enter,
		Leave
	}
	private static Tracer instance;
	private int depth = 0;
	
	public static Tracer Instance(){
		if(instance == null)
			instance = new Tracer();
		return instance;
	}
	
	public void Trace(Direction direction, Object... arguments){
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		StringBuilder sBuilder = new StringBuilder();
		//Kil�p�sn�l a m�lys�get azel�tt kell cs�kkenteni, hogy sz�moln�nk vele.
		if (direction == Direction.Leave)
			depth--;
		
		//Kisz�molja a beh�z�st.
		for (int i = 0; i < depth; i++) {
			sBuilder.append("\t");
		}
		
		if (direction == Direction.Enter)
			depth++;
		
		//Ir�nyt hozz�f�zi a stringhez.
		switch (direction) {
		case Enter:
			sBuilder.append(">>> | ");
			break;
		case Leave:
			sBuilder.append("<<< | ");
			break;
		}
		
		//oszt�ly �s met�dus n�v stringhez f�z�se 
		//(a stackben a 0. elem a getStackTrace, az 1. a Print, �s a 2. az aktu�lis met�dus ami �rdekel minket)
		String className = stack[2].getFileName();
		className = className.substring(0, className.length()-5);
		sBuilder.append(className);
		sBuilder.append(".");
		sBuilder.append(stack[2].getMethodName());
		
		//Esetleges argumentumok ki�r�sa
		if (direction == Direction.Enter) {
			sBuilder.append("(");
			for (Object object : arguments) {
				sBuilder.append(object.toString());
			}
			sBuilder.append(")");
		}
		
		//Esetleges visszat�r�si �rt�k ki�r�sa
		if (direction == Direction.Leave && arguments.length == 1) {
			sBuilder.append(":");
			sBuilder.append(arguments[0].toString());
		}
		
		//Elk�sz�lt string �r�sa.
		System.out.println(sBuilder.toString());
	}
}
