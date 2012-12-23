
package com.lofibucket.yotris.ui.gui;

import com.lofibucket.yotris.ui.CommandContainer;
import com.lofibucket.yotris.util.Settings;
import com.lofibucket.yotris.util.commands.Command;
import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.util.Map;

public class KeyHandler implements KeyEventDispatcher {
	private CommandContainer commandlist;
	private Settings settings;

	public KeyHandler(CommandContainer commandlist, Settings settings) {
		super();
		this.commandlist = commandlist;
		this.settings = settings;
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		Map<Integer, Command> keymap = settings.getKeymap();

		if (e.getID() == KeyEvent.KEY_PRESSED) {
			if (!keymap.containsKey(e.getKeyCode())) {
				return false;
			}

			//commandlist.add(keymap.get(e.getKeyCode()));
			commandlist.addNewCommand(keymap.get(e.getKeyCode()));
			return true;	// no further action please
		}		

		return false;
	}

}
