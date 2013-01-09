package com.lofibucket.yotris.util;

import java.util.Random;

/**
 * Tile color state. Used to represent different shades of the ingame tiles
 * The colors are not java.awt.Color since a Theme might map them to a different
 * palette.
 */
public enum TileColor {
	CYAN, BLUE, ORANGE, YELLOW, GREEN, PURPLE, RED;

	/**
	 * Returns one randomly chosen color.
	 * @return a random tile color
	 */
	public static TileColor getRandomColor() {
		TileColor[] colors = TileColor.class.getEnumConstants();

		Random r = new Random();
		int choice = r.nextInt(colors.length);

		return colors[choice];
	}
}
