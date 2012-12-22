
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.ui.gui.GUI;
import com.lofibucket.yotris.util.Settings;


/**
 * The main game class that creates the ui and runs the Game class instance.
 */
public class Game {
	private UserInterface ui;
	private Settings settings;

	/**
	 * Game constructor
	 */
	public Game() {
	}

	/**
	 *	Runs the main game loop. Exits when the game ends.
	 */
	public void run() {
		GameLogic logic = new GameLogic(ui, settings);

		Settings defaultSettings = new Settings(logic);
		UserInterface ui = new GUI(defaultSettings);

		GameState state;

		do {
			state = logic.update(ui.getNewCommands());
		} while (state.running);
	}
}
