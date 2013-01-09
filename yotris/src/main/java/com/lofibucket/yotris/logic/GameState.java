
package com.lofibucket.yotris.logic;

/**
 * A game state container. Used to transmit updated state to the User Interface.
 */
public class GameState {
	public boolean running;
	public boolean paused;
	public boolean gameover;
	public Grid renderGrid;
	public int score;
	public int frames;
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
