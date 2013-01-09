
package com.lofibucket.yotris.util.command;

import com.lofibucket.yotris.logic.GameLogic;
import com.lofibucket.yotris.logic.Position;


/**
 * A command that applies a move command with the given offset to the logic
 * class.
 */
public class MoveCommand extends Command {
	/**
	 * The offset to pass to the GameLogic object when this command is applied.
	 */
	private Position offset;

	/**
	 * Requires a Position object that tells us how much do we want to move
	 * the falling piece.
	 */
	public MoveCommand(Position offset) {
		super();
		this.offset = offset;
	}

	@Override
	public void apply(GameLogic logic) {
		logic.moveFallingPiece(offset);
	}

}
