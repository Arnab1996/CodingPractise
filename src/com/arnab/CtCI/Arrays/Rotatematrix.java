package com.arnab.CtCI.Arrays;

public class Rotatematrix {
	public static void main(String[] args) {
		int[][] mat = ArrayHelper.makeMatrix(5, 5);
		int ret[][] = rotate1(mat);
		ArrayHelper.printMatrix(ret);
	}

	public static int[][] rotate1(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length)
			return null; // Not a square
		int n = matrix.length;

		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				int top = matrix[i][j]; // save top

				// left -> top
				matrix[i][j] = matrix[n - 1 - 2 * i - j][i];

				// bottom -> left
				matrix[n - 1 - 2 * i - j][i] = matrix[n - 1 - i][n - 1 - 2 * i - j];

				// right -> bottom
				matrix[n - 1 - i][n - 1 - 2 * i - j] = matrix[j][n - 1 - i];

				// top -> right
				matrix[j][n - 1 - i] = top; // right <- saved top
			}
		}
		return matrix;
	}

	public static int[][] rotate(int[][] mat) {
		if (mat.length == 0 || mat.length != mat[0].length)
			return null; // Not a square
		int ret[][] = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				ret[i][j] = mat[4 - j][i];
			}
		}
		return ret;
	}
}
