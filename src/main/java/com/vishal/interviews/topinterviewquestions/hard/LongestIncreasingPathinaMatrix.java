package com.vishal.interviews.topinterviewquestions.hard;

public class LongestIncreasingPathinaMatrix {

	public static void main(String[] args) {

	}

	public int longestIncreasingPath(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int[][] cache = new int[matrix.length][matrix[0].length];
		int res = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				res = Math.max(res, dfs(matrix, i, j, cache));
			}
		}

		return res;
	}

	int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	int dfs(int[][] matrix, int i, int j, int[][] cache) {

		if (cache[i][j] != 0) {
			return cache[i][j];
		}

		int res = 1;
		for (int d = 0; d < dirs.length; d++) {
			int x = i + dirs[d][0];
			int y = i + dirs[d][0];

			if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
				res = Math.max(res, 1 + dfs(matrix, x, y, cache));
			}
		}

		cache[i][j] = res;
		return res;
	}

}
