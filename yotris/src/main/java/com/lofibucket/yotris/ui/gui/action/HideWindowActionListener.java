
package com.lofibucket.yotris.ui.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


/**
 * Hides the given window when activated.
 */
public class HideWindowActionListener implements ActionListener {
	private JFrame frame;

	public HideWindowActionListener(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
	}

}
