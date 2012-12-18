
package yotris.logic;
import yotris.util.TileColor;

public class Tile {
	TileColor color;

	public Tile(TileColor color) {
		this.color = color;
	}

	public TileColor getColor() {
		return color;
	}

	public void setColor(TileColor color) {
		this.color = color;
	}

}
