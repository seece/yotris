
package com.lofibucket.yotris.ui.gui.action;

import com.lofibucket.yotris.ui.CommandContainer;
import com.lofibucket.yotris.util.command.QuitCommand;
import java.awt.event.ActionEvent;

/**
 * Action listener for the Quit menu option.
 */
public class QuitActionListener extends CommandActionListener {

	public QuitActionListener(CommandContainer container) {
		super(container);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		container.addNewCommand(new QuitCommand());
	}

}
