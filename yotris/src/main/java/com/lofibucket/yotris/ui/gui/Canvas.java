
package com.lofibucket.yotris.ui.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Canvas extends JPanel {
	public Canvas() {
		super.setBackground(Color.BLACK);
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		graphics.setColor(Color.GREEN);
        graphics.fillRect(0, 0, 10, 200);
	}
}
