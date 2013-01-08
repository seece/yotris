
package com.lofibucket.yotris.util.command;

import com.lofibucket.yotris.logic.GameLogic;


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
