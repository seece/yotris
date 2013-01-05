
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.util.Settings;


public class GameLogicMock extends GameLogic {
	public boolean ended;
	
	public GameLogicMock(UserInterface ui, Settings settings) {
		super(ui, settings);
		ended = false;
	}

	@Override
	public void endGame() {
		ended = true;
	}
	
}
