
package yotris.logic;
import yotris.logic.Tile;

public class Grid {
	private int width;
	private int height;

	private Tile[][] map;

	public Grid(int width, int height) {
		this.width = width;
		this.height = height;

		map = new Tile[height][width];
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || x >= getWidth()) {
			return null;
		}

		if (y < 0 || y >= getHeight()) {
			return null;
		}

		return map[y][x];
	}

	public boolean setTile(int x, int y, Tile t) {
		if (x < 0 || x >= getWidth()) {
			return false;
		}

		if (y < 0 || y >= getHeight()) {
			return false;
		}

		map[y][x] = t;

		return true;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Tile[][] getTiles() {
		return map;
	}

	public void plotPiece(Piece piece) {
		Tile[][] tiles = piece.getRotatedTiles();

		for (int y=0;y<piece.getHeight();y++) {
		for (int x=0;x<piece.getWidth();x++) {
			int tile_offset_x = piece.getPos().x + x;
			int tile_offset_y = piece.getPos().y + y;
			Tile tile = tiles[y][x];
			setTile(tile_offset_x, tile_offset_y, tile);
		}
		}
	}

}
