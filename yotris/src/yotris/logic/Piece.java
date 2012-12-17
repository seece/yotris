
package yotris.logic;

public class Piece {
	private Tile tiles[][];	
	private Rotation rotation;

	public Piece(boolean [][] tetrimino) {
		this.tiles = parseTileGridFromTetrimino(tetrimino);
		this.rotation = Rotation.UP;
	}

	private Tile[][] parseTileGridFromTetrimino(boolean [][] tetrimino) {
		int block_width = tetrimino[0].length;
		int block_height = tetrimino.length;

		Tile[][] tilearray= new Tile[block_width][block_height];
		return tilearray;
	}
}
