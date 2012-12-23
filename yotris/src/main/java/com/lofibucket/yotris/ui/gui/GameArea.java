
package com.lofibucket.yotris.ui.gui;

import com.lofibucket.yotris.logic.Grid;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GameArea extends JPanel {
	private Grid renderGrid;
	private int tileSize;

	public int getTileSize() {
		return tileSize;
	}

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}

	public GameArea(Grid renderGrid) {
		this(renderGrid, 18);
	}

	public GameArea(Grid renderGrid, int tileSize) {
		super.setBackground(Color.BLACK);
		this.renderGrid = renderGrid;
		this.tileSize = tileSize;
	}

	public Grid getRenderGrid() {
		return renderGrid;
	}

	public void setRenderGrid(Grid renderGrid) {
		this.renderGrid = renderGrid;
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		if (renderGrid == null) {
			return;
		}

		int tile_width = getTileWidth();
		int tile_height = getTileHeight();

		for (int y=0;y<renderGrid.getHeight();y++) {
			for (int x=0;x<renderGrid.getWidth();x++) {
				int tile_x = x * tile_width;
				int tile_y = y * tile_height;

				if (Math.random() > 0.5) {
					graphics.setColor(Color.GREEN);
				} else {
					graphics.setColor(Color.RED);
				}
				graphics.fillRect(tile_x, tile_y, tile_width, tile_height);
			}
		}


	}

	private int getTileWidth() {
		return (int) Math.round((double)this.getWidth() / (double)renderGrid.getWidth());
	}
	
	private int getTileHeight() {
		return (int) Math.round((double)this.getHeight() / (double)renderGrid.getHeight());
	}
}
