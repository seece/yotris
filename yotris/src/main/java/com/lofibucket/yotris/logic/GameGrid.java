
package com.lofibucket.yotris.logic;


public class GameGrid extends Grid {

	public GameGrid(Tile[][] tiles) {
		super(tiles);
	}

	public GameGrid(int width, int height) {
		super(width, height);
	}

	/**
	 * Checks if a given piece collides with this GameGrid. Takes also the
	 * grid borders into account.
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
	 * Checks if a given piece has tiles or a grid border underneath it.
	 * @param piece	The piece to check against to.
	 * @return True if collision occurs, otherwise false.
	 */
	public boolean checkIfBottomCollides(Piece piece) {
		Piece temp = new Piece(piece);
		temp.moveDown();
		return checkIfCollides(temp);
	}

	public boolean checkIfLineIsSolid(int y) {
		for (int x=0;x<this.getWidth();x++) {
			if (getTile(x, y) == null) {
				return false;
			}
		}
		return true;
	}

	public int clearLines() {
		int cleared_lines;
		int total = 0;

		do {
			cleared_lines = 0;

			for (int y=0;y<=this.getHeight();y++) {
				if (this.checkIfLineIsSolid(y)) {
					deleteRow(y);
					cleared_lines++;
					break;
				}
			}

			total += cleared_lines;
		} while (cleared_lines > 0);

		return total;
	}

	protected void deleteRow(int start_y) throws IndexOutOfBoundsException {
		if (start_y < 0 || start_y >= this.getHeight()) {
			throw new IndexOutOfBoundsException("Grid vertical index " + start_y 
					+ " is out of bounds.");
		}

		// move all rows from y upwards one tile down
		for (int y=start_y;y>0;y--) {
			for (int x=0;x<this.getWidth();x++) {
				setTile(x, y, getTile(x, y-1));
			}
		}

		// clear the topmost row
		for (int x=0;x<this.getWidth();x++) {
			setTile(x, 0, null);
		}

	}

}
