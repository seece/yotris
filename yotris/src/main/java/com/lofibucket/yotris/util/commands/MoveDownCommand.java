
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


public class MoveDownCommand extends Command {
	public MoveDownCommand(GameLogic logic) {
		super(logic);
	}

	@Override
	public void apply() {
		System.out.println("moving Down");
	}


}
