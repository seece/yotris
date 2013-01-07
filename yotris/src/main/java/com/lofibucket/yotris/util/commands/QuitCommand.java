
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;

public class QuitCommand extends Command {

	public QuitCommand() {
	}

	@Override
	public void apply(GameLogic logic) {
		logic.quitGame();
	}

	@Override
	public boolean overrideGameOver() {
		return true;
	}

}
