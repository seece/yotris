
package com.lofibucket.yotris.ui.gui.components;

import com.lofibucket.yotris.ui.CommandContainer;
import com.lofibucket.yotris.util.Settings;
import java.awt.Dimension;
import javax.swing.JFrame;


public class ScoreWindow extends JFrame {
	private CommandContainer container;
	private Settings settings;

	public ScoreWindow(CommandContainer container, Settings settings) {
		super("Scores");

		this.container = container;
		this.settings = settings;

		setPreferredSize(new Dimension(400, 400));
		setResizable(false);
		pack();
	}
}
