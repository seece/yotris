
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


public interface Command {
	public void apply(GameLogic gamelogic);

}
