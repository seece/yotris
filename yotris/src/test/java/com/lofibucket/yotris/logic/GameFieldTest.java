
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.ui.UserInterfaceMock;
import com.lofibucket.yotris.util.Settings;
import com.lofibucket.yotris.util.TileColor;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class GameFieldTest {

	private Settings settings;
	private GameField field;
	private GameLogic logic;
	private UserInterface ui;

    public GameFieldTest() {
    }

	@Before
	public void init() {
		settings = new Settings();
		ui = new UserInterfaceMock();
		field = new GameField(settings, 1);
		logic = new GameLogicMock(ui, settings);
	}

	@Test
	public void testFallingPieceGetsCreatedAfterClockReset() {
		init();

		field.updateFallingPiece(logic);
		field.updateFallingPiece(logic);
		assertTrue(field.fallingPiece != null);
	}

	@Test
	public void testFallingPieceRotation() {
		init();

		field.updateFallingPiece(logic);
		field.updateFallingPiece(logic);
		field.rotateFallingPiece();
		assertEquals(field.fallingPiece.getRotation(), Rotation.RIGHT);
	}

	@Test
	public void testFallingPieceFalls() {
		init();

		field.updateFallingPiece(logic);
		field.updateFallingPiece(logic);
		Position origpos = new Position(field.fallingPiece.getPos());
		field.moveFallingPiece(new Position(0, 1));
		assertEquals(origpos.x, field.fallingPiece.getPos().x);
		assertTrue(origpos.y < field.fallingPiece.getPos().y);
	}

	@Test
	public void testOutOfBoundaryMovesAreIllegal() {
		init();
		Piece p = new Piece(TetrominoShape.getShape("O"), TileColor.BLUE,
				new Position(0,0));
		assertFalse(field.checkIfMoveIsLegal(p, new Position(0, 100)));
		assertFalse(field.checkIfMoveIsLegal(p, new Position(0, -100)));
		assertFalse(field.checkIfMoveIsLegal(p, new Position(100, 0)));
		assertFalse(field.checkIfMoveIsLegal(p, new Position(-100, 0)));
	}

}