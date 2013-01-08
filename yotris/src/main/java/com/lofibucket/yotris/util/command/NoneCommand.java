
package com.lofibucket.yotris.util.command;

import com.lofibucket.yotris.logic.GameLogic;

/**
 * A dummy command that does nothing.
 */
public class NoneCommand extends Command {
	public NoneCommand() {
	}

	@Override
	public void apply(GameLogic logic) {
	}


}
