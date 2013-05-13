package System;

/**
 * <code>Enum</code> osztály az irány tárolására és megállapítására.
 * 
 */
public enum Direction {
	east, west, southWest, southEast, northEast, northWest;
	/**
	 * Visszaadja az irány ellenkezõ irányát.
	 * @return az elõzõ irány ellentettje
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

	/**
	 * A haladási irány számát haladási iránnyá konvertálja.
	 * @param i haladási irány <code>int</code> változata
	 * @return haladási irány <code>Direction</code> változata
	 */
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
