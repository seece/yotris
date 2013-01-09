
package com.lofibucket.yotris.ui.gui;

import com.lofibucket.yotris.util.TileColor;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * A class that maps each TileColor to one, real, java.awt.Color used for 
 * rendering.
 */
public class Theme {
	private Map<TileColor, Color> palette;

	/**
	 * A constructor that takes in an explicit palette.
	 * @param palette 
	 */
	public Theme (Map<TileColor, Color> palette) {
		this.palette = palette;
	}

	/**
	 * The default constructor. Initializes the theme with default colors.
	 */
	public Theme() {
		palette = new HashMap<>();
		initDefaultPalette(palette);
	}

	/**
	 * Returns the real color matching the palette color.
	 * @param tilecolor	the palette color to use
	 * @return 	the real color matching the palette
	 */
	public Color getPaletteColor(TileColor tilecolor) {
		return palette.get(tilecolor);
	}

	/**
	 * Initializes the default palette.
	 * @param palette 	the palette map to use
	 */
	private static void initDefaultPalette(Map<TileColor, Color> palette) {
		palette.put(TileColor.BLUE, Color.blue);
		palette.put(TileColor.CYAN, Color.cyan);
		palette.put(TileColor.GREEN, Color.green);
		palette.put(TileColor.ORANGE, Color.orange);
		palette.put(TileColor.PURPLE, Color.magenta);
		palette.put(TileColor.RED, Color.red);
		palette.put(TileColor.YELLOW, Color.yellow);
	}
}
