
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


public class MoveRightCommand extends Command {
	public MoveRightCommand(GameLogic logic) {
		super(logic);
	}

	@Override
	public void apply() {
		System.out.println("moving Right");
	}


}
