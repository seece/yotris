
package com.lofibucket.yotris.ui.gui;

import com.lofibucket.yotris.util.Settings;
import com.lofibucket.yotris.util.commands.Command;
import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Map;

public class KeyHandler implements KeyEventDispatcher {
	private ArrayList<Command> commandlist;
	private Settings settings;

	public KeyHandler(ArrayList<Command> commandlist, Settings settings) {
		super();
		this.commandlist = commandlist;
		this.settings = settings;
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		Map<Integer, Command> keymap = settings.getKeymap();

		if (e.getID() == KeyEvent.KEY_PRESSED) {
			System.out.println("key pressed: " + e.getKeyCode());
		}		

		//System.out.println("Got key event! " + e.getKeyCode() + " " +e.getID() );
		return false;
	}

}
