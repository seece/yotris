
package com.lofibucket.yotris.util.command;

import com.lofibucket.yotris.logic.GameLogic;


public class RotateCommand extends Command {

	@Override
	public void apply(GameLogic logic) {
		logic.rotateFallingPiece();
	}

}
