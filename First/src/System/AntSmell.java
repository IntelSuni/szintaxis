package System;

/**
 * HangyaBoly
 * @author gbeatrix
 * @version 1.0
 * @created 20-márc.-2013 10:42:46
 */
public class AntSmell extends Smell {

	public AntSmell(){
		System.out.println(getClass().getName() + " created.");
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void activate(){

	}

	public void decrementIntensity(){

	}

	public int getIntensity(){
		return 0;
	}

	public void update(){

	}

}