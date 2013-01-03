
package com.lofibucket.yotris.ui.gui.menu;

import com.lofibucket.yotris.ui.CommandContainer;
import com.lofibucket.yotris.ui.gui.SettingsWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ShowSettingsActionListener implements ActionListener {

	SettingsWindow window;
	CommandContainer commandlist;

	public ShowSettingsActionListener(CommandContainer commandlist, SettingsWindow window) {
		this.commandlist = commandlist;
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		window.setVisible(true);	
		System.out.println("ACTIOn");
	}

}
