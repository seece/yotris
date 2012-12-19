
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.util.Settings;


public class Game {
	private UserInterface ui;

	public Game(UserInterface ui) {
		this.ui = ui;
	}

	public void run() {
		Settings defaultSettings = new Settings();
		GameLogic logic = new GameLogic(ui, defaultSettings);
		GameState state;

		do {
			state = logic.update();
		} while (state.running);
	}
}
