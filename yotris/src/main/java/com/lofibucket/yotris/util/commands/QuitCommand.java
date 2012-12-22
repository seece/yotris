
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


public class QuitCommand extends Command {

	public QuitCommand(GameLogic gamelogic) {
		super(gamelogic);
	}

	@Override
	public void apply() {
		System.out.println("game should end now");
	}


}
