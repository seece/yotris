
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.util.TileColor;
import static org.junit.Assert.*;
import org.junit.Test;

public class TileTest {

    public TileTest() {
    }

	@Test
	public void testColorGetsSetInConstructor() {
		Tile tile = new Tile(TileColor.ORANGE);
		assertEquals(TileColor.ORANGE, tile.getColor());
	}

	@Test
	public void testEqualsComparesTwoOfSame() {
		Tile tile = new Tile(TileColor.BLUE);
		Tile tile2 = new Tile(TileColor.BLUE);

		assertEquals(tile, tile2);
	}

	@Test
	public void testEqualsComparesTwoDifferentColors() {
		Tile tile = new Tile(TileColor.BLUE);
		Tile tile2 = new Tile(TileColor.RED);
		assertNotSame(tile2, tile);
	}

}