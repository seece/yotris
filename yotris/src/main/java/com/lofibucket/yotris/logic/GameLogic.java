package com.lofibucket.yotris.logic;
import com.lofibucket.yotris.util.commands.Command;
import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.util.Settings;
import com.lofibucket.yotris.util.TileColor;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

/**
 *	The main logic class. Takes care of the falling piece movement & collisions.
 */
public class GameLogic extends Observable {
	private UserInterface ui;
	private Grid grid;
	private Settings settings;
	private Piece fallingPiece;
	private int score;
	private int frames = 0;
	private ZeroBasedCounter pieceFallCounter;
	private boolean running;
	
	/**
	 *
	 * @param ui	The user interface to update changes to
	 * @param settings	settings for the current session
	 */
	public GameLogic(UserInterface ui, Settings settings)	 {
		this.ui = ui;
		this.settings = settings;
		this.reset(settings);

		addObserver(ui);
	}

	private void reset(Settings settings) {
		this.grid = new Grid(settings.getGridWidth(), settings.getGridHeight());	
		running = true;
		fallingPiece = null;
		pieceFallCounter = new ZeroBasedCounter(0, 10);
		score = 0;
		frames = 0;

		GameState state = getGameState();
		notifyObservers(state);
	}

	/**
	 *	Runs one cycle of the game.
	 * @return	state of the game after this step.
	 */
	public GameState update(ArrayList<Command> commands) {
		frames++;
		updateFallingPiece();
		
		GameState state = getGameState();
		notifyObservers(state);

		return state;
	}

	private void updateFallingPiece() {
		pieceFallCounter.decrease();

		if (pieceFallCounter.isZero()) {
			if (fallingPiece == null) {
				spawnPiece();
			} else {
				fallingPiece.moveDown();
			}
		}
	}

	private void spawnPiece() {
		Position center = new Position(grid.getWidth()/2, 0);
		fallingPiece = new Piece(getRandomTetrimino(), getRandomColor(), center);

		if (grid.checkIntersection(fallingPiece)) {
			running = false;
			// TODO broadcast a gameover message?
		}
	}

	private TileColor getRandomColor() {
		TileColor[] colors;
		int choice;

		colors = TileColor.class.getEnumConstants();

		Random r = new Random();
		choice = r.nextInt(colors.length);

		return colors[choice];
	}

	private boolean[][] getRandomTetrimino() {
		return Tetrimino.O;	// TODO add proper random here
	}

	/**
	 *	Builds a GameState object of the current GameLogic state.	
	 * @return current game state
	 */
	public GameState getGameState() {
		GameState state = new GameState(true);	
		state.running = this.running;

		Grid renderGrid = getRenderGrid();
		state.renderGrid = renderGrid;

		return state;
	}

	/**
	 *
	 * @return
	 */
	public Grid getRenderGrid() {
		Grid renderGrid = new Grid(this.grid.getWidth(), this.grid.getHeight());
		if (fallingPiece != null) {
			renderGrid.plotPiece(fallingPiece);
		}
		return renderGrid;
	}

	/**
	 *
	 * @return	the amount of frames (update cycles) we have done
	 */
	public int getSimulatedFrames() {
		return frames;
	}

	/**
	 *
	 * @return	current settings.
	 */
	public Settings getSettings() {
		return settings;
	}

	/**
	 * Sets the current settings. Use this to change themes etc. on the fly.
	 * @param settings 	new settings to use
	 */
	public void setSettings(Settings settings) {
		this.settings = settings;
	}


}
