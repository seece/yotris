
package yotris.logic;

import yotris.util.TileColor;

public class Piece {
	private Position pos;
	private Tile tiles[][];	
	private Rotation rotation;
	private TileColor color;

	public Piece(boolean [][] tetrimino, TileColor color, Position pos) {
		this.rotation = Rotation.UP;
		this.color = color;
		this.tiles = parseTileGridFromTetrimino(tetrimino);
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

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public Rotation getRotation() {
		return rotation;
	}

	public void setRotation(Rotation rotation) {
		this.rotation = rotation;
	}

	public int getWidth() {
		return tiles[0].length;
	}

	public int getHeight() {
		return tiles.length;
	}


}
