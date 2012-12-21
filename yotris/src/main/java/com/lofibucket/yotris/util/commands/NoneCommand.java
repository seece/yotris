
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


public class NoneCommand implements Command {

	@Override
	public void apply(GameLogic gamelogic) {
		return;
	}
	
}
