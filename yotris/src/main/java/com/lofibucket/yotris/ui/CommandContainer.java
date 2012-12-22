package com.lofibucket.yotris.ui;

import com.lofibucket.yotris.util.commands.Command;
import java.util.ArrayList;

/**
 *	Describes an interface to a class that can contain commands.
 */
public interface CommandContainer {
	public void addNewCommand(Command c);
	public ArrayList<Command> getNewCommands();
}
