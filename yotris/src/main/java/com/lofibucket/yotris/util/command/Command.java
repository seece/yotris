package com.lofibucket.yotris.util.command;

import com.lofibucket.yotris.logic.GameLogic;


/**
 * A command class that is passed from the UserInterface to the GameLogic
 * for processing. Used to minimize dependencies between UI and logic two.
 */
abstract public class Command implements Applyable {
 
	public Command() {}

	/**
	 * Applies this command.
	 * @param logic The GameLogic object to modify with this command.
	 */
	@Override
	abstract public void apply(GameLogic logic); 

	/**
	 * Tells if this command should run even if the game is paused.
	 * @return true if this command should run when paused, otherwise false
	 */
	@Override
	public boolean overridePause() {
		return false;
	}

	@Override
	public boolean overrideGameOver() {
		return false;
	}

}