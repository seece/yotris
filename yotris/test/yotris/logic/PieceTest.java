
package yotris.logic;

import org.junit.Test;
import static org.junit.Assert.*;
import yotris.util.TileColor;

public class PieceTest {

    public PieceTest() {
    }

	@Test
	public void testPieceDefaultRotation() {
		Piece piece = new Piece(Tetrimino.O, TileColor.BLUE, new Position(0, 0));
		assertEquals(Rotation.UP, piece.getRotation());
	}

	@Test
	public void testPieceRotation() {
		Piece piece = new Piece(Tetrimino.O, TileColor.BLUE, new Position(0, 0));

		piece.rotateClockwise();
		assertEquals(Rotation.RIGHT, piece.getRotation());

		piece.rotateClockwise();
		assertEquals(Rotation.DOWN, piece.getRotation());

		piece.rotateCounterClockwise();
		piece.rotateCounterClockwise();
		assertEquals(Rotation.UP, piece.getRotation());
	}

	@Test
	public void testTetriminoParsing() {
		Piece piece = new Piece(Tetrimino.O, TileColor.BLUE, new Position(0, 0));

		Tile[][] tiles = piece.getTiles();

		assertEquals(tiles[0].length, Tetrimino.O[0].length);
		assertEquals(tiles.length, Tetrimino.O.length);

		for (int y=0;y<piece.getHeight();y++) {
			for (int x=0;x<piece.getWidth();x++) {
				if (Tetrimino.O[y][x])	 {
					assertTrue(tiles[y][x] != null);
				}
			}
		}

	}

}