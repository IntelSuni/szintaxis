/**
 * 
 */
package System;

/**
 * @author Martin
 * 
 */
public enum Direction {
	east,
	west,
	southWest,
	southEast,
	northEast,
	northWest;
	/**
	 * 
	 * @return the negate of the previous direction
	 */
	Direction negate(){
		Direction result=null;
		switch (this){
		case east:		result=west;
			break;
		case northEast:	result=southWest;
			break;
		case northWest:	result=southEast;
			break;
		case southEast:	result=northWest;
			break;
		case southWest:	result=northEast;
			break;
		case west: 		result=east;
			break;
		default:
			break;
			
		}
		return result;
	}
}
