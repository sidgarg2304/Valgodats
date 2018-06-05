package com.vishal.interviews.topinterviewquestions.medium;

public class PerfectSquares {

	public static void main(String[] args) {

	}

	// 12 = 4 + 4 + 4
	// 13 = 9 + 4

	// 0 1 2 3 4 5 6 7 8 9
	// 0 1 2 3 1
	public int numSquares(int n) {

		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
			}
		}

		return dp[n];
	}

}
