package hu.szintaxis.skeleton;


/**
 * Tracer oszt�ly a szkeletonhoz a met�dusok k�vet�s�re.
 */
public class Tracer {
	//nyuszi
	// N�v�tk�z�s miatt, TracerDirection lett.
	public enum TracerDirection {
		Enter,
		Leave
	}
	private static Tracer instance;
	private int depth = 0;
	
	/**
	 * Singleton p�ld�ny lek�rdez�.
	 * @return A Tracer egy p�ld�nya.
	 */
	public static Tracer Instance(){
		if(instance == null)
			instance = new Tracer();
		return instance;
	}
	
	/**
	 * K�veti az ezt megh�v� met�dus fut�s�t.
	 * @param direction Be vagy kil�p�si pontja a met�dusnak.
	 * @param arguments Met�dus argumentumai/visszat�r�si �rt�ke.
	 */
	public void Trace(TracerDirection direction, Object... arguments){
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		StringBuilder sBuilder = new StringBuilder();
		//Kil�p�sn�l a m�lys�get azel�tt kell cs�kkenteni, hogy sz�moln�nk vele.
		if (direction == TracerDirection.Leave)
			depth--;
		
		//Kisz�molja a beh�z�st.
		for (int i = 0; i < depth; i++) {
			sBuilder.append("\t");
		}
		
		if (direction == TracerDirection.Enter)
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
		
		//Esetleges visszat�r�si �rt�k ki�r�sa
		if (direction == TracerDirection.Leave && arguments.length == 1) {
			sBuilder.append(":");
			if(arguments[0] != null) {
				sBuilder.append(arguments[0].toString());
			}
		}
		
		//Elk�sz�lt string �r�sa.
		System.out.println(sBuilder.toString());
	}
}
