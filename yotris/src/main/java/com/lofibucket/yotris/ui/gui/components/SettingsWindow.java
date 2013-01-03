
package com.lofibucket.yotris.ui.gui.components;

import java.awt.Dimension;
import javax.swing.JFrame;


public class SettingsWindow extends JFrame {
	public SettingsWindow() {
		super("Settings");

		setPreferredSize(new Dimension(400, 400));
		setResizable(false);
		pack();
	}
}
