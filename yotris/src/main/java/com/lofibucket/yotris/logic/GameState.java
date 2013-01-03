
package com.lofibucket.yotris.logic;

public class GameState {
	public boolean running;
	public Grid renderGrid;
	public int score;

	public GameState(boolean running) {
		this.running = running;
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
