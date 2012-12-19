
package com.lofibucket.yotris.util;
import com.lofibucket.yotris.util.DifficultyLevel;

/**
 *
 * @author pekkavaa
 */
public class Settings {
	private DifficultyLevel difficulty;
	private int gridWidth;
	private int gridHeight;

	/**
	 * The constructor with no parameters initialises the default settings. 
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
