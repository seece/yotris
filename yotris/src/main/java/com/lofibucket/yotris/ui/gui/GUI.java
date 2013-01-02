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
	private JFrame frame;
	private JMenuBar menubar;
	private JMenu gameMenu;
	private Settings settings;
	private GameArea area;
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

		area.setRenderGrid(state.getRenderGrid());

		area.repaint();
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
		frame = new JFrame("yotris " + settings.getVersion());
		frame.setPreferredSize(new Dimension(400, 550));
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		.addKeyEventDispatcher(new KeyHandler(this, settings));
		
		createComponents(frame.getContentPane());
		createMenu(frame);
		
		frame.pack();
		frame.setVisible(true);	
	}

	@Override
	public void start() {
		run();
	}

	@Override
	public void stop() {
		frame.setVisible(false);
	}

	private void createComponents(Container container) {
		//container.addKeyListener(keylistener);
		area = new GameArea(null);
		container.add(area, BorderLayout.CENTER);
		
		JLabel teksti = new JLabel("labell!");
        container.add(teksti, BorderLayout.LINE_END);
	}

	private void createMenu(JFrame frame) {
		menubar = new JMenuBar();
		gameMenu = new JMenu("Game");
		menubar.add(gameMenu);

		JMenuItem startItem = new JMenuItem("New game");
		JMenuItem quitItem = new JMenuItem("Quit");

		startItem.getAccessibleContext().setAccessibleDescription(
				"Start a new game");
		startItem.setMnemonic(KeyEvent.VK_N);
		quitItem.setMnemonic(KeyEvent.VK_Q);

		startItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_N, ActionEvent.ALT_MASK));

		gameMenu.add(startItem);
		gameMenu.add(quitItem);

		startItem.addActionListener(new NewGameActionListener(this));
		quitItem.addActionListener(new QuitActionListener(this));

		frame.setJMenuBar(menubar);
	}

	@Override
	public void addNewCommand(Command c) {
		this.commandlist.add(c);
	}

}

