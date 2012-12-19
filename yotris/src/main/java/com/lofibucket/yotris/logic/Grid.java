
package com.lofibucket.yotris.logic;
import java.util.Arrays;
import com.lofibucket.yotris.logic.Tile;

public class Grid {
	private int width;
	private int height;

	private Tile[][] tiles;

	public Grid(Tile[][] tiles) {
		int w = tiles[0].length;		
		int h = tiles.length;		

		this.width = w;
		this.height = h;

		this.tiles = new Tile[height][width];

		// TODO make this some ArrayCopy2D method
		for (int y=0;y<h;y++) {
		for (int x=0;x<w;x++) {
			if (tiles[y][x] != null) {
				this.tiles[y][x] = new Tile(tiles[y][x]);
			}
		}
		}
	}

	public Grid(int width, int height) {
		this.width = width;
		this.height = height;

		this.tiles = new Tile[height][width];
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || x >= getWidth()) {
			return null;
		}

		if (y < 0 || y >= getHeight()) {
			return null;
		}

		return tiles[y][x];
	}

	public boolean setTile(int x, int y, Tile t) {
		if (x < 0 || x >= getWidth()) {
			return false;
		}

		if (y < 0 || y >= getHeight()) {
			return false;
		}

		tiles[y][x] = t;

		return true;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void plotPiece(Piece piece) {
		Grid piece_tiles = piece.getRotatedTiles();
		return;

		/*
		for (int y=0;y<piece.getHeight();y++) {
		for (int x=0;x<piece.getWidth();x++) {
			int tile_offset_x = piece.getPos().x + x;
			int tile_offset_y = piece.getPos().y + y;
			Tile tile = piece_tiles.getTile(x, y);
			setTile(tile_offset_x, tile_offset_y, tile);
		}
		}
		*/
	}

	public void flipAroundX() {
		Grid temp = new Grid(tiles);
		for (int y=0;y<height;y++) {
			for (int x=0;x<width;x++) {
				setTile(x, y, temp.getTile(width-x-1, y));
			}
		}

		this.tiles = temp.getTiles();
	}

	public void flipAroundY() {
		Grid temp = new Grid(tiles);
		for (int y=0;y<height;y++) {
			for (int x=0;x<width;x++) {
				setTile(x, y, temp.getTile(x, height-y-1));
			}
		}

		this.tiles = temp.getTiles();
	}

	public void rotateOnceClockwise() {
		Grid temp = new Grid(tiles);
		for (int y=0;y<height;y++) {
			for (int x=0;x<width;x++) {
				setTile(x, y, temp.getTile(y, width-x-1));
			}
		}

		//this.tiles = temp.getTiles();
	}

}
