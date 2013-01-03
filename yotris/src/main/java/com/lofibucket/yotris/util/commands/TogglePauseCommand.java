
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


public class TogglePauseCommand extends Command {

	@Override
	public void apply(GameLogic logic) {
		System.out.println("Togglepause");
	}

}
