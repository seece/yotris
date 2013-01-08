
package com.lofibucket.yotris.util.command;

import com.lofibucket.yotris.logic.GameLogic;

/**
 * Command that toggles the game pause state. Issued from the menu option, or
 * through a keyboard shortcut.
 */
public class TogglePauseCommand extends Command {

	@Override
	public void apply(GameLogic logic) {
		if (logic.getGameState().paused) {
			logic.unPauseGame();
		} else {
			logic.pauseGame();
		}
	}

	@Override
	public boolean overridePause() {
		return true;
	}
}
