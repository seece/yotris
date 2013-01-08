
package com.lofibucket.yotris.util.command;

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

	/**
	 * Game over override flag.
	 * @return true if this command must be applied even when the game is in
	 * game over state
	 */
	public boolean overrideGameOver();
}
