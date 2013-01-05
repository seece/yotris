
package com.lofibucket.yotris.ui.gui;

import com.lofibucket.yotris.util.TileColor;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * A class that maps each TileColor to one, real, java.awt.Color used for 
 * rendering.
 * @author cce
 */
public class Theme {
	private Map<TileColor, Color> palette;

	public Theme (Map<TileColor, Color> palette) {
		this.palette = palette;
	}

	public Theme() {
		palette = new HashMap<>();
		initDefaultPalette(palette);
	}

	public Color getPaletteColor(TileColor tilecolor) {
		return palette.get(tilecolor);
	}

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
