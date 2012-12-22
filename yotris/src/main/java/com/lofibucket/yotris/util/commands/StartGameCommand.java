
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


public class StartGameCommand extends Command {
	public StartGameCommand(GameLogic logic) {
		super(logic);
	}

	@Override
	public void apply() {
		// TODO: Fix this! give the gamelogic as apply parameter, not to
		// constructor
		if (gamelogic == null) {
			return;
		}

		gamelogic.reset(gamelogic.getSettings());
	}

}
