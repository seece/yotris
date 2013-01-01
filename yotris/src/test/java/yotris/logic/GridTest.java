
package yotris.logic;

import com.lofibucket.yotris.logic.Tile;
import com.lofibucket.yotris.logic.Grid;
import com.lofibucket.yotris.logic.Position;
import com.lofibucket.yotris.logic.TetriminoShape;
import com.lofibucket.yotris.logic.Piece;
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

	@Before
	public void setupGrid() {
		grid = new Grid(w, h);
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
		Piece piece = new Piece(TetriminoShape.getShape("O"), TileColor.BLUE, new Position(0, 0));
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