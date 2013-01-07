
package com.lofibucket.yotris.ui.gui.action;

import com.lofibucket.yotris.ui.CommandContainer;
import com.lofibucket.yotris.ui.gui.components.SettingsWindow;
import com.lofibucket.yotris.util.commands.PauseCommand;
import java.awt.event.ActionEvent;

public class ShowSettingsActionListener extends CommandActionListener {

	SettingsWindow window;

	public ShowSettingsActionListener(CommandContainer commandlist, SettingsWindow window) {
		super(commandlist);

		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// pause the game while in the settings menu
		this.container.addNewCommand(new PauseCommand());
		window.setVisible(true);	
	}

}
