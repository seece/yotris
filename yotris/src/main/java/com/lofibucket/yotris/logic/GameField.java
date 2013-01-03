
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.util.Settings;
import com.lofibucket.yotris.util.TileColor;
import java.util.Random;


/**
 * This class takes care of concrete game logic operations, as in moving the
 * falling the piece and checking its collisions.
 */
public class GameField {
	private Settings settings;
	private GameGrid grid;
	private Piece fallingPiece;
	private ZeroBasedCounter pieceFallCounter;

	public GameField(Settings settings) {
		this.settings = settings;
		this.grid = new GameGrid(settings.getGridWidth(), settings.getGridHeight());	
		this.fallingPiece = null;
		pieceFallCounter = new ZeroBasedCounter(0, 10);
	}

	protected void updateFallingPiece() {
		pieceFallCounter.decrease();

		if (!pieceFallCounter.isZero()) {
			return;
		}

		if (fallingPiece == null) {
			spawnPiece();
			return;
		}

		if (grid.checkIfBottomCollides(fallingPiece)) {
			grid.plotPiece(fallingPiece);
			fallingPiece = null;
			return;
		}

		if (!checkIfMoveIsLegal(fallingPiece, new Position(0, 1))) {
			return;
		}

		fallingPiece.moveDown();
	}

	protected void spawnPiece() {
		if (settings.debugEnabled()) {
			System.out.println("Spawning a new block.");
		}

		Position center = new Position(grid.getWidth()/2, 0);
		fallingPiece = new Piece(TetrominoShape.getRandomShape(), getRandomColor(), center);

		if (grid.checkIfCollides(fallingPiece)) {
			//running = false;
			// TODO broadcast a gameover message?
		}
	}

	/**
	 *	Returns the complete game grid, used for rendering the game level in UI.
	 * @return	the game grid with the falling piece baked in
	 */
	public Grid getRenderGrid() {
		Grid renderGrid = new Grid(grid.getTiles());

		if (fallingPiece != null) {
			renderGrid.plotPiece(fallingPiece);
		}
		
		return renderGrid;
	}

	/**
	 * Moves the currently falling piece. 
	 * @param offset The amount and direction to move the piece.
	 */
	public void moveFallingPiece(Position offset) {
		if (fallingPiece == null) {
			return;
		}

		if (!checkIfMoveIsLegal(fallingPiece, offset)) {
			return;
		}

		fallingPiece.move(offset);
	}

	/**
	 * Checks if a piece would collide if the given movement was applied to it.
	 * @param piece	The piece to move
	 * @param offset	The movement amount
	 * @return True if move is legal, otherwise false
	 */
	public boolean checkIfMoveIsLegal(Piece piece, Position offset) {
		Piece temp = new Piece(piece);
		temp.move(offset);
		return !grid.checkIfCollides(temp);
	}

	/**
	 * Checks if a piece would collide if it was rotated once clockwise.
	 * @param piece	The piece to rotate
	 * @return True if move is legal, otherwise false
	 */
	public boolean checkIfRotationIsLegal(Piece piece) {
		Piece temp = new Piece(piece);
		temp.rotateClockwise();
		return !grid.checkIfCollides(temp);
	}

	/**
	 * Rotates the falling piece clockwise.
	 */
	public void rotateFallingPiece() {
		if (fallingPiece == null) {
			return;
		}

		if (!checkIfRotationIsLegal(fallingPiece)) {
			return;
		}

		fallingPiece.rotateClockwise();
	}

	// TODO move this somewhere else
	private TileColor getRandomColor() {
		TileColor[] colors;
		int choice;

		colors = TileColor.class.getEnumConstants();

		Random r = new Random();
		choice = r.nextInt(colors.length);

		return colors[choice];
	}

}
