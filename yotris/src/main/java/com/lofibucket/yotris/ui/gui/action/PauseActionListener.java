
package com.lofibucket.yotris.ui.gui.action;

import com.lofibucket.yotris.ui.CommandContainer;
import com.lofibucket.yotris.util.command.TogglePauseCommand;
import java.awt.event.ActionEvent;


/**
 * Command listener for the Pause menu option.
 */
public class PauseActionListener extends CommandActionListener {

	public PauseActionListener(CommandContainer container) {
		super(container);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.container.addNewCommand(new TogglePauseCommand());
	}
}
