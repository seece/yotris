
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;
import com.lofibucket.yotris.logic.Position;


public class MoveRightCommand extends Command {
	public MoveRightCommand() {
	}

	@Override
	public void apply(GameLogic logic) {
		logic.moveFallingPiece(new Position(1, 0));
	}


}
