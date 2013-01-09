
package com.lofibucket.yotris.logic;

import java.util.ArrayList;
import java.util.Random;

/**
 * Provides the Piece-constructor with different tetromino shapes.
 */
public class TetrominoShape {

	/**
	 * The I-piece.
	 */
	private static final boolean[][] I = 
			new boolean[][] 
			{
			{false, true, 	false, false},
			{false, true, 	false, false},
			{false, true, 	false, false},
			{false, true, 	false, false}
			};

	/**
	 * The J-piece.
	 */
	private static final boolean[][] J = 
			new boolean[][] 
			{
			{false, false, 	false},
			{true,  true, 	true},
			{false, false, 	true}
			};

	/**
	 * The L-piece.
	 */
	private static final boolean[][] L = 
			new boolean[][] 
			{
			{false, false, 	false},
			{true,  true, 	true},
			{true, 	false, 	false}
			};

	/**
	 * The O-piece.
	 */
	private static final boolean[][] O = 
			new boolean[][] 
			{
			{true, 	true},
			{true, 	true},
			};

	/**
	 * The S-piece.
	 */
	private static final boolean[][] S = 
			new boolean[][] 
			{
			{false,	false, 	false},
			{false, true, 	true},
			{true,  true, 	false}
			};
	/**
	 * The T-piece.
	 */
	private static final boolean[][] T = 
			new boolean[][] 
			{
			{false,	false, 	false},
			{true, true, 	true},
			{false,  true, 	false}
			};

	/**
	 * The Z-piece.
	 */
	private static final boolean[][] Z = 
			new boolean[][] 
			{
			{false,	false, 	false},
			{true, true, 	false},
			{false, true, 	true}
			};

	/**
	 * Returns the shape matching the given letter.
	 * @param shape	the shape we want
	 * @return 	a two dimensional boolean array describing the piece shape
	 */
	public static boolean[][] getShape(String shape) {
		switch (shape) {

			case "I":
				return I;
			case "J":
				return J;
			case "L":
				return L;
			case "O":
				return O;
			case "S":
				return S;
			case "T":
				return T;
			case "Z":
				return Z;
			default:
				// TODO throw a proper error here
				System.out.println("Error: invalid shape ID for getTetrimino.");
				return O;
		}
	}

	/**
	 * Returns all shapes in a list.
	 * @return the list of all shapes
	 */
	private static ArrayList<boolean[][]> getAllShapes() {
		ArrayList<boolean[][]> shapes = new ArrayList<>();

		shapes.add(I);
		shapes.add(J);
		shapes.add(L);
		shapes.add(O);
		shapes.add(S);
		shapes.add(T);
		shapes.add(Z);

		return shapes;
	}

	/**
	 * Returns one randomly chosen shape.
	 * @return the shape as a two dimensional boolean array
	 */
	public static boolean[][] getRandomShape() {
		ArrayList<boolean[][]> shapes = getAllShapes();
		Random random = new Random();

		return shapes.get(random.nextInt(shapes.size()));
	}
}
