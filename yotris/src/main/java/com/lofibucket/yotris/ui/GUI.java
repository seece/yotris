package com.lofibucket.yotris.ui;

import java.util.Observable;
import com.lofibucket.yotris.logic.GameState;

public class GUI implements UserInterface {

	@Override
	public void update(Observable obs, Object arg) {
		GameState state = (GameState)arg;
	}
	
}
