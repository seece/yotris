
package com.lofibucket.yotris.logic;


public abstract class Movable {
	protected Position pos;

	abstract public void moveRight();	
	abstract public void moveLeft();	
	abstract public void moveUp();	
	abstract public void moveDown();	
	
	public Position getPos() {
		return pos;
	}
}
