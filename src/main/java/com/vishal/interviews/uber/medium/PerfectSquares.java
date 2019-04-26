package com.vishal.interviews.uber.medium;

import java.util.Arrays;

public class PerfectSquares {

	public static void main(String[] args) {

	}

	public int numSquares(int n) {

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j * j < i; j++) {
				dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
			}
		}

		return dp[n] == Integer.MAX_VALUE ? 0 : dp[n];
	}

}
