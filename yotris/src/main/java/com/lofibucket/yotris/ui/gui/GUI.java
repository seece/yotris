package com.lofibucket.yotris.ui.gui;

import com.lofibucket.yotris.logic.GameLogic;
import com.lofibucket.yotris.logic.GameState;
import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.util.Settings;
import com.lofibucket.yotris.util.commands.Command;
import com.lofibucket.yotris.util.commands.NoneCommand;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class GUI implements UserInterface, Runnable {

	private ArrayList<Command> commandlist;
	private JFrame frame;
	private Settings settings;

	public GUI(Settings settings) {
		super();
		commandlist = new ArrayList<>();
		this.settings = settings;
	}
	
	@Override
	public void update(Observable obs, Object arg) {
		GameLogic logic = (GameLogic)obs;
		GameState state = (GameState)arg;
		//System.out.println("GUI updates: " + logic.getSimulatedFrames());
	}

	@Override
	public ArrayList<Command> getNewCommands() {

		return commandlist;
	}

	@Override
	public void run() {
		frame = new JFrame("yotris");
		frame.setPreferredSize(new Dimension(200, 100));
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		.addKeyEventDispatcher(new KeyHandler(this.commandlist, settings));
		
		luoKomponentit(frame.getContentPane());
		
		frame.pack();
		frame.setVisible(true);	
	}

	@Override
	public void start() {
		run();
	}

	private void luoKomponentit(Container container) {
		//container.addKeyListener(keylistener);
		JLabel teksti = new JLabel("Tekstikenttä!");
        container.add(teksti);
	}
	
}
