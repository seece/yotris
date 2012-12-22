
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


public class NoneCommand extends Command {
	public NoneCommand(GameLogic logic) {
		super(logic);
	}

	@Override
	public void apply() {
		System.out.println("doing nothing");
	}


}
