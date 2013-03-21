package hu.szintaxis;


/*
 * Tracer osztály a szkeletonhoz a metódusok követésére.
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
		//Kilépésnél a mélységet azelõtt kell csökkenteni, hogy számolnánk vele.
		if (direction == Direction.Leave)
			depth--;
		
		//Kiszámolja a behúzást.
		for (int i = 0; i < depth; i++) {
			sBuilder.append("\t");
		}
		
		if (direction == Direction.Enter)
			depth++;
		
		//Irányt hozzáfûzi a stringhez.
		switch (direction) {
		case Enter:
			sBuilder.append(">>> | ");
			break;
		case Leave:
			sBuilder.append("<<< | ");
			break;
		}
		
		//osztály és metódus név stringhez fûzése 
		//(a stackben a 0. elem a getStackTrace, az 1. a Print, és a 2. az aktuális metódus ami érdekel minket)
		String className = stack[2].getFileName();
		className = className.substring(0, className.length()-5);
		sBuilder.append(className);
		sBuilder.append(".");
		sBuilder.append(stack[2].getMethodName());
		
		//Esetleges argumentumok kiírása
		if (direction == Direction.Enter) {
			sBuilder.append("(");
			for (Object object : arguments) {
				sBuilder.append(object.toString());
			}
			sBuilder.append(")");
		}
		
		//Esetleges visszatérési érték kiírása
		if (direction == Direction.Leave && arguments.length == 1) {
			sBuilder.append(":");
			sBuilder.append(arguments[0].toString());
		}
		
		//Elkészült string írása.
		System.out.println(sBuilder.toString());
	}
}
