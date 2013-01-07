
package com.lofibucket.yotris.logic;

/**
 * An interface that represents a movable object with position.
 */
public abstract class Movable {
	protected Position pos;

	abstract public void move(Position offset);
	abstract public void moveRight();	
	abstract public void moveLeft();	
	abstract public void moveUp();	
	abstract public void moveDown();	
	
	public Position getPos() {
		return pos;
	}
}
