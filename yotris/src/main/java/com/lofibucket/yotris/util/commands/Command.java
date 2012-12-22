
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


abstract public class Command implements Applyable {
	protected GameLogic gamelogic;

	public Command(GameLogic gamelogic) {
		this.gamelogic = gamelogic;
	}

	@Override
	abstract public void apply(); 
}
