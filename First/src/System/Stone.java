/**
 * 
 */
package System;

import java.util.ArrayList;

/**
 * @author Martin
 *
 */
public class Stone extends Block {

	/**
	 * A kavics ezen a mez�n van.
	 */
	private Field currentField;
	
	/* (non-Javadoc)
	 * @see System.Block#accept(System.Visitor)
	 */
	@Override
	public boolean accept(Visitor visitor) {
		return visitor.visit(this);
	}
	/**
	 * Ko mozgatása a direction parameter altal mutatott iranyba, returns false ha nem tud oda kovet rakni
	 * @param direction
	 * @return
	 */
	boolean moving (Direction direction){
		ArrayList<Field> fields = this.currentField.getNeighbours();
		//ez tartalmazza a masik mezot amire at kellene rakni a kavicsot
		Field result = null;
		int x,y;
		x=this.currentField.getPoint().x;
		y=this.currentField.getPoint().y;
		switch (direction) {
			case east:	
					for(Field f : fields){
						if (f.getPoint().y==y){
							if(f.getPoint().x>y)result=f;
						}
					}
				break;
			case northEast:		
				for(Field f : fields){
					if (f.getPoint().y>=y){
						if(f.getPoint().x>x)result=f;
					}
				}
				break;
			case northWest:		
				for(Field f : fields){
					if (f.getPoint().y<=y){
						if(f.getPoint().x<x)result=f;
					}
				}
				break;
			case west:
				for(Field f : fields){
					if (f.getPoint().y==y){
						if(f.getPoint().x<x)result=f;
					}
				}
				break;
			case southWest:		
				for(Field f : fields){
					if (f.getPoint().y<=y){
						if(f.getPoint().x<y)result=f;
					}
				}
				break;
			case southEast:		
				for(Field f : fields){
					if (f.getPoint().y<=y){
						if(f.getPoint().x>y)result=f;
					}
				}
				break;
			
			default:
				break;
		}
		ArrayList<Element> elements=result.getElements();
		//megnezni hogy lehet e oda mozgatni a kovet
		for(Element e : elements){
			if(e.getClass()== Ant.class) continue;
			else if(e.getClass()== Anteater.class) continue;
			else if(e.getClass()== AntHill.class) return false;
			else if(e.getClass()== Antlion.class) return false;
			else if(e.getClass()== Block.class) return false;
			else if(e.getClass()== FoodStore.class) return false;
			else if(e.getClass()== Stone.class) return false;
			else if(e.getClass()== Antlion.class) return false;
		}
		//eddig nem jut el, ha volt valami mas mint hangya a mezon
		//ha volt hangya ott
		for(Element e:elements){
			if(e.getClass()== Ant.class) result.removeElement(e);
			}
		
		System.out.println("Stone moved from " + this.currentField.getPoint().x + "," + this.currentField.getPoint().y + ".");
		//ko mozgatasa
		result.addElement(this);
		currentField.removeElement(this);
		return true;
	}
	
}
