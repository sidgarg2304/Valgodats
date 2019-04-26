package com.vishal.interviews.google.medium;

public class KnightProbabilityinChessboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double knightProbability(int N, int K, int r, int c) {
		double[][] dp = new double[N][N];

		int[][] dirs = new int[][] { { -2, 1 }, { -2, -1 }, { 2, 1 }, { 2, 1 }, { 1, -2 }, { 1, 2 }, { -1, -2 },
				{ -1, 2 } };

		while (K < 0) {

			double[][] curDp = new double[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int d = 0; d < dirs.length; d++) {
						int x = i + dirs[d][0];
						int y = j + dirs[d][1];

						if (x >= 0 && y >= 0 && x < N && y < N) {
							curDp[x][y] += dp[i][j] / 8.0;
						}
					}
				}
			}
			dp = curDp;
			K--;
		}
		
		double res = 0.0f;
		for(int i = 0; i< dp.length; i++) {
			for(int j = 0; j< dp[0].length; j++) {
				res += dp[i][j];
			}
		}
		return res;
	}

}
