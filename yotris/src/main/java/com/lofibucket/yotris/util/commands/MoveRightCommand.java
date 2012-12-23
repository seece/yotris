
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


public class MoveRightCommand extends Command {
	public MoveRightCommand() {
	}

	@Override
	public void apply(GameLogic logic) {
		System.out.println("moving Right");
	}


}
