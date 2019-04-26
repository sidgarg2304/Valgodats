package com.vishal.interviews.facebook.medium;

public class KnightDialer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static final int M = (int) Math.pow(10, 9) + 7;
	public int knightDialer(int N) {

		long res = 0;

		long[][][] dp = new long[4][3][N + 1];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				res = (res + dfs(i, j, N, dp)) % M;
			}
		}
		return (int) res;
	}

	int[][] dirs = new int[][] { { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { -2, -1 }, { -2, 1 }, { 2, -1 },
			{ 2, 1 } };

	long dfs(int i, int j, int N, long[][][] dp) {

		if (i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j != 1)) {
			return 0;
		}

		if (N == 1) {
			return 1;
		}

		if (dp[i][j][N] > 0) {
			return dp[i][j][N];
		}
		
		for (int d = 0; d < dirs.length; d++) {
			int x = i + dirs[d][0];
			int y = j + dirs[d][1];

			dp[i][j][N] = (dp[i][j][N] + dfs(x, y, N - 1, dp)) % M;
		}		
		return dp[i][j][N];
	}

}
