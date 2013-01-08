
package com.lofibucket.yotris.ui.gui.action;

import com.lofibucket.yotris.ui.CommandContainer;
import com.lofibucket.yotris.util.command.StartGameCommand;
import java.awt.event.ActionEvent;


/**
 *	Action listener for the "New Game" menu option.
 */
public class NewGameActionListener extends CommandActionListener {
	public NewGameActionListener(CommandContainer container) {
		super(container);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		container.addNewCommand(new StartGameCommand());
	}

}
