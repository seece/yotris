
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.util.TileColor;

/**
 *
 * A single tetris piece consisting of a Tile Grid.
 */
public class Piece extends Movable {
	//private Tile tiles[][];	
	private Grid tiles;
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
		this.tiles = new Grid(parseTileGridFromTetrimino(tetrimino));
		this.pos = pos;
	}

	/**
	 * A constructor that takes in a two dimensional Tile array as parameter
	 * instead of a boolean array.
	 * @param tiles		The tile shape array for this piece
	 * @param color		The color of this piece
	 * @param pos		Position in the game grid, used when plotting
	 */
	public Piece(Tile[][] tiles, TileColor color, Position pos) {
		this.rotation = Rotation.UP;
		this.color = color;
		this.tiles = new Grid(tiles);
		this.pos = pos;
	}

	/**
	 * 	A copy constructor.
	 * @param piece 	Copies all fields from this piece.
	 */
	Piece(Piece piece) {
		this(piece.getGrid().getTiles(), piece.getColor(), piece.getPos());
	}

	private Tile[][] parseTileGridFromTetrimino(boolean [][] tetrimino) {
		int block_width = tetrimino[0].length;
		int block_height = tetrimino.length;

		Tile[][] tilearray= new Tile[block_width][block_height];
		
		for (int y=0;y<block_height;y++) {
			for (int x=0;x<block_width;x++) {
				if (tetrimino[y][x]) {
					tilearray[y][x]	= new Tile(this.color);
				}
			}
		}
		
		return tilearray;
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
	 * @return Returns the tiles the piece consists of
	 */
	public Grid getGrid() {
		return tiles;
	}

	/**
	 * Returns the piece tiles with the correct rotation
	 * @return The rotated tile grid
	 */
	public Grid getRotatedTiles() {
		Grid rotated = new Grid(tiles.getTiles());

		switch (rotation) {
			case UP:
				break;
			case LEFT:
				rotated.rotateOnceClockwise();
				rotated.rotateOnceClockwise();
				rotated.rotateOnceClockwise();
				break;
			case DOWN:
				rotated.rotateOnceClockwise();
				rotated.rotateOnceClockwise();
				break;
			case RIGHT:
				rotated.rotateOnceClockwise();
				break;
			default:
				break;
		}

		return rotated;
	}

	/**
	 * Change this pieces internal tile grid
	 * @param tiles New grid to be used
	 */
	public void setGrid(Grid tiles) {
		this.tiles = tiles;
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
		return tiles.getWidth();
	}

	/**
	 *
	 * @return Piece grid height
	 */
	public int getHeight() {
		return tiles.getWidth();
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

	



}
