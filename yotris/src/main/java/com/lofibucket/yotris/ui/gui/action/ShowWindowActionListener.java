
package com.lofibucket.yotris.ui.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ShowWindowActionListener implements ActionListener {
	private JFrame window;

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
