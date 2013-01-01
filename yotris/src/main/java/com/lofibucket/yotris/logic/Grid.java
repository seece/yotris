
package com.lofibucket.yotris.logic;
import java.util.Arrays;
import com.lofibucket.yotris.logic.Tile;

/**
 *	The grid class used to represent the game area and also tetrimino pieces.
 */
public class Grid {
	private int width;
	private int height;

	private Tile[][] tiles;

	/**
	 *	A semi copy constructor, builds a new grid from a 2D Tile array
	 * @param tiles	A two dimensional array to use as a base for new grid
	 */
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

	/**
	 * The default constructor
	 * @param width	grid width in tiles
	 * @param height grid height in tiles
	 */
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;

		this.tiles = new Tile[height][width];
	}

	/**
	 * Tile getter. 
	 * @param x x-coordinate of the tile to be read
	 * @param y y-coordinate of the tile to be read
	 * @return the Tile object at (x, y), null if coordinates out of bounds
	 */
	public Tile getTile(int x, int y) {
		if (x < 0 || x >= getWidth()) {
			return null;
		}

		if (y < 0 || y >= getHeight()) {
			return null;
		}

		return tiles[y][x];
	}

	/**
	 * Sets the value of an arbitrary tile. 
	 * @param x	x-coordinate where to insert the tile
	 * @param y	y-coordinate where to insert the tile
	 * @param t	the tile to insert
	 * @return	true if successful, false if coordinate out of bounds
	 */
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

	/**
	 *
	 * @return grid width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 *
	 * @return grid height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 *
	 * @return internal tile array representation of the grid
	 */
	public Tile[][] getTiles() {
		return tiles;
	}

	/**
	 * Checks if this grid intersects with the given piece.
	 * @param piece	The piece to check against to
	 * @return 	true on intersection, otherwise false
	 */
	public boolean checkIntersection(Piece piece) {
		return checkIntersection(piece, new Position(0, 0));
	}

	/**
	 * Checks if this grid intersects with the given piece with the given 
	 * offset.
	 * @param piece	The piece to check against to
	 * @param offset	An offset to be applied to the piece position 
	 * before testing for intersections
	 * @return 	true on intersection, otherwise false
	 */
	public boolean checkIntersection(Piece piece, Position offset) {
		Piece mockpiece = new Piece(piece);
		Grid piece_tiles = mockpiece.getRotatedTiles();

		for (int y=0;y<mockpiece.getHeight();y++) {
		for (int x=0;x<mockpiece.getWidth();x++) {
			int tile_offset_x = mockpiece.getPos().x + x;
			int tile_offset_y = mockpiece.getPos().y + y;

			if (piece_tiles.getTile(x, y) != null) {
				if (getTile(tile_offset_x, tile_offset_y) != null) {
					return true;
				}
			}
		}
		}

		return false;
	}

	/**
	 * Adds tiles of a Piece instance to the grid. The coordinates are read
	 * from the piece argument attributes.
	 * @param piece	The piece to be added to the grid
	 */
	public void plotPiece(Piece piece) {
		Grid piece_tiles = piece.getRotatedTiles();
		//return;

		for (int y=0;y<piece.getHeight();y++) {
		for (int x=0;x<piece.getWidth();x++) {
			int tile_offset_x = piece.getPos().x + x;
			int tile_offset_y = piece.getPos().y + y;
			Tile tile = piece_tiles.getTile(x, y);
			setTile(tile_offset_x, tile_offset_y, tile);
		}
		}
	}

	/**
	 *	Mirrors the grid horizontally.
	 */
	public void flipAroundX() {
		Grid temp = new Grid(tiles);
		for (int y=0;y<height;y++) {
			for (int x=0;x<width;x++) {
				setTile(x, y, temp.getTile(width-x-1, y));
			}
		}

		this.tiles = temp.getTiles();
	}

	/**
	 *	Mirrors the grid vertically.
	 */
	public void flipAroundY() {
		Grid temp = new Grid(tiles);
		for (int y=0;y<height;y++) {
			for (int x=0;x<width;x++) {
				setTile(x, y, temp.getTile(x, height-y-1));
			}
		}

		this.tiles = temp.getTiles();
	}

	/**
	 *	Rotates the grid 90 degrees clockwise.
	 */
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
