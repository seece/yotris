
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


public class UnpauseCommand extends Command {

	@Override
	public void apply(GameLogic logic) {
		logic.unPauseGame();
	}

}
