
package com.lofibucket.yotris.util;


public class ArrayHelpers {

	public static void printObjectArray(Object[][] arr) {
		int width = arr[0].length;
		int height = arr.length;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				String c = "X";

				if (arr[y][x] == null) {
					c = ".";
				}
				System.out.print(c);
			}
			System.out.println("");
		}
	}

	/**
	 * Checks if two 2D arrays have nulls/false values in the same slots.
	 */
	public static boolean checkIfNullObjectsEqual(Object[][] a, boolean[][] b) {
		if (a.length != b.length) { return false; }
		if (a[0].length != b[0].length) { return false; }

		for (int y=0;y<a.length;y++) {
		for (int x=0;x<a[0].length;x++) {
			if (b[y][x]) {
				if (a[y][x] == null) {
					return false;
				}
			}
			
		}
		}

		return true;
	}
}
