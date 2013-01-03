package com.lofibucket.yotris.logic;
import com.lofibucket.yotris.util.commands.Command;
import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.util.Settings;
import com.lofibucket.yotris.util.TileColor;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

/**
 *	The main logic class. Takes care of the falling piece movement & collisions.
 */
public final class GameLogic extends Observable {
	private UserInterface ui;
	//private GameGrid grid;
	private GameField field;
	private Settings settings;
	//private Piece fallingPiece;
	private int score;
	private int frames = 0;
	private boolean running;
	
	/**
	 *
	 * @param ui	The user interface to update changes to
	 * @param settings	settings for the current session
	 */
	public GameLogic(UserInterface ui, Settings settings)	 {
		super();
		this.ui = ui;
		this.settings = settings;
		this.reset(settings);

		addObserver(ui);
	}

	/**
	 * Resets the game state
	 * @param settings the settings to use for this session
	 */
	public void reset(Settings settings) {
		//this.grid = new GameGrid(settings.getGridWidth(), settings.getGridHeight());	
		this.settings = settings;
		running = true;
		//fallingPiece = null;
		score = 0;
		frames = 0;

		field = new GameField(settings);

		GameState state = getGameState();
		setChanged();
		notifyObservers(state);

		if (settings.debugEnabled())  {
			System.out.println("Game settings reset.");
		}
	}

	/**
	 *	Runs one cycle of the game.
	 * @return	state of the game after this step.
	 */
	public GameState update(List<Command> commands) {
		frames++;
		applyCommands(commands);
		field.updateFallingPiece();
		
		GameState state = getGameState();
		setChanged();
		notifyObservers(state);

		return state;
	}

	private void applyCommands(List<Command> commands) {
		for (Command command : commands) {
			command.apply(this);
		}

		commands.clear();
	}

	/**
	 *	Builds a GameState object of the current GameLogic state.	
	 * @return current game state
	 */
	public GameState getGameState() {
		GameState state = new GameState(true);	
		state.running = this.running;

		Grid renderGrid = field.getRenderGrid();
		state.renderGrid = renderGrid;
		state.score = this.score;

		return state;
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

	/**
	 * Quits the game.
	 */
	public void endGame() {
		this.running = false;
	}

	/**
	 * Rotates the falling piece clockwise.
	 */
	public void rotateFallingPiece() {
		field.rotateFallingPiece();
	}

	/**
	 * Moves the currently falling piece. 
	 * @param offset The amount and direction to move the piece.
	 */
	public void moveFallingPiece(Position offset) {
		field.moveFallingPiece(offset);
	}

}
