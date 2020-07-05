package ctci.Arrays;

import java.util.Random;

public class ArrayHelper {

	public static int[][] makeMatrix(int rowLen, int colLen) {
		int[][] mat = new int[rowLen][colLen];
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				mat[i][j] = random.nextInt(1000) % 10;
			}
		}
		printMatrix(mat);
		return mat;
	}

	public static void printMatrix(int[][] mat) {

		int rowLen = mat.length;
		int colLen = mat[0].length;
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				System.out.printf("%5d", mat[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
