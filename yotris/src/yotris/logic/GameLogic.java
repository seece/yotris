package yotris.logic;
import java.util.Observable;
import yotris.ui.UserInterface;
import yotris.util.Settings;

public class GameLogic extends Observable {
	private UserInterface ui;
	private Grid grid;
	private Settings settings;
	private Piece fallingPiece;
	private int score;
	
	public GameLogic(UserInterface ui, Settings settings)	 {
		this.ui = ui;
		this.settings = settings;
		this.reset(settings);
	}

	private void reset(Settings settings) {
		this.grid = new Grid(settings.getGridWidth(), settings.getGridHeight());	
		fallingPiece = null;
		score = 0;
	}

	public GameState update() {
		GameState state = new GameState(true);	
		state.running = false;

		return state;
	}
}
