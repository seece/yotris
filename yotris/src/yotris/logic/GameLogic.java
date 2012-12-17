package yotris.logic;
import yotris.logic.GameState;
import yotris.ui.UserInterface;

public class GameLogic {
	private UserInterface ui;

	public GameLogic(UserInterface ui)	 {
		this.ui = ui;
	}

	public GameState update() {
		GameState state = new GameState(true);	
		state.running = false;

		return state;
	}
}
