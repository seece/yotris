package com.lofibucket.yotris.ui;

import com.lofibucket.yotris.util.commands.Command;
import java.util.List;

/**
 *	Describes a class that can contain a command queue.
 */
public interface CommandContainer {
	/**
	 * Adds a new command to this queue.
	 * @param c the new command to add
	 */
	public void addNewCommand(Command c);
	/**
	 * Returns a list of accumulated commands.
	 * @return new commands
	 */
	public List<Command> pollCommands();
}
