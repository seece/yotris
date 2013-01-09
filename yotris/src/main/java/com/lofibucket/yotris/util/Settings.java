
package com.lofibucket.yotris.util;
import com.lofibucket.yotris.logic.Position;
import com.lofibucket.yotris.ui.gui.Theme;
import com.lofibucket.yotris.util.command.Command;
import com.lofibucket.yotris.util.command.MoveCommand;
import com.lofibucket.yotris.util.command.RotateCommand;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Holds all game settings.
 */
public class Settings {
	/**
	 * The game area width, in tiles.
	 */
	private int gridWidth;
	/**
	 * The game area height, in tiles.
	 */
	private int gridHeight;
	/**
	 * Current game version. 
	 */
	private String version;
	/**
	 * Is the debug mode (more verbose logging) enabled.
	 */
	private boolean debug;
	/**
	 * The keyboard layout configuration.
	 */
	private Map<Integer, Command> keymap;
	/**
	 * How fast do want the game to run.
	 */
	private double targetFPS;
	/**
	 * The theme to use.
	 */
	private Theme theme;

	/**
	 * The constructor with no parameters initializes the default settings. 
	 */
	public Settings() {
		// default settings
		this(10, 20);
	}

	/**
	 * The main constructor.
	 * @param gridWidth	The game area width in tiles
	 * @param gridHeight	The game are height in tiles
	 */
	public Settings(int gridWidth, int gridHeight) { 
		this.version = "0.7";
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
		this.keymap = new HashMap<>();
		this.debug = false;
		this.targetFPS = 30.0;
		this.theme = new Theme();

	}

	/**
	 * Enable debug flag.
	 */
	public void enableDebug() {
		this.debug = true;
	}

	/**
	 * Disable debug flag.
	 */
	public void disableDebug() {
		this.debug = false;
	}

	/**
	 * Checks if debug feature is enabled.
	 * @return the state of the debug flag
	 */
	public boolean debugEnabled() {
		return debug;
	}

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

	/**
	 * The version string of this version of the game.
	 * @return this build version as string
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Calculates the time to wait in the main loop to achieve the target FPS.
	 * Just an approximation since it doesn't take the actual game loop 
	 * running time into account.
	 * @return the delay in milliseconds
	 */
	public long getFrameDelay() {
		return (long)(1000.0/this.targetFPS);
	}

	/**
	 * Returns the default key layout.
	 * @return the default layout
	 */
	public static Map<Integer, Command> getDefaultLayout() {
		Map<Integer, Command> map = new HashMap<>();

		map.put(KeyEvent.VK_LEFT, 	new MoveCommand(new Position(-1, 0)));
		map.put(KeyEvent.VK_RIGHT, 	new MoveCommand(new Position( 1, 0)));
		map.put(KeyEvent.VK_DOWN, 	new MoveCommand(new Position( 0, 1)));
		map.put(KeyEvent.VK_UP, 	new RotateCommand());

		return map;
	}

	/**
	 * The current theme
	 * @return the active Theme instance
	 */
	public Theme getTheme() {
		return theme;
	}

	/**
	 * Set the active theme
	 * @param theme the Theme instance to use
	 */
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
}
