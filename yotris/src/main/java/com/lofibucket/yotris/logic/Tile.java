
package com.lofibucket.yotris.logic;
import com.lofibucket.yotris.util.TileColor;

/**
 *	A tetris block tile. Its color is the only unique property, since its 
 * position is deduced from array coordinates in Grid.
 */
public class Tile {
	/**
	 * The color of this tile.
	 */
	TileColor color;

	/**
	 * The default constructor.
	 * @param color	Tile color
	 */
	public Tile(TileColor color) {
		this.color = color;
	}

	Tile(Tile tile) {
		this.color = tile.color;
	}

	/**
	 *
	 * @return	Tile color
	 */
	public TileColor getColor() {
		return color;
	}

	/**
	 *
	 * @param color	The new tile color
	 */
	public void setColor(TileColor color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 23 * hash + (this.color != null ? this.color.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Tile other = (Tile) obj;
		if (this.color != other.color) {
			return false;
		}
		return true;
	}

}
