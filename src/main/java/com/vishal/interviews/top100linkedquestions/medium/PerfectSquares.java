package com.vishal.interviews.top100linkedquestions.medium;

public class PerfectSquares {

	public static void main(String[] args) {

	}

	public int numSquares(int n) {
		if (n == 0) {
			return 0;
		}

		int[] dp = new int[n + 1];

		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j * j<= i; j++) {
				dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
			}
		}
		return dp[n];
	}

}
