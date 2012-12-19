
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
