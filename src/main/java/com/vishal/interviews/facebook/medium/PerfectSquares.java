package com.vishal.interviews.facebook.medium;

public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numSquares(int n) {

		int[] dp = new int[n + 1];
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
			}
		}
		return dp[n];
	}

}
