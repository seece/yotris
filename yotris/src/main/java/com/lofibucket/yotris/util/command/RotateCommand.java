
package com.lofibucket.yotris.util.command;

import com.lofibucket.yotris.logic.GameLogic;

/**
 * Command that rotates the currently falling piece.
 */
public class RotateCommand extends Command {

	@Override
	public void apply(GameLogic logic) {
		logic.rotateFallingPiece();
	}

}
