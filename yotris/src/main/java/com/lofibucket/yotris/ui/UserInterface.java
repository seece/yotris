package com.lofibucket.yotris.ui;

import com.lofibucket.yotris.util.commands.Command;
import java.util.ArrayList;
import java.util.Observer;

public interface UserInterface extends Observer {
	public ArrayList<Command> getNewCommands();
	public void start();
}
