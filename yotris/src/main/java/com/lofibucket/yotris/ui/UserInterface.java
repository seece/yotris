package com.lofibucket.yotris.ui;

import java.util.Observer;

/**
 * The main User Interface interface GameLogic expects.
 */
public interface UserInterface extends Observer, CommandContainer {
	//public ArrayList<Command> getNewCommands();
	public void start();
	public void stop();
}
