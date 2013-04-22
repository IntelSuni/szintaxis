package hu.szintaxis.skeleton;


/**
 * Tracer osztály a szkeletonhoz a metódusok követésére.
 */
public class Tracer {
	//nyuszi
	// Névütközés miatt, TracerDirection lett.
	public enum TracerDirection {
		Enter,
		Leave
	}
	private static Tracer instance;
	private int depth = 0;
	
	/**
	 * Singleton példány lekérdezõ.
	 * @return A Tracer egy példánya.
	 */
	public static Tracer Instance(){
		if(instance == null)
			instance = new Tracer();
		return instance;
	}
	
	/**
	 * Követi az ezt meghívó metódus futását.
	 * @param direction Be vagy kilépési pontja a metódusnak.
	 * @param arguments Metódus argumentumai/visszatérési értéke.
	 */
	public void Trace(TracerDirection direction, Object... arguments){
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		StringBuilder sBuilder = new StringBuilder();
		//Kilépésnél a mélységet azelõtt kell csökkenteni, hogy számolnánk vele.
		if (direction == TracerDirection.Leave)
			depth--;
		
		//Kiszámolja a behúzást.
		for (int i = 0; i < depth; i++) {
			sBuilder.append("\t");
		}
		
		if (direction == TracerDirection.Enter)
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
		if (direction == TracerDirection.Enter) {
			sBuilder.append("(");
			for (int i = 0; i < arguments.length; i++) {
				sBuilder.append(arguments[i].toString());
				if(i != arguments.length - 1) {
					sBuilder.append(',');
				}
			}
			sBuilder.append(")");
		}
		
		//Esetleges visszatérési érték kiírása
		if (direction == TracerDirection.Leave && arguments.length == 1) {
			sBuilder.append(":");
			if(arguments[0] != null) {
				sBuilder.append(arguments[0].toString());
			}
		}
		
		//Elkészült string írása.
		System.out.println(sBuilder.toString());
	}
}
