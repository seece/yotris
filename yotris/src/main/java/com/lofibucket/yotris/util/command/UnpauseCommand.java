
package com.lofibucket.yotris.util.command;

import com.lofibucket.yotris.logic.GameLogic;

/**
 * Continues a paused game.
 */
public class UnpauseCommand extends Command {

	@Override
	public void apply(GameLogic logic) {
		logic.unPauseGame();
	}
	
	@Override
	public boolean overridePause() {
		return true;
	}

}
