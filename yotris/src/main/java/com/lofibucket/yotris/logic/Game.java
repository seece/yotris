
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.ui.gui.GUI;
import com.lofibucket.yotris.util.Settings;


/**
 * The main game class that creates the UI  and runs the Game class instance.
 */
public class Game {
	/**
	 * The user interface to use for this session.
	 */
	private UserInterface ui;
	/**
	 * The settings to use for this session.
	 */
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
		init();

		boolean running = true;

		GameLogic logic = new GameLogic(ui, settings);
		settings.setKeymap(Settings.getDefaultLayout());
		GameState state;

		do {
			ui.reset();

			do {
				state = logic.update(ui.pollCommands());
				running = state.running;

				try {
					Thread.sleep(logic.getFrameDelay());
				} catch (InterruptedException e) {

				}
			} while (!state.gameover && running);

		} while (running);

		ui.stop();

		if (settings.debugEnabled()) {
			System.out.println("Closing the application.");
		}
	}

	/**
	 * Initializes the game with default settings.
	 */
	private void init() {
		Settings defaultSettings = new Settings();
		this.settings = defaultSettings;

		ui = new GUI(defaultSettings);
		ui.start();
	}

}
