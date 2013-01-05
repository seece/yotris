
package com.lofibucket.yotris.logic;

public class GameState {
	public boolean running;
	public boolean paused;
	public boolean gameover;
	public Grid renderGrid;
	public int score;
	public int frames;
	public int level;

	public GameState(boolean running) {
		this.running = running;
		this.gameover = false;
		this.frames = 0;
		this.paused = false;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public Grid getRenderGrid() {
		return renderGrid;
	}

	public void setRenderGrid(Grid renderGrid) {
		this.renderGrid = renderGrid;
	}

	public void togglePause() {
		paused = !paused;
	}

}
