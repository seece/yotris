package com.lofibucket.yotris.ui.gui;

import com.lofibucket.yotris.logic.GameLogic;
import com.lofibucket.yotris.logic.GameState;
import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.ui.gui.menu.NewGameActionListener;
import com.lofibucket.yotris.ui.gui.menu.QuitActionListener;
import com.lofibucket.yotris.util.Settings;
import com.lofibucket.yotris.util.commands.Command;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

public class GUI implements UserInterface, Runnable {

	private List<Command> commandlist;
	private MainWindow mainwindow;
	private Settings settings;

	private int tilesize = 18;

	public GUI(Settings settings) {
		super();
		commandlist = Collections.synchronizedList(new ArrayList<Command>());
		this.settings = settings;
	}
	
	/**
	 * Updates the UserInterface state.
	 * @param obs	The source object notifying for changes.
	 * @param arg	Additional argument (in this case {@link GameState})
	 */
	@Override
	public void update(Observable obs, Object arg) {
		GameLogic logic = (GameLogic)obs;
		GameState state = (GameState)arg;

		mainwindow.updateState(state);


		//System.out.println("GUI updates: " + logic.getSimulatedFrames());
	}

	/**
	 * Returns the accumulated commands and then clears the list.
	 * @return the accumulated command objects
	 */
	@Override
	public List<Command> pollCommands() {
		return commandlist;
	}

	@Override
	public void run() {
		mainwindow = new MainWindow(settings, this);

		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		.addKeyEventDispatcher(new KeyHandler(this, settings));
		
		mainwindow.pack();
		mainwindow.setVisible(true);	
	}

	@Override
	public void start() {
		run();
	}

	@Override
	public void stop() {
		mainwindow.setVisible(false);
	}

	@Override
	public void addNewCommand(Command c) {
		this.commandlist.add(c);
	}
}
