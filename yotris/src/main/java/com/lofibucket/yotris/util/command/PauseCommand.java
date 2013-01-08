
package com.lofibucket.yotris.util.command;

import com.lofibucket.yotris.logic.GameLogic;


public class PauseCommand extends Command {

	@Override
	public void apply(GameLogic logic) {
		logic.pauseGame();
	}

}
