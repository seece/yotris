
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.util.Settings;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class GameFieldTest {

	private Settings settings;
	private GameField field;
	private Endable logic;

    public GameFieldTest() {
    }

	@Before
	public void init() {
		settings = new Settings();
		field = new GameField(settings, 1);
		logic = new GameLogicMock();
	}

	@Test
	public void testFallingPieceGetsCreatedAfterClockReset() {
		init();

		field.updateFallingPiece(logic);
		field.updateFallingPiece(logic);
		assertTrue(field.fallingPiece != null);
	}

	@Test
	public void testFallingPieceRotationWorks() {
		init();

		field.updateFallingPiece(logic);
		field.updateFallingPiece(logic);
		field.rotateFallingPiece();
		assertEquals(field.fallingPiece.getRotation(), Rotation.RIGHT);
	}

}