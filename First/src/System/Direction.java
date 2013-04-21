/**
 * 
 */
package System;

/**
 * @author Martin
 * 
 */
public enum Direction {
	east, west, southWest, southEast, northEast, northWest;
	/**
	 * 
	 * @return the negate of the previous direction
	 */
	Direction negate() {
		Direction result = null;
		switch (this) {
		case east:
			result = west;
			break;
		case northEast:
			result = southWest;
			break;
		case northWest:
			result = southEast;
			break;
		case southEast:
			result = northWest;
			break;
		case southWest:
			result = northEast;
			break;
		case west:
			result = east;
			break;
		default:
			break;

		}
		return result;
	}

	public static Direction getDirection(int i) {
		Direction result = null;
		switch (i) {
		case 0:
			result = northWest;
			break;
		case 1:
			result = northEast;
			break;
		case 2:
			result = west;
			break;
		case 3:
			result = east;
			break;
		case 4:
			result = southWest;
			break;
		case 5:
			result = southEast;
			break;
		}
		return result;
	}
}
