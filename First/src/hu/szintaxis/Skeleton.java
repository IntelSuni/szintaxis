package hu.szintaxis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Skeleton {

	private Map<Integer, MethodDescriptor> testCasesMap;
	private TestCasesContainer testCases;
	
	/**
	 * Inicializ�lja a skeletont.
	 */
	public Skeleton() {
		testCasesMap = new HashMap<Integer, MethodDescriptor>();
		testCases = new TestCasesContainer();
		
		for(Method method : testCases.getClass().getMethods()) {
			if (method.isAnnotationPresent(Description.class)) {
				Description description = method.getAnnotation(Description.class);
				MethodDescriptor methodDescriptor = new MethodDescriptor(method, description.description());
				Integer key;
				if(testCasesMap.containsKey(description.orderNumber())){
					key = testCasesMap.size()+1;
					System.err.println("Hiba: A Description annot�ci�ban megadott sorsz�m m�r l�tezik a k�vetkez� tesztesetn�l: " + description.description());
					System.err.println("Helyette a sorsz�m a k�vetkez� lett: " + key);
				} else {
					key = description.orderNumber();
				}
				testCasesMap.put(key, methodDescriptor);
			}
		}
	}

	/**
	 * Elind�tja a {@code testCase}-ben megadott sz�m� tesztet.
	 * @param testCase Az elind�tand� teszteset sorsz�ma.
	 */
	public void startTest(int testCase) {
		MethodDescriptor test = testCasesMap.get(testCase);
		if (test != null) {
			try {
				
				System.out.println();
				if(testCase != 0) {
					System.out.println("Teszt kezdete: " + test.description);
				}
				test.method.invoke(testCases);
				System.out.println("Teszt befejez�d�tt!");
				System.out.println();
			} catch (IllegalAccessException e1){
				e1.printStackTrace();
			}
			catch (IllegalArgumentException e2){
				e2.printStackTrace();
			}
			catch (InvocationTargetException e3) {
				e3.printStackTrace();
			}
		} else {
			System.out.println();
			System.out.println("Hiba: A teszteset nem l�tezik!");
			System.out.println();
		}
	}
	
	/**
	 * Ki�rja az �sszes regisztr�lt tesztesetet.
	 */
	public void printTests() {
		for(Integer key : testCasesMap.keySet()) {
			System.out.println(key+ ".) " + testCasesMap.get(key).description);
		}
	}
	
	/**
	 * Seg�d oszt�ly a mapben a met�dus t�rol�s�hoz.
	 */
	private class MethodDescriptor {
		private Method method;
		private String description;
		
		public MethodDescriptor(Method _method, String _description) {
			method = _method;
			description = _description;
		}
	}
}
