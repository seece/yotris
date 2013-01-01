
package com.lofibucket.yotris.logic;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class TetriminoShape {
	private Map<String, boolean[][]> shapes;

	private static final boolean[][] O = 
			new boolean[][] 
			{
			{true, 	true},
			{true, 	true},
			};

	private static final boolean[][] I = 
			new boolean[][] 
			{
			{false, true, 	false, false},
			{false, true, 	false, false},
			{false, true, 	false, false},
			{false, true, 	false, false}
			};

	public static boolean[][] getShape(String shape) {
		switch (shape) {
			case "O":
				return O;
			case "I":
				return I;
			default:
				// TODO throw a proper error here
				System.out.println("Error: invalid shape ID for getTetrimino.");
				return O;
		}
	}

	public static boolean[][] getRandomShape() {
		ArrayList<boolean[][]> shapes = new ArrayList<>();
		Random random = new Random();

		shapes.add(O);
		shapes.add(I);

		return shapes.get(random.nextInt(shapes.size()));
	}
}
