
package com.lofibucket.yotris.ui.gui.components;

import com.lofibucket.yotris.logic.Grid;
import com.lofibucket.yotris.logic.Tile;
import com.lofibucket.yotris.ui.gui.Theme;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * The visible game area UI component. Renders a Grid with the given Theme.
 */
public class GameArea extends JPanel {
	/**
	 * The render grid to use.
	 */
	private Grid renderGrid;
	/**
	 * The current theme.
	 */
	private Theme theme;

	/**
	 * The default constructor.
	 * @param renderGrid	the render grid to use
	 * @param theme 	the color scheme to use for rendering
	 */
	public GameArea(Grid renderGrid, Theme theme) {
		super.setBackground(Color.BLACK);
		this.renderGrid = renderGrid;
		this.theme = theme;
	}

	/**
	 * Returns the current render grid.
	 * @return the render grid
	 */
	public Grid getRenderGrid() {
		return renderGrid;
	}

	/**
	 * Sets the current render grid.
	 * @param renderGrid the new render grid to use
	 */
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
				Tile tile = renderGrid.getTile(x, y);

				if (tile == null) {
					continue;
				}

				graphics.setColor(theme.getPaletteColor(tile.getColor()));
				graphics.fillRect(tile_x, tile_y, tile_width, tile_height);
			}
		}


	}
	
	/**
	 * Gets the tile width calculated from the component size.
	 * @return width of a single tile in pixels
	 */
	private int getTileWidth() {
		return (int) Math.round((double)this.getWidth() / (double)renderGrid.getWidth());
	}
	
	/**
	 * Gets the tile height calculated from the component size.
	 * @return height of a single tile in pixels
	 */
	private int getTileHeight() {
		return (int) Math.round((double)this.getHeight() / (double)renderGrid.getHeight());
	}
}
