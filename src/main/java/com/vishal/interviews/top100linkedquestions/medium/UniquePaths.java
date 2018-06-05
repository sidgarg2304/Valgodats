package com.vishal.interviews.top100linkedquestions.medium;

public class UniquePaths {

	public static void main(String[] args) {

	}

	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m + 1][n + 1];

		dp[0][1] = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		return dp[m][n];
	}

}
