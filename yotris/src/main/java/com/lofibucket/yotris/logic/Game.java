
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.ui.gui.GUI;
import com.lofibucket.yotris.util.Settings;
import com.lofibucket.yotris.util.commands.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;


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
		Settings defaultSettings = new Settings();
		this.settings = defaultSettings;

		UserInterface ui = new GUI(defaultSettings);
		GameLogic logic = new GameLogic(ui, settings);

		defaultSettings.setKeymap(getDefaultLayout(logic));

		GameState state;

		ui.start();

		do {
			state = logic.update(ui.getNewCommands());
		} while (state.running);
	}

	// TODO move this somewhere else
	private Map<Integer, Command> getDefaultLayout(GameLogic logic) {
		Map<Integer, Command> map = new HashMap<>();

		map.put(KeyEvent.VK_LEFT, new MoveLeftCommand(logic));
		map.put(KeyEvent.VK_RIGHT, new MoveRightCommand(logic));
		map.put(KeyEvent.VK_DOWN, new MoveDownCommand(logic));

		return map;
	}
}
