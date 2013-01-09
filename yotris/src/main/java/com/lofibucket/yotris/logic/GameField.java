
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
	protected Piece fallingPiece;
	private ZeroBasedCounter pieceFallCounter;

	/**
	 * Creates a game field with the given settings.
	 * @param settings	the settings to use
	 * @param counterLimit the counter limit to use (game speed)
	 */
	public GameField(Settings settings, int counterLimit) {
		this(settings);
		pieceFallCounter = new ZeroBasedCounter(0, counterLimit);
	}

	/**
	 * Creates a game field with the given settings and the default counter 
	 * limit (10).
	 * @param settings the settings to use
	 */
	public GameField(Settings settings) {
		this.settings = settings;
		this.grid = new GameGrid(settings.getGridWidth(), settings.getGridHeight());	
		this.fallingPiece = null;
		pieceFallCounter = new ZeroBasedCounter(0, 10);
	}

	/**
	 * Updates the time limit we use to measure the delay between successive
	 * game updates. Speeds up the game as levels increase.
	 * @param level Current game level.
	 */
	public void updateCounterLimit(int level) {
		pieceFallCounter.setLimit(Math.max(3, 19 - (int)(level*1.5)));
	}

	/**
	 * Updates the falling piece (moves it downwards, checks for collisions)
	 * @param logic the current GameLogic object (used to issue score updates)
	 */
	protected void updateFallingPiece(GameLogic logic) {
		pieceFallCounter.decrease();

		if (!pieceFallCounter.isZero()) {
			return;
		}

		if (fallingPiece == null) {
			if (spawnPiece()) {
				return;
			} else { 
				logic.endGame();
				return;
			}
		}

		if (grid.checkIfBottomCollides(fallingPiece)) {
			grid.plotPiece(fallingPiece);
			fallingPiece = null;
			pieceFallCounter.setValue(1);	// spawn a new block next frame
			logic.increaseScoreHitBottom();
			return;
		}

		if (!checkIfMoveIsLegal(fallingPiece, new Position(0, 1))) {
			return;
		}

		fallingPiece.moveDown();
	}

	/**
	 * Checks if there are any lines to be cleared and then clears them.
	 * @return how many lines were cleared
	 */
	protected int checkLines() {
		return grid.clearLines();
	}

	/**
	 * Creates the falling piece
	 * @return true if the piece was created successfully, and false if the
	 * piece couldn't fit 
	 */
	protected boolean spawnPiece() {
		if (settings.debugEnabled()) {
			System.out.println("Spawning a new block.");
		}

		Position center = new Position(grid.getWidth()/2, 0);
		fallingPiece = new Piece(TetrominoShape.getRandomShape(), 
				TileColor.getRandomColor(), center);
		// center the piece
		fallingPiece.move(new Position(-fallingPiece.getWidth()/2, 0)); 

		if (grid.checkIfCollides(fallingPiece)) {
			return false;
		}

		return true;
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

	/**
	 * Clears all full lines.
	 * @return how many full lines were cleared
	 */
	public int clearLines() {
		return checkLines();
	}
}
