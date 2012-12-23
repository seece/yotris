
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


public class MoveLeftCommand extends Command {
	public MoveLeftCommand() {
	}

	@Override
	public void apply(GameLogic logic) {
		System.out.println("moving left");
	}


}
