
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.ui.gui.GUI;
import com.lofibucket.yotris.util.Settings;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingUtilities;


/**
 * The main game class that creates the UI  and runs the Game class instance.
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

	private void init() {
		Settings defaultSettings = new Settings();
		this.settings = defaultSettings;
		this.settings.enableDebug();

		ui = new GUI(defaultSettings);
		ui.start();
	}

}
