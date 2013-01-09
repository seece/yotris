
package com.lofibucket.yotris.logic;
import com.lofibucket.yotris.util.TileColor;

/**
 *	The grid class used to represent the game area and also tetrimino pieces.
 */
public class Grid {
	/**
	 * The width of this grid.
	 */
	private int width;
	/**
	 * The height of this grid.
	 */
	private int height;

	/**
	 * The two-dimensional array containing the actual tiles.
	 */
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

		// build a new array
		for (int y=0;y<h;y++) {
		for (int x=0;x<w;x++) {
			if (tiles[y][x] != null) {
				this.tiles[y][x] = new Tile(tiles[y][x]);
			}
		}
		}
	}

	/**
	 * The custom shape constructor. Used in Piece.
	 * @param shape	the shape to set the grid tiles to as default
	 * @param color grid tile color
	 */
	public Grid(boolean[][] shape, TileColor color) {
		this.tiles = parseTileGridFromTetrimino(shape, color);
		this.width = this.tiles[0].length;
		this.height = this.tiles.length;
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
	 * Creates an array of Tiles with the given color from the given 2D boolean
	 * array.
	 * @param tetrimino	the shape to use
	 * @param color	the color to set all non-null tiles
	 * @return 	the new tile array
	 */
	private Tile[][] parseTileGridFromTetrimino(boolean [][] tetrimino, TileColor color) {
		int block_width = tetrimino[0].length;
		int block_height = tetrimino.length;

		Tile[][] tilearray= new Tile[block_width][block_height];
		
		for (int y=0;y<block_height;y++) {
			for (int x=0;x<block_width;x++) {
				if (tetrimino[y][x]) {
					tilearray[y][x]	= new Tile(color);
				}
			}
		}
		
		return tilearray;
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

			if (tile == null) {
				continue;
			}

			setTile(tile_offset_x, tile_offset_y, tile);
		}
		}
	}



}
