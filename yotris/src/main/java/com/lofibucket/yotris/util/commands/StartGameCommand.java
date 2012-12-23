
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


public class StartGameCommand extends Command {
	public StartGameCommand() {
	}

	@Override
	public void apply(GameLogic logic) {
		// TODO: Fix this! give the gamelogic as apply parameter, not to
		// constructor
		if (logic == null) {
			return;
		}

		logic.reset(logic.getSettings());
	}

}
