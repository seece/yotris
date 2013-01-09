
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.util.ArrayHelpers;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import com.lofibucket.yotris.util.TileColor;

public class GridTest {

	public int w = 10;
	public int h = 20;

	public Grid grid;

    public GridTest() {
    }


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

	@Before
	public void setupGrid() {
		grid = new Grid(w, h);
	}

	@Test
	public void testCreatedGridDimensions() {
		Grid grid = new Grid(10, 11);
		assertEquals(10, grid.getWidth());
		assertEquals(11, grid.getHeight());
	}

	@Test
	public void testCreatedBigGridDimensions() {
		int width = 250;
		int height = 300;
		Grid grid = new Grid(width, height);
		assertEquals(width, grid.getWidth());
		assertEquals(height, grid.getHeight());
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
	public void testTileGetterCornerCase() {
		Tile t = new Tile(TileColor.CYAN);
		int width = 5;
		int height = 5;
		Tile[][] tiles = new Tile[width][height];

		Grid grid = new Grid(tiles);
		tiles[0][width-1] = t;
		grid = new Grid(tiles);
		assertEquals(t, grid.getTile(width-1, 0));

		tiles[height-1][0] = t;
		grid = new Grid(tiles);
		assertEquals(t, grid.getTile(0, height-1));
	}

	@Test
	public void testSizeIsCorrect() {
		Tile[][] tiles = grid.getTiles();

		assertEquals(w, tiles[0].length);
		assertEquals(h, tiles.length);

		assertEquals(w, grid.getWidth());
		assertEquals(h, grid.getHeight());
	}

	@Test
	public void testTileSetterValue() {
		Tile t1= new Tile(TileColor.BLUE);
		Tile t2= new Tile(TileColor.RED);
		grid.setTile(1, 1, t1);
		grid.setTile(0, 1, t2);
		Tile[][] tiles = grid.getTiles();

		assertEquals(t1, tiles[1][1]);
		assertEquals(t2, tiles[1][0]);
	}

	@Test
	public void testTileSetterCornerCaseValue() {
		Tile t1= new Tile(TileColor.BLUE);
		Tile t2= new Tile(TileColor.RED);
		grid.setTile(grid.getWidth()-1, 0, t1);
		grid.setTile(0, grid.getHeight()-1, t2);
		Tile[][] tiles = grid.getTiles();

		assertEquals(t1, tiles[0][grid.getWidth()-1]);
		assertEquals(t2, tiles[grid.getHeight()-1][0]);
	}

	@Test
	public void testTileGetterWithMultipleCoords() {
		Tile t = new Tile(TileColor.BLUE);

		Tile[][] tiles = {	{t,		t,		t},
							{null, 	null, 	null}, 
							{t,		t,		t}};

		Grid grid2 = new Grid(tiles);

		assertEquals(t, grid2.getTile(0, 0));
		assertEquals(t, grid2.getTile(2, 0));
		assertEquals(t, grid2.getTile(2, 2));
		assertEquals(null, grid2.getTile(0, 1));
		assertEquals(null, grid2.getTile(1, 1));
	}

	@Test 
	public void testTileGetterOutOfBoundsNegative() {
		assertEquals(null, grid.getTile(-1, -1));
	}

	@Test 
	public void testTileGetterOutOfBounds() {
		assertEquals(null, grid.getTile(0, h));
		assertEquals(null, grid.getTile(w, h));
		assertEquals(null, grid.getTile(w, 0));
	}

	@Test 
	public void testTileSetterOutOfBounds() {
		Tile t1= new Tile(TileColor.BLUE);

		assertEquals(false, grid.setTile(-1, -1, t1));
		assertEquals(false, grid.setTile(0, h, t1));
		assertEquals(false, grid.setTile(w, h, t1));
		assertEquals(false, grid.setTile(w, 0, t1));
	}

	@Test
	public void testPlotterWithPieceO() {
		Piece piece = new Piece(TetrominoShape.getShape("O"), TileColor.BLUE, new Position(0, 0));
		grid.plotPiece(piece);	

		Tile[][] gridtiles = grid.getTiles();
		Grid pieceTiles = piece.getGrid();

		assertTrue(gridtiles.length > 0);
		assertTrue(gridtiles[0].length > 0);

		for (int y=0;y<piece.getHeight();y++) {
			for (int x=0;x<piece.getWidth();x++) {
				int grid_offset_x = x + piece.getPos().x;
				int grid_offset_y = y + piece.getPos().y;
				Tile gridTile = grid.getTile(grid_offset_x, grid_offset_y);
				assertEquals(grid.getTile(x, y), gridTile);	
			}
		}
	}

}