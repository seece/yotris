
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.util.ArrayHelpers;
import com.lofibucket.yotris.util.TileColor;
import static org.junit.Assert.*;
import org.junit.Test;

public class GridTest {

public static final boolean[][] testShape = 
		new boolean[][] 
		{
		{false, false, 	false},
		{true,  true, 	true},
		{false, false, 	true}
		};

public static final boolean[][] testShapeMirroredHorizontally = 
		new boolean[][] 
		{
		{false, false, 	false},
		{true,  true, 	true},
		{true, false, 	false}
		};

public static final boolean[][] testShapeMirroredVertically = 
		new boolean[][] 
		{
		{false, false, 	true},
		{true,  true, 	true},
		{false, false, 	false}
		};

public static final boolean[][] testShapeRotatedClockwise = 
		new boolean[][] 
		{
		{false, true, 	false},
		{false, true, 	false},
		{true, 	true, 	false}
		};

    public GridTest() {
    }

	@Test
	public void testCreatedGridDimensions() {
		Grid grid = new Grid(10, 11);
		assertEquals(10, grid.getWidth());
		assertEquals(11, grid.getHeight());
	}

	@Test
	public void testTileSetter() {
		Grid grid = new Grid(10, 11);
		Tile t = new Tile(TileColor.CYAN);
		grid.setTile(2, 1, t);

		Tile[][] tiles = grid.getTiles();
		assertEquals(t, tiles[1][2]);
	}

	@Test
	public void testTileGetter() {
		Tile t = new Tile(TileColor.CYAN);
		Tile[][] tiles = new Tile[5][5];
		tiles[1][2] = t;

		Grid grid = new Grid(tiles);
		assertEquals(t, grid.getTile(2, 1));
	}

	@Test
	public void testRotation() {
		Grid grid;
		grid = new Grid(GridTest.testShape, TileColor.CYAN);
		grid.rotateOnceClockwise();

		assertTrue(ArrayHelpers.checkIfNullObjectsEqual(grid.getTiles(),
				GridTest.testShapeRotatedClockwise));
	}
	

}