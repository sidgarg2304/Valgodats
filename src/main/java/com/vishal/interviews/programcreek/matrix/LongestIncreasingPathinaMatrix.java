package com.vishal.interviews.programcreek.matrix;

public class LongestIncreasingPathinaMatrix {

	public static void main(String[] args) {

	}

	int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int longestIncreasingPath(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int[][] dp = new int[matrix.length][matrix[0].length];

		int res = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				res = Math.max(res, dfs(matrix, i, j, dp));
			}
		}

		return res;

	}

	int dfs(int[][] matrix, int i, int j, int[][] dp) {

		if (dp[i][j] != 0) {
			return dp[i][j];
		}

		int max = 1;
		for (int d = 0; d < dirs.length; d++) {
			int x = i + dirs[d][0];
			int y = j + dirs[d][0];

			if (x < 0 || y < 0 || x >= dp.length || y >= dp[0].length) {
				continue;
			}
			if (matrix[x][y] > matrix[i][j]) {
				max = Math.max(max, 1 + dfs(matrix, x, y, dp));
			}
		}

		dp[i][j] = max;
		return max;

	}

}
