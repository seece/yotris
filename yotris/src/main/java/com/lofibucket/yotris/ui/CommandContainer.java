package com.lofibucket.yotris.ui;

import com.lofibucket.yotris.util.commands.Command;
import java.util.List;

/**
 *	Describes an interface to a class that can contain a command queue.
 */
public interface CommandContainer {
	public void addNewCommand(Command c);
	public List<Command> pollCommands();
}
