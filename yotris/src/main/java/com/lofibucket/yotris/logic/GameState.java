
package com.lofibucket.yotris.logic;

/**
 * A game state container. Used to transmit updated state to the User Interface.
 */
public class GameState {
	/**
	 * Is the game running or not.
	 */
	public boolean running;
	/**
	 * Is the game in paused state?
	 */
	public boolean paused;
	/**
	 * Has the player lost the game (or just started it)
	 */
	public boolean gameover;
	/**
	 * The game grid with the currently falling piece plotted in.
	 */
	public Grid renderGrid;
	/**
	 * Players score.
	 */
	public int score;
	/**
	 * How many frames have been simulated.
	 */
	public int frames;
	/**
	 * On which level the player is currently on. Gets higher as the score 
	 * increases.
	 */
	public int level;

	/**
	 * A copy constructor.
	 * @param other the other state to use as base
	 */
	public GameState(GameState other) {
		this.running = other.running;
		this.paused = other.paused;
		this.gameover = other.gameover;
		this.renderGrid = other.renderGrid;
		this.score = other.score;
		this.frames = other.frames;
		this.level = other.level;
	}

	/**
	 * Constructor with the given running state as default.
	 * @param running 	is the game running or not
	 */
	public GameState(boolean running) {
		this.running = running;
		this.gameover = false;
		this.frames = 0;
		this.paused = false;
	}

	/**
	 * Tells is the game is running.
	 * @return 
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Sets the game running state.
	 * @param running 
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	/**
	 * Returns a game field where the currently falling piece is plotted in.
	 * @return the tile grid to render
	 */
	public Grid getRenderGrid() {
		return renderGrid;
	}

	/**
	 * Sets the render grid stored in this state object.
	 * @param renderGrid 
	 */
	public void setRenderGrid(Grid renderGrid) {
		this.renderGrid = renderGrid;
	}

	/**
	 * Toggles pause state.
	 */
	public void togglePause() {
		paused = !paused;
	}

}
