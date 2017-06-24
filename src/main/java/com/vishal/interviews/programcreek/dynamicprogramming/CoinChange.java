package com.vishal.interviews.programcreek.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {

	}

	public static int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;

		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (j - coins[i] >= 0 && dp[j - coins[i]] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
				}
			}
		}

		if (dp[amount] == Integer.MAX_VALUE) {
			return -1;
		}
		return dp[amount];
	}

}
