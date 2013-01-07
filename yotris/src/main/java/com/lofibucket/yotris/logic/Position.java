
package com.lofibucket.yotris.logic;

/**
 * Simple two-dimensional position class
 */
public class Position {
	/**
	 * The x-coordinate value
	 */
	public int x;
	/**
	 * The y-coordinate value
	 */
	public int y;

	/**
	 * Creates a new Position
	 * @param x x-coordinate
	 * @param y y-coordinate
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * A copy constructor.
	 * @param pos The instance to clone.
	 */
	public Position(Position pos) {
		this.x = pos.x;
		this.y = pos.y;
	}

	@Override
	public String toString() {
		return "Position{" + "x=" + x + ", y=" + y + '}';
	}

}
