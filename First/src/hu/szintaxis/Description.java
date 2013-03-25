package hu.szintaxis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {
	/**
	 * A teszteset sorsz�ma
	 */
	int orderNumber();
	
	/**
	 * A teszteset le�r�sa
	 */
	String description();
}
