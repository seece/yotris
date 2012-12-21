
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.util.Settings;


/**
 * The main game class that creates the ui and runs the Game class instance.
 */
public class Game {
	private UserInterface ui;

	/**
	 * Game constructor
	 * @param ui	The user interface to be used for this session
	 */
	public Game(UserInterface ui) {
		this.ui = ui;
	}

	/**
	 *	Runs the main game loop. Exits when the game ends.
	 */
	public void run() {
		Settings defaultSettings = new Settings();
		GameLogic logic = new GameLogic(ui, defaultSettings);
		GameState state;

		do {
			state = logic.update(ui.getNewCommands());
		} while (state.running);
	}
}
