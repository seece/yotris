
package com.lofibucket.yotris.logic;


public class GameGrid extends Grid {

	public GameGrid(Tile[][] tiles) {
		super(tiles);
	}

	public GameGrid(int width, int height) {
		super(width, height);
	}

	/**
	 * Checks if a given piece collides with this GameGrid.
	 * @param piece	The piece to test against to.
	 * @return 	True if a collision occurs, otherwise false.
	 */
	public boolean checkIfCollides(Piece piece) {
		Tile[][] tiles = piece.getRotatedTiles().getTiles();

		for (int y=0;y<piece.getHeight();y++) {
		for (int x=0;x<piece.getWidth();x++) {
			Tile t = tiles[y][x];

			if (t == null) {
				continue;
			}

			int tx = piece.getPos().x + x;
			int ty = piece.getPos().y + y;

			if (tx < 0 || ty < 0) {
				return true;
			}

			if (tx >= this.getWidth() || ty >= this.getHeight()) {
				return true;
			}
			
			if (this.getTile(tx, ty) != null) {
				return true;
			}
		}
		}

		return false;
	}

	/**
	 * Checks if a given piece has tiles underneath it.
	 * @param piece	The piece to check against to.
	 * @return True if collision occurs, otherwise false.
	 */
	public boolean checkIfBottomCollides(Piece piece) {
		Piece temp = new Piece(piece);
		temp.moveDown();
		return checkIfCollides(temp);
	}
}
