package com.vishal.algorithms.dynamicprogramming.array;

public class DPArrayAlgorithms {

	public static void main(String[] args) {
		testMinNumOfPerfectSquares();
	}

	public static void testMinNumOfPerfectSquares() {
		System.out.println(minNumOfPerfectSquares(12));
	}

	public static int minNumOfPerfectSquares(int n) {
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE - 1;
		}

		int max = (int) Math.sqrt(n);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= max; j++) {
				if (i == j * j) {
					dp[i] = 1;
				} else if (i > j * j) {
					dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
				}
			}
		}
		return dp[n];
	}
}
