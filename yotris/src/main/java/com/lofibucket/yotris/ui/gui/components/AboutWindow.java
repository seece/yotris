
package com.lofibucket.yotris.ui.gui.components;

import com.lofibucket.yotris.ui.gui.action.HideWindowActionListener;
import com.lofibucket.yotris.util.Settings;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * The about window.
 */
public class AboutWindow extends JFrame {
	/**
	 * Constructor that takes in the current settings because the window
	 * must show the correct version number.
	 * @param settings current game settings
	 */
	public AboutWindow(Settings settings) {
		super("About yotris");
		createComponents(settings);
		setPreferredSize(new Dimension(300, 130));
		setResizable(false);
		pack();
	}

	/**
	 * Creates all window components.
	 * @param settings 	the current settings, the version number is fetched
	 * from this
	 */
	private void createComponents(Settings settings) {
		JPanel pane = new JPanel();
		this.add(pane);
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		JLabel title = new JLabel("yotris v" + settings.getVersion());
		title.setFont(new Font("arial", Font.BOLD, 16));

		JLabel info = new JLabel("Developed by Pekka V‰‰n‰nen");
		JLabel copying = new JLabel("This program is distributed under the MIT License.");

		JButton nappu = new JButton("Close");

		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		info.setAlignmentX(Component.CENTER_ALIGNMENT);
		copying.setAlignmentX(Component.CENTER_ALIGNMENT);
		copying.setAlignmentY(Component.CENTER_ALIGNMENT);
		nappu.setAlignmentX(Component.CENTER_ALIGNMENT);

		pane.add(title);
		pane.add(info);
		pane.add(copying);
		pane.add(Box.createVerticalGlue());
		pane.add(nappu);

		nappu.addActionListener(new HideWindowActionListener(this));
	}

}
