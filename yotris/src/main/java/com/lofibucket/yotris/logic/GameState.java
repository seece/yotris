
package com.lofibucket.yotris.logic;

public class GameState {
	public boolean running;
	public boolean gameover;
	public Grid renderGrid;
	public int score;
	public int frames;

	public GameState(boolean running) {
		this.running = running;
		this.gameover = false;
		this.frames = 0;
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

}
