
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;
import com.lofibucket.yotris.logic.Position;


public class MoveDownCommand extends Command {
	public MoveDownCommand() {
	}

	@Override
	public void apply(GameLogic logic) {
		logic.moveFallingPiece(new Position(0, 1));
	}


}
