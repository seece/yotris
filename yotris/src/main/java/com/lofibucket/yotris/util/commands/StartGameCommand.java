
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;

public class StartGameCommand extends Command {
	public StartGameCommand() {
	}

	@Override
	public void apply(GameLogic logic) {
		logic.reset(logic.getSettings());
	}

	@Override
	public boolean overridePause() {
		return true;
	}

	@Override
	public boolean overrideGameOver() {
		return true;
	}



}
