
package com.lofibucket.yotris.ui.gui.action;

import com.lofibucket.yotris.ui.CommandContainer;
import java.awt.event.ActionListener;

/**
 *	An ActionListener that requires a reference to a CommandContainer as a 
 * constructor parameter. Used with menu controls that issue commands to the
 * GameLogic.
 */
abstract public class CommandActionListener implements ActionListener {
	protected CommandContainer container;

	public CommandActionListener(CommandContainer container) {
		this.container = container;
	}
}
