package hu.szintaxis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {
	/**
	 * A teszteset sorszáma
	 */
	int orderNumber();
	
	/**
	 * A teszteset leírása
	 */
	String description();
}
