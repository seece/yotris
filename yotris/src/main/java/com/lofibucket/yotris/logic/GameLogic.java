package com.lofibucket.yotris.logic;
import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.util.Settings;
import com.lofibucket.yotris.util.commands.Command;
import com.lofibucket.yotris.util.commands.TogglePauseCommand;
import com.lofibucket.yotris.util.commands.UnpauseCommand;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

/**
 *	The main logic class. Keeps the game running.
 */
public class GameLogic extends Observable {
	private UserInterface ui;
	private GameField field;
	private Settings settings;
	private GameState state;
	
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
		this.settings = settings;
		this.state = new GameState(true);
		this.state.running = true;
		this.state.score = 0;
		this.state.frames = 0;

		field = new GameField(settings);

		//GameState state = getGameState();
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
		applyCommands(commands);

		if (!state.paused && !state.gameover) {
			updateGame();
		}
		
		setChanged();
		notifyObservers(getGameState());

		return state;
	}

	private void updateGame() {
		state.frames++;
		field.updateFallingPiece(this);
		increaseScore(field.clearLines());	
		state.level = getLevel();
		field.updateCounterLimit(state.level);

		if (state.gameover) {
			field.fallingPiece = null;
		}
	}

	/**
	 * Increases the player score with the given multiplier.
	 * @param multiplier how many lines were cleared simultaneously
	 */
	public void increaseScore(int multiplier) {
		if (multiplier == 0) {
			return;
		}

		state.score += 110 * Math.pow(multiplier, 1.6);
	}

	/**
	 *  A slight score increase.
	 */
	public void increaseScoreHitBottom() {
		state.score += 12;
	}

	/**
	 * Applies every command in a command list.
	 * @param commands The list of command to apply
	 */
	private void applyCommands(List<Command> commands) {
		synchronized(commands) {
			Iterator<Command> it = commands.iterator();

			while (it.hasNext()) {
				Command command = it.next();

				// only allow the select few commands when paused
				if (state.paused && !command.overridePause()) {
					continue;
				}

				// the same thing for game over
				if (state.gameover && !command.overrideGameOver()) {
					continue;
				}

				command.apply(this);
			}

			commands.clear();
		}
	}

	/**
	 *	Builds a GameState object of the current GameLogic state.	
	 * @return current game state
	 */
	public GameState getGameState() {
		state.renderGrid = field.getRenderGrid();

		return state;
	}

	/**
	 *
	 * @return	the amount of frames (update cycles) we have done
	 */
	public int getSimulatedFrames() {
		return state.frames;
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
	public void quitGame() {
		//state.gameover = true;
		state.running = false;
	}

	/**
	 * Ends the current game.
	 */
	public void endGame() {
		state.gameover = true;

		if (settings.debugEnabled()) {
			System.out.println("Game Over!");
		}
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

	/**
	 * How long (in milliseconds) do we wait in the main loop. This changes
	 * as the game advances to make the game faster.
	 * @return delay in milliseconds
	 */
	public long getFrameDelay() {
		return settings.getFrameDelay();
	}

	/**
	 * Game level getter. Game level affects game running speed.
	 * @return The current game level
	 */
	public int getLevel() {
		double partialLevel = 0.001 + Math.pow((double)state.score, 0.9) / 200.0;
		return (int)Math.ceil(partialLevel);
	}

	/**
	 * Pauses the game.
	 */
	public void pauseGame() {
		state.paused = true;
	}

	/**
	 * Continues the game.
	 */
	public void unPauseGame() {
		state.paused = false;
	}
}
