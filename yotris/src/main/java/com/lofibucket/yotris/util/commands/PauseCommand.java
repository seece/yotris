
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


public class PauseCommand extends Command {

	@Override
	public void apply(GameLogic logic) {
		System.out.println("Pause");
	}

}
