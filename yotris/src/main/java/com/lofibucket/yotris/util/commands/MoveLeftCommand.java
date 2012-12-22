
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


public class MoveLeftCommand extends Command {
	public MoveLeftCommand(GameLogic logic) {
		super(logic);
	}

	@Override
	public void apply() {
		System.out.println("moving left");
	}


}
