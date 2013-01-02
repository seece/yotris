package com.lofibucket.yotris.logic;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import com.lofibucket.yotris.util.TileColor;

public class PieceTest {

	private Piece piece;
	private static final Tile blue = new Tile(TileColor.BLUE);
	private static final Tile[][] tiles_long_right = {
		{null, null, null, null},
		{blue, blue, blue, blue},
		{null, null, null, null},
		{null, null, null, null}
	};
	private static final Tile[][] tiles_long_down = {
		{null, blue, null, null},
		{null, blue, null, null},
		{null, blue, null, null},
		{null, blue, null, null}
	};
	private static final Tile[][] tiles_long_left = {
		{null, null, null, null},
		{blue, blue, blue, blue},
		{null, null, null, null},
		{null, null, null, null}
	};

	public PieceTest() {
	}

	@Before
	public void initPiece() {
		piece = new Piece(TetriminoShape.getShape("O"), TileColor.BLUE, new Position(0, 0));
	}

	@Test
	public void testPieceDefaultRotation() {
		assertEquals(Rotation.UP, piece.getRotation());
	}

	@Test
	public void testPieceRotationValue() {
		piece.rotateClockwise();
		assertEquals(Rotation.RIGHT, piece.getRotation());

		piece.rotateClockwise();
		assertEquals(Rotation.DOWN, piece.getRotation());

		piece.rotateCounterClockwise();
		piece.rotateCounterClockwise();
		assertEquals(Rotation.UP, piece.getRotation());
	}

	@Test
	public void testPieceRotationTiles() {
		Piece piece_long = new Piece(TetriminoShape.getShape("I"), TileColor.BLUE, new Position(0, 0));

		piece_long.rotateClockwise();
		Grid tiles = piece_long.getRotatedTiles();
		assertArrayEquals(tiles.getTiles(), tiles_long_right);

		piece_long.rotateClockwise();
		tiles = piece_long.getRotatedTiles();
		assertArrayEquals(tiles.getTiles(), tiles_long_down);

		piece_long.rotateClockwise();
		tiles = piece_long.getRotatedTiles();
		assertArrayEquals(tiles.getTiles(), tiles_long_left);

		piece_long.rotateCounterClockwise();
		piece_long.rotateCounterClockwise();
		tiles = piece_long.getRotatedTiles();
		assertArrayEquals(tiles.getTiles(), tiles_long_right);
	}

	@Test
	public void testPieceMirrorRotationTiles() {
		Piece piece_long = new Piece(TetriminoShape.getShape("I"), TileColor.BLUE, new Position(0, 0));
		piece_long.rotateClockwise();
		piece_long.rotateClockwise();
		Grid tiles = piece_long.getRotatedTiles();

		assertArrayEquals(tiles.getTiles(), tiles_long_down);
	}

	@Test
	public void testTetriminoParsing() {
		Grid tiles = piece.getGrid();
		boolean[][] o_shape = TetriminoShape.getShape("O");

		assertEquals(tiles.getWidth(), o_shape[0].length);
		assertEquals(tiles.getHeight(), o_shape.length);

		for (int y = 0; y < piece.getHeight(); y++) {
			for (int x = 0; x < piece.getWidth(); x++) {
				if (o_shape[y][x]) {
					assertTrue(tiles.getTile(x, y) != null);
				}
			}
		}

	}
}