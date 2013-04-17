package hu.szintaxis.skeleton;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Skeleton {

	/**
	 * Tárolt tesztesetek
	 */
	private Map<Integer, MethodDescriptor> testCasesMap;
	/**
	 * Teszteket tartalmazó osztály
	 */
	private TestCasesContainer testCases;

	/**
	 * Inicializálja a skeletont.
	 */
	public Skeleton() {
		testCasesMap = new HashMap<Integer, MethodDescriptor>();
		testCases = new TestCasesContainer();

		// Tesztesetek beolvasása, annotációk értelmezése.
		for (Method method : testCases.getClass().getMethods()) {
			if (method.isAnnotationPresent(Description.class)) {
				Description description = method
						.getAnnotation(Description.class);
				MethodDescriptor methodDescriptor = new MethodDescriptor(
						method, description.description());
				Integer key;
				// ha létezik a megadott sorszám akkor újat generál
				if (testCasesMap.containsKey(description.orderNumber())) {
					key = testCasesMap.size() + 1;
					System.err
							.println("Hiba: A Description annotációban megadott "
									+ "sorszám már létezik a következõ tesztesetnél: "
									+ description.description());
					System.err.println("Helyette a sorszám a következõ lett: "
							+ key);
				} else {
					key = description.orderNumber();
				}
				testCasesMap.put(key, methodDescriptor);
			}
		}
	}

	/**
	 * Elindítja a {@code testCase}-ben megadott számú tesztet.
	 * 
	 * @param testCase
	 *            Az elindítandó teszteset sorszáma.
	 */
	public void startTest(int testCase) {
		MethodDescriptor test = testCasesMap.get(testCase);
		// Ha a teszteset létezik, akkor teszt indulásának jelzése, teszt
		// indítása, befejezés jelzése.
		if (test != null) {
			try {
				System.out.println();
				if (testCase != 0) {
					System.out.println("Teszt kezdete: " + test.description);
				}
				test.method.invoke(testCases);
				System.out.println("Teszt befejezõdött!");
				System.out.println();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} else { // Ha nem létezik a teszteset akkor hibaüzenet
			System.out.println();
			System.out.println("Hiba: A teszteset nem létezik!");
			System.out.println();
		}
	}

	/**
	 * Kiírja az összes regisztrált tesztesetet.
	 */
	public void printTests() {
		for (Integer key : testCasesMap.keySet()) {
			System.out.println(key + ".) " + testCasesMap.get(key).description);
		}
	}

	/**
	 * Segéd osztály a mapben a metódus tárolásához.
	 */
	private class MethodDescriptor {
		/**
		 * Tárolt metódus.
		 */
		private Method method;
		/**
		 * A tárolt metódus leírása.
		 */
		private String description;

		public MethodDescriptor(Method method, String description) {
			this.method = method;
			this.description = description;
		}
	}
}
