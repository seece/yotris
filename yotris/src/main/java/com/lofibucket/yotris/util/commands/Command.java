
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;


abstract public class Command implements Applyable {

	public Command() {
	}

	@Override
	abstract public void apply(GameLogic logic); 
}
