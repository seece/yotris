
package com.lofibucket.yotris.util.command;

import com.lofibucket.yotris.logic.GameLogic;


public class NoneCommand extends Command {
	public NoneCommand() {
	}

	@Override
	public void apply(GameLogic logic) {
		System.out.println("doing nothing");
	}


}