package com.vishal.interviews.topinterviewquestions.medium;

import java.util.Arrays;

public class UniquePaths {

	public static void main(String[] args) {

		uniquePaths(1, 2);
	}

	public static int uniquePaths(int m, int n) {

		int[][] dp = new int[m + 1][n + 1];

		dp[0][1] = 1;
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		for (int i = 0; i < dp.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return dp[m][n];
	}

}
