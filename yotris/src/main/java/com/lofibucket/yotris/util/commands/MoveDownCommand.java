
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


public class MoveDownCommand extends Command {
	public MoveDownCommand() {
	}

	@Override
	public void apply(GameLogic logic) {
		System.out.println("moving Down");
	}


}
