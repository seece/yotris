
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.util.TileColor;

public class Piece {
	private Position pos;
	//private Tile tiles[][];	
	private Grid tiles;
	private Rotation rotation;
	private TileColor color;

	public Piece(boolean [][] tetrimino, TileColor color, Position pos) {
		this.rotation = Rotation.UP;
		this.color = color;
		this.tiles = new Grid(parseTileGridFromTetrimino(tetrimino));
		this.pos = pos;
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

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public Grid getTiles() {
		return tiles;
	}

	public Grid getRotatedTiles() {
		Grid rotated = new Grid(tiles.getTiles());

		switch (rotation) {
			case UP:
				break;
			case LEFT:
				rotated.rotateOnceClockwise();
				rotated.flipAroundX();
				break;
			case DOWN:
				rotated.flipAroundY();
				break;
			case RIGHT:
				rotated.rotateOnceClockwise();
				break;
			default:
				break;
		}

		return rotated;
	}

	public void setTiles(Grid tiles) {
		this.tiles = tiles;
	}

	public Rotation getRotation() {
		return rotation;
	}

	public void setRotation(Rotation rotation) {
		this.rotation = rotation;
	}

	public int getWidth() {
		return tiles.getWidth();
	}

	public int getHeight() {
		return tiles.getWidth();
	}

	public TileColor getColor() {
		return color;
	}

	public void setColor(TileColor color) {
		this.color = color;
	}


}
