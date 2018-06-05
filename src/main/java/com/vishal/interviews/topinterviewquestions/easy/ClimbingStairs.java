package com.vishal.interviews.topinterviewquestions.easy;

import java.util.Arrays;

public class ClimbingStairs {

	public static void main(String[] args) {

	}

	public int climbStairs(int n) {
		int[] dp = new int[n + 1];

		Arrays.fill(dp, -1);
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public int climbStairs(int n, int[] dp) {

		if (dp[n] != -1) {
			return dp[n];
		}

		int val = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
		dp[n] = val;
		return val;
	}

}
