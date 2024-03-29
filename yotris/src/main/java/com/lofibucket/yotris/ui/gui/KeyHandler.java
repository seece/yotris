
package com.lofibucket.yotris.ui.gui;

import com.lofibucket.yotris.ui.CommandContainer;
import com.lofibucket.yotris.util.Settings;
import com.lofibucket.yotris.util.command.Command;
import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.util.Map;

/**
 *	Catches the game key presses. In the keyboard layout, each key press has 
 * been mapped to one
 * command that gets added to the command queue.
 */
public class KeyHandler implements KeyEventDispatcher {
	/**
	 * The command list to add new commands to.
	 */
	private CommandContainer container;
	/**
	 * Current game settings.
	 */
	private Settings settings;

	/**
	 * Default constructor.
	 * @param container	The CommandContainer where new commands are pushed.
	 * @param settings	Current settings to use (includes key layout)
	 */
	public KeyHandler(CommandContainer container, Settings settings) {
		super();
		this.container = container;
		this.settings = settings;
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		Map<Integer, Command> keymap = settings.getKeymap();

		if (e.getID() == KeyEvent.KEY_PRESSED) {
			if (!keymap.containsKey(e.getKeyCode())) {
				return false;
			}

			container.addNewCommand(keymap.get(e.getKeyCode()));
			return true;	// no further action please
		}		

		return false;
	}

}
