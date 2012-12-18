
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

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Tile[][] getMap() {
		return map;
	}

	public void plotPiece(Piece piece) {

	}

}
