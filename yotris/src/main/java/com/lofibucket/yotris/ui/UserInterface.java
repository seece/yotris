package com.lofibucket.yotris.ui;

import java.util.Observer;

public interface UserInterface extends Observer, CommandContainer {
	//public ArrayList<Command> getNewCommands();
	public void start();
}
