
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.util.TileColor;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class GameGridTest {
	public GameGrid grid;
	public Piece piece;

	@Before
	public void initTests() {
		grid = new GameGrid(10, 20);	
		piece = new Piece(TetriminoShape.getShape("O"), TileColor.BLUE, new Position(0,0));
	}

	@Test
	public void testCollision() {
		grid.plotPiece(piece);
		assertTrue(grid.checkIfCollides(piece));
	}

	@Test
	public void testNoCollisionTopBorder() {
		piece.setPos(new Position(0, 0));
		assertFalse(grid.checkIfCollides(piece));
	}

	@Test
	public void testNoCollisionBottomBorder() {
		piece.setPos(new Position(0, grid.getHeight()-piece.getHeight()));
		assertFalse(grid.checkIfCollides(piece));
	}

	@Test
	public void testNoCollisionLeftBorder() {
		piece.setPos(new Position(0, 2));
		assertFalse(grid.checkIfCollides(piece));
	}

	@Test
	public void testNoCollisionRightBorder() {
		piece.setPos(new Position(grid.getWidth()-piece.getWidth(), 2));
		assertFalse(grid.checkIfCollides(piece));
	}

	@Test
	public void testBottomBorderCollision() {
		piece.setPos(new Position(0, grid.getHeight()));
		assertTrue(grid.checkIfCollides(piece));
	}

	@Test
	public void testTopBorderCollision() {
		piece.setPos(new Position(0, -1));
		assertTrue(grid.checkIfCollides(piece));
	}

	@Test
	public void testLeftBorderCollision() {
		piece.setPos(new Position(-2, 0));
		assertTrue(grid.checkIfCollides(piece));
	}

	@Test
	public void testRightBorderCollision() {
		piece.setPos(new Position(grid.getWidth(), 0));
		assertTrue(grid.checkIfCollides(piece));
	}

	@Test
	public void testBottomCollision() {
		piece.setPos(new Position(1, 4));
		grid.plotPiece(piece);
		piece.setPos(new Position(1, 3));
		assertTrue(grid.checkIfBottomCollides(piece));
	}

}