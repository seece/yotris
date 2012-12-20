package com.lofibucket.yotris.logic;
import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.util.Settings;
import java.util.Observable;

public class GameLogic extends Observable {
	private UserInterface ui;
	private Grid grid;
	private Settings settings;
	private Piece fallingPiece;
	private int score;
	private int frames = 0;
	
	public GameLogic(UserInterface ui, Settings settings)	 {
		this.ui = ui;
		this.settings = settings;
		this.reset(settings);

		addObserver(ui);
	}

	private void reset(Settings settings) {
		this.grid = new Grid(settings.getGridWidth(), settings.getGridHeight());	
		fallingPiece = null;
		score = 0;
		frames = 0;

		GameState state = getGameState();
		notifyObservers(state);
	}

	public GameState update() {
		frames++;
		
		GameState state = getGameState();
		notifyObservers(state);

		return state;
	}

	public GameState getGameState() {
		GameState state = new GameState(true);	
		state.running = false;

		Grid renderGrid = getRenderGrid();
		state.renderGrid = renderGrid;

		return state;
	}

	public Grid getRenderGrid() {
		Grid renderGrid = new Grid(this.grid.getWidth(), this.grid.getHeight());
		if (fallingPiece != null) {
			renderGrid.plotPiece(fallingPiece);
		}
		return renderGrid;
	}

	public int getSimulatedFrames() {
		return frames;
	}

	public Settings getSettings() {
		return settings;
	}
}
