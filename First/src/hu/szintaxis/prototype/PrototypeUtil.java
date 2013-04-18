package hu.szintaxis.prototype;

import java.awt.Point;
import java.io.File;

/**
 * Contains utility functions.
 * 
 * @author Dóczi Róbert
 * 
 */
public class PrototypeUtil {

	private static File outputFile;
	
	/**
	 * Converts a string into point.
	 * 
	 * @param input
	 *            the string to be converted
	 * @return the converted point
	 * @throws Exception
	 */
	public static Point stringToPoint(String input) throws Exception {
		String[] coords = input.split(",");
		if (coords.length != 2) {
			throw new Exception("Invalid coordinate format.");
		}
		Point point = new Point(Integer.parseInt(coords[0]),
				Integer.parseInt(coords[1]));
		return point;
	}

	public static File getOutputFile() {
		return outputFile;
	}

	public static void setOutputFile(File outputFile) {
		PrototypeUtil.outputFile = outputFile;
	}
}
