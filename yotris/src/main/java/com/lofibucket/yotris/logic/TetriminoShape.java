
package com.lofibucket.yotris.logic;

import java.util.ArrayList;
import java.util.Random;

public class TetriminoShape {

	private static final boolean[][] I = 
			new boolean[][] 
			{
			{false, true, 	false, false},
			{false, true, 	false, false},
			{false, true, 	false, false},
			{false, true, 	false, false}
			};

	private static final boolean[][] J = 
			new boolean[][] 
			{
			{false, false, 	false},
			{true,  true, 	true},
			{false, false, 	true}
			};

	private static final boolean[][] L = 
			new boolean[][] 
			{
			{false, false, 	false},
			{true,  true, 	true},
			{true, 	false, 	false}
			};

	private static final boolean[][] O = 
			new boolean[][] 
			{
			{true, 	true},
			{true, 	true},
			};

	private static final boolean[][] S = 
			new boolean[][] 
			{
			{false,	false, 	false},
			{false, true, 	true},
			{true,  true, 	false}
			};

	private static final boolean[][] T = 
			new boolean[][] 
			{
			{false,	false, 	false},
			{true, true, 	true},
			{false,  true, 	false}
			};

	private static final boolean[][] Z = 
			new boolean[][] 
			{
			{false,	false, 	false},
			{true, true, 	false},
			{false, true, 	true}
			};

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

	public static boolean[][] getRandomShape() {
		ArrayList<boolean[][]> shapes = new ArrayList<>();
		Random random = new Random();

		shapes.add(I);
		shapes.add(J);
		shapes.add(L);
		shapes.add(O);
		shapes.add(S);
		shapes.add(T);
		shapes.add(Z);

		return shapes.get(random.nextInt(shapes.size()));
	}
}
