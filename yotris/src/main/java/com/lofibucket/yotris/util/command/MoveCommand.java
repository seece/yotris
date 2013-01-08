
package com.lofibucket.yotris.util.command;

import com.lofibucket.yotris.logic.GameLogic;
import com.lofibucket.yotris.logic.Position;


/**
 * A command that applies a move command with the given offset to the logic
 * class.
 * @author cce
 */
public class MoveCommand extends Command {
	private Position offset;

	public MoveCommand(Position offset) {
		super();
		this.offset = offset;
	}

	@Override
	public void apply(GameLogic logic) {
		logic.moveFallingPiece(offset);
	}

}
