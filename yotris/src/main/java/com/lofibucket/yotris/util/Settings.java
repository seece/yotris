
package com.lofibucket.yotris.util;
import com.lofibucket.yotris.util.commands.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Holds all game settings.
 */
public class Settings {
	private DifficultyLevel difficulty;
	private int gridWidth;
	private int gridHeight;
	private Map<Integer, Command> keymap;

	/**
	 * The constructor with no parameters initializes the default settings. 
	 */
	public Settings() {
		// the default settings
		this(DifficultyLevel.EASY, 10, 20);
	}

	/**
	 *
	 * @param difficulty	The game difficulty level, see {@link DifficultyLevel}
	 * @param gridWidth	The game area width in tiles
	 * @param gridHeight	The game are height in tiles
	 */
	public Settings(DifficultyLevel difficulty, int gridWidth, int gridHeight) { 
			
		this.difficulty = difficulty;
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
		this.keymap = new HashMap<>();

		//addDefaultLayout(keymap, logic);
	}

	/*
	private void addDefaultLayout(Map<Integer, Command> map, GameLogic logic) {
		map.put(KeyEvent.VK_LEFT, new MoveLeftCommand(logic));
		map.put(KeyEvent.VK_RIGHT, new MoveRightCommand(logic));
		map.put(KeyEvent.VK_DOWN, new MoveDownCommand(logic));
	}
	*/

	/**
	 * The game key configuration, used by the keyboard handler.
	 * @return 	a map with key codes as keys and command objects as values
	 */
	public Map<Integer, Command> getKeymap() {
		return keymap;
	}

	/**
	 * Sets the key configuration.
	 * @param keymap 	the new key map to use
	 */
	public void setKeymap(Map<Integer, Command> keymap) {
		this.keymap = keymap;
	}

	/**
	 *
	 * @return	difficulty level
	 */
	public DifficultyLevel getDifficulty() {
		return difficulty;
	}

	/**
	 *
	 * @return game area width
	 */
	public int getGridWidth() {
		return gridWidth;
	}

	/**
	 *
	 * @return game area height
	 */
	public int getGridHeight() {
		return gridHeight;
	}

}
