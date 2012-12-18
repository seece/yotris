
package yotris.logic;
import yotris.logic.Tile;
import yotris.logic.Piece;

public class Tetrimino {
	public static final boolean[][] O = 
			new boolean[][] 
			{
			{false, true, 	true, false},
			{false, true, 	true, false},
			{false, false, 	false, false},
			{false, false, 	false, false}
			};

	public static final boolean[][] I = 
			new boolean[][] 
			{
			{false, true, 	false, false},
			{false, true, 	false, false},
			{false, true, 	false, false},
			{false, true, 	false, false}
			};
}
