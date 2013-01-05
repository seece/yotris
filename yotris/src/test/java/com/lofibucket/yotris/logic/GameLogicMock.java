
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.util.Settings;


public class GameLogicMock implements Endable {
	public boolean ended;
	
	public GameLogicMock() {
		ended = false;
	}

	@Override
	public void endGame() {
		ended = true;
	}
	
}
