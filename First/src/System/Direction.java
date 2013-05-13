package System;

/**
 * <code>Enum</code> oszt�ly az ir�ny t�rol�s�ra �s meg�llap�t�s�ra.
 * 
 */
public enum Direction {
	east, west, southWest, southEast, northEast, northWest;
	/**
	 * Visszaadja az ir�ny ellenkez� ir�ny�t.
	 * @return az el�z� ir�ny ellentettje
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
	 * A halad�si ir�ny sz�m�t halad�si ir�nny� konvert�lja.
	 * @param i halad�si ir�ny <code>int</code> v�ltozata
	 * @return halad�si ir�ny <code>Direction</code> v�ltozata
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
