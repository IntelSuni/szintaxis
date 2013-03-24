package hu.szintaxis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Skeleton {

	private Map<Integer, MethodDescriptor> testCasesMap;
	private TestCasesContainer testCases;
	
	/**
	 * Inicializálja a skeletont.
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
					System.err.println("Hiba: A Description annotációban megadott sorszám már létezik a következõ tesztesetnél: " + description.description());
					System.err.println("Helyette a sorszám a következõ lett: " + key);
				} else {
					key = description.orderNumber();
				}
				testCasesMap.put(key, methodDescriptor);
			}
		}
	}

	/**
	 * Elindítja a {@code testCase}-ben megadott számú tesztet.
	 * @param testCase Az elindítandó teszteset sorszáma.
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
				System.out.println("Teszt befejezõdött!");
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
			System.out.println("Hiba: A teszteset nem létezik!");
			System.out.println();
		}
	}
	
	/**
	 * Kiírja az összes regisztrált tesztesetet.
	 */
	public void printTests() {
		for(Integer key : testCasesMap.keySet()) {
			System.out.println(key+ ".) " + testCasesMap.get(key).description);
		}
	}
	
	/**
	 * Segéd osztály a mapben a metódus tárolásához.
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
