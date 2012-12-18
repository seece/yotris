
package yotris.logic;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import yotris.util.TileColor;

public class GridTest {

	public int w = 10;
	public int h = 20;

	public Grid grid;

    public GridTest() {
    }

	@Before
	public void setupGrid() {
		grid = new Grid(w, h);
	}

	@Test
	public void testSizeIsCorrect() {
		Tile[][] tiles = grid.getMap();

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
		Tile[][] tiles = grid.getMap();

		assertEquals(t1.getColor(), grid.getTile(1, 1).getColor());
		assertEquals(t2.getColor(), grid.getTile(0, 1).getColor());
	}

	@Test 
	public void testTileGetterOutOfBounds() {
		assertEquals(null, grid.getTile(-1, -1));
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
	public void testPlotter() {
		Piece piece = new Piece(Tetrimino.O, new Position(0, 0));
	}

}