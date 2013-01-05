
package com.lofibucket.yotris.ui.gui.components;

import com.lofibucket.yotris.logic.GameLogic;
import com.lofibucket.yotris.ui.CommandContainer;
import com.lofibucket.yotris.util.Settings;
import com.lofibucket.yotris.util.commands.UnpauseCommand;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;


public class SettingsWindow extends JFrame implements WindowListener {
	private CommandContainer container;
	private Settings settings;

	public SettingsWindow(CommandContainer container, Settings settings) {
		super("Settings");

		this.container = container;
		this.settings = settings;

		addWindowListener(this);

		setPreferredSize(new Dimension(400, 400));
		setResizable(false);
		pack();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		container.addNewCommand(new UnpauseCommand());
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	
}
