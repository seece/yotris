package com.lofibucket.yotris.ui;

import java.util.Observer;

/**
 * The main User Interface interface the GameLogic class expects.
 */
public interface UserInterface extends Observer, CommandContainer {

	/**
	 * Starts the UI.
	 */
	public void start();

	/**
	 * Stops the UI. Usually called when the game is ending.
	 */
	public void stop();

	/**
	 * Resets the UI state. Called between successive games.
	 */
	public void reset();
	
}
