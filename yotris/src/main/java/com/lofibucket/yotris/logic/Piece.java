
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.util.TileColor;

/**
 *
 * A single tetris piece consisting of a Tile Grid.
 */
public class Piece extends Movable {
	//private Tile grid[][];	
	private Grid grid;
	private Rotation rotation;
	private TileColor color;

	/**
	 * Default constructor
	 * @param tetrimino	The tetrimino shape for this piece
	 * @param color		The color of this piece
	 * @param pos		Position in the game grid, used when plotting
	 */
	public Piece(boolean [][] tetrimino, TileColor color, Position pos) {
		this.rotation = Rotation.UP;
		this.color = color;
		this.grid = new Grid(tetrimino, this.color);
		this.pos = pos;
	}

	/**
	 * A constructor that takes in a two dimensional Tile array as parameter
	 * instead of a boolean array.
	 * @param grid		The tile shape array for this piece
	 * @param color		The color of this piece
	 * @param pos		Position in the game grid, used when plotting
	 */
	public Piece(Tile[][] tiles, TileColor color, Position pos) {
		this.rotation = Rotation.UP;
		this.color = color;
		this.grid = new Grid(tiles);
		this.pos = pos;
	}

	/**
	 * 	A copy constructor. Note that it also copies the rotation field
	 * that's missing from the other constructors.
	 * @param piece 	Copies all fields from this piece.
	 */
	Piece(Piece piece) {
		this(piece.getGrid().getTiles(), piece.getColor(), new Position(piece.getPos()));
		this.rotation = piece.getRotation();
	}

	/**
	 * Rotates the piece clockwise 
	 * @return The new orientation
	 */
	public Rotation rotateClockwise() {
		switch (rotation) {
			case UP:
				rotation = Rotation.RIGHT;
				break;
			case RIGHT:
				rotation = Rotation.DOWN;
				break;
			case DOWN:
				rotation = Rotation.LEFT;
				break;
			case LEFT:
				rotation = Rotation.UP;
				break;
			default:
				break;
		}

		return rotation;
	}

	/**
	 * Rotates the piece in counter clockwise direction
	 * @return The new orientation
	 */
	public Rotation rotateCounterClockwise() {
		switch (rotation) {
			case UP:
				rotation = Rotation.LEFT;
				break;
			case LEFT:
				rotation = Rotation.DOWN;
				break;
			case DOWN:
				rotation = Rotation.RIGHT;
				break;
			case RIGHT:
				rotation = Rotation.UP;
				break;
			default:
				break;
		}

		return rotation;
	}

	/**
	 * Piece position getter
	 * @return position
	 */
	@Override
	public Position getPos() {
		return pos;
	}

	/**
	 * Piece position setter
	 * @param pos New position for this piece
	 */
	public void setPos(Position pos) {
		this.pos = pos;
	}

	/**
	 * Internal Grid structure getter
	 * @return Returns the grid the piece consists of
	 */
	public Grid getGrid() {
		return grid;
	}

	/**
	 * Returns the piece grid with the correct rotation
	 * @return The rotated tile grid
	 */
	public Grid getRotatedTiles() {
		Grid rotated = new Grid(grid.getTiles());

		switch (rotation) {
			case UP:
				break;
			case LEFT:
				rotated = rotateClockwise(rotated);
				rotated = rotateClockwise(rotated);
				rotated = rotateClockwise(rotated);
				break;
			case DOWN:
				rotated = rotateClockwise(rotated);
				rotated = rotateClockwise(rotated);
				break;
			case RIGHT:
				rotated = rotateClockwise(rotated);
				break;
			default:
				break;
		}

		return rotated;
	}

	/**
	 * Change this pieces internal tile grid
	 * @param grid New grid to be used
	 */
	public void setGrid(Grid tiles) {
		this.grid = tiles;
	}

	/**
	 * The piece rotation getter
	 * @return Current orientation
	 */
	public Rotation getRotation() {
		return rotation;
	}

	/**
	 * Piece rotation setter
	 * @param rotation The new rotation 
	 */
	public void setRotation(Rotation rotation) {
		this.rotation = rotation;
	}

	/**
	 *
	 * @return Piece grid width
	 */
	public int getWidth() {
		return grid.getWidth();
	}

	/**
	 *
	 * @return Piece grid height
	 */
	public int getHeight() {
		return grid.getWidth();
	}

	/**
	 *
	 * @return Piece color
	 */
	public TileColor getColor() {
		return color;
	}

	/**
	 *
	 * @param color	New color for this piece
	 */
	public void setColor(TileColor color) {
		this.color = color;
	}

	/**
	 *	Moves the piece one step to the right
	 */
	@Override
	public void moveRight() {
		pos.x++;
	}

	/**
	 *	Moves the piece one step to the left
	 */
	@Override
	public void moveLeft() {
		pos.x--;
	}

	/**
	 *	Moves the piece one step up
	 */
	@Override
	public void moveUp() {
		pos.y--;
	}

	/**
	 *	Moves the piece one step down
	 */
	@Override
	public void moveDown() {
		pos.y++;
	}

	@Override
	public void move(Position offset) {
		pos.x += offset.x;
		pos.y += offset.y;
	}

	/**
	 *	Rotates a given grid 90 degrees clockwise.
	 */
	private static Grid rotateClockwise(Grid grid) {
		Grid temp = new Grid(grid.getWidth(), grid.getHeight());

		for (int y=0;y<grid.getHeight();y++) {
			for (int x=0;x<grid.getWidth();x++) {
				temp.setTile(x, y, grid.getTile(y, temp.getWidth()-x-1));
			}
		}

		return temp;
	}

}
