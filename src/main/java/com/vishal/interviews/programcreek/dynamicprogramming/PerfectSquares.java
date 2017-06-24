package com.vishal.interviews.programcreek.dynamicprogramming;

public class PerfectSquares {

	public static void main(String[] args) {

	}

	public int numSquares(int n) {
		int[] dp = new int[n + 1];

		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j * j <= i; j++) {
				dp[i] = Math.min(1 + dp[i - j * j], dp[i]);
			}
		}

		return dp[n];
	}
}
