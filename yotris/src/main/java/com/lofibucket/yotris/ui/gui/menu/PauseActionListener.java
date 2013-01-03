
package com.lofibucket.yotris.ui.gui.menu;

import com.lofibucket.yotris.ui.CommandContainer;
import com.lofibucket.yotris.util.commands.TogglePauseCommand;
import java.awt.event.ActionEvent;


public class PauseActionListener extends CommandActionListener {

	public PauseActionListener(CommandContainer container) {
		super(container);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.container.addNewCommand(new TogglePauseCommand());
	}

}
