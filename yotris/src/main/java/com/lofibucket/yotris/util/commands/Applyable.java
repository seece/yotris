
package com.lofibucket.yotris.util.commands;

import com.lofibucket.yotris.logic.GameLogic;

/**
 *	An interface used in command classes. Apply method is used to apply command
 * changes.
 */
public interface Applyable {

	/**
	 * 	Applies a command.
	 * @param logic 	The GameLogic object to apply the command to.
	 */	
	public void apply(GameLogic logic);

	/**
	 * Pause override flag.
	 * @return true if this command must me applied even when the game is paused
	 * otherwise false
	 */
	public boolean overridePause();
}
