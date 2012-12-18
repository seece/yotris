package yotris.ui;

import java.util.Observable;
import yotris.logic.GameState;

public class GUI implements UserInterface {

	@Override
	public void update(Observable obs, Object arg) {
		GameState state = (GameState)arg;
	}
	
}
