
package com.lofibucket.yotris.ui.gui.menu;

import com.lofibucket.yotris.ui.CommandContainer;
import java.awt.event.ActionListener;

/**
 *	An ActionListener that requires a reference to a CommandContainer as a 
 * constructor parameter.
 */
abstract public class CommandActionListener implements ActionListener {
	CommandContainer container;

	public CommandActionListener(CommandContainer container) {
		this.container = container;
	}
}
