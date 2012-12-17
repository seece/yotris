
package yotris.util;
import yotris.util.DifficultyLevel;

public class Settings {
	private DifficultyLevel difficulty;
	private int gridWidth;
	private int gridHeight;

	public Settings() {
		// the default settings
		this(DifficultyLevel.EASY, 10, 20);
	}

	public Settings(DifficultyLevel difficulty, int gridWidth, int gridHeight) {
		this.difficulty = difficulty;
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
	}

	public DifficultyLevel getDifficulty() {
		return difficulty;
	}

	public int getGridWidth() {
		return gridWidth;
	}

	public int getGridHeight() {
		return gridHeight;
	}

}
