package ctci.Stacks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BFS {
	static int n = 4;
	static int m = 5;

	public static void main(String[] args) {
		int[][] grid = new int[n][m];
		boolean[][] visited = new boolean[n][m];

		Random random = new Random();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = random.nextInt(2);
				if (grid[i][j] == 1) {
					visited[i][j] = true;
				} else {
					visited[i][j] = false;
				}
			}
		}

		System.out.println(Arrays.deepToString(grid));
		bfs(grid, visited);
		System.gc();
	}

	private static void bfs(int[][] grid, boolean[][] visited) {
		Queue<Point> Q = new LinkedList<Point>();
		Q.add(new Point(0, 0, 0));
		visited[0][0] = true;

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			if (grid[p.row][p.col] == 0) {
				grid[p.row][p.col] = p.distance;
			}

			if (p.col - 1 >= 0 && !visited[p.row][p.col - 1]) {
				Q.add(new Point(p.row, p.col - 1, p.distance + 1));
				visited[p.row][p.col - 1] = true;
			}

			if (p.col + 1 < m && !visited[p.row][p.col + 1]) {
				Q.add(new Point(p.row, p.col + 1, p.distance + 1));
				visited[p.row][p.col + 1] = true;
			}

			if (p.row - 1 >= 0 && !visited[p.row - 1][p.col]) {
				Q.add(new Point(p.row - 1, p.col, p.distance + 1));
				visited[p.row - 1][p.col] = true;
			}

			if (p.row + 1 < n && !visited[p.row + 1][p.col]) {
				Q.add(new Point(p.row + 1, p.col, p.distance + 1));
				visited[p.row + 1][p.col] = true;
			}
		}

		System.out.println(Arrays.deepToString(grid));
	}

	static class Point {
		int row, col, distance;

		public Point(int row, int col, int distance) {
			super();
			this.row = row;
			this.col = col;
			this.distance = distance;
		}
	}

}
