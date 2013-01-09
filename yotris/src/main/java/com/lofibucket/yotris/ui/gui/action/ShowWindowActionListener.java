
package com.lofibucket.yotris.ui.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Action listener that shows a given window when activated. 
 */
public class ShowWindowActionListener implements ActionListener {
	/**
	 * the specific window to show
	 */
	private JFrame window;

	/**
	 * Constructor taking a window as a parameter.
	 * @param window the window to show when activated
	 */
	public ShowWindowActionListener(JFrame window) {
		this.window = window;			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!window.isVisible()) {
			window.setVisible(true);
		}
	}

}
