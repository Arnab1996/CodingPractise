package ctci.Arrays;

import java.io.InputStreamReader;
import java.util.Scanner;

public class ZeroMatrix {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int[][] mat = ArrayHelper.makeMatrix(5, 5);
		zeroMatOptimized(mat);
		scanner.close();
		System.gc();
	}

	public static void zeroMatOptimized(int[][] mat) {
		boolean row = false;
		boolean col = false;
		for (int i = 0; i < 5; i++) {
			if (mat[i][0] == 0) {
				row = true;
				break;
			}
		}

		for (int j = 0; j < 5; j++) {
			if (mat[0][j] == 0) {
				col = true;
				break;
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (mat[i][j] == 0) {
					mat[i][0] = 0;
					mat[0][j] = 0;
				}
			}
		}

		for (int i = 0; i < 5; i++) {
			if (mat[i][0] == 0) {
				for (int j = 0; j < 5; j++) {
					mat[i][j] = 0;
				}
			}
		}

		// Nullify columns based on values in first row
		for (int j = 1; j < 5; j++) {
			if (mat[0][j] == 0) {
				for (int i = 0; i < 5; i++) {
					mat[i][j] = 0;
				}
			}
		}

		if (row) {
			for (int j = 0; j < 5; j++) {
				mat[0][j] = 0;
			}
		}
		if (col) {
			for (int j = 0; j < 5; j++) {
				mat[j][0] = 0;
			}
		}

		ArrayHelper.printMatrix(mat);
	}

	public static void zeroMat(int[][] mat) {
		int row[] = new int[5];
		int col[] = new int[5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (mat[i][j] == 0) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}

		for (int i = 0; i < 5; i++) {
			if (row[i] == 1) {
				for (int j = 0; j < 5; j++) {
					mat[i][j] = 0;
				}
			}
			if (col[i] == 1) {
				for (int j = 0; j < 5; j++) {
					mat[j][i] = 0;
				}
			}
		}

		ArrayHelper.printMatrix(mat);
	}
}
