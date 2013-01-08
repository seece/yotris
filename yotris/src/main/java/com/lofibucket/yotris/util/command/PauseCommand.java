
package com.lofibucket.yotris.util.command;

import com.lofibucket.yotris.logic.GameLogic;

/**
 * Command that pauses the game.
 */
public class PauseCommand extends Command {

	@Override
	public void apply(GameLogic logic) {
		logic.pauseGame();
	}

}
