package com.vishal.interviews.programcreek.dynamicprogramming;

public class BestTimetoBuyandSellStockIV {

	public static void main(String[] args) {

	}

	public int maxProfit(int k, int[] prices) {

		int[][] dp = new int[k + 1][prices.length];

		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < prices.length; j++) {
				// do not make a transaction today
				dp[i][j] = dp[i][j - 1];

				// make a transaction today

				int maxProfitWithToday = Integer.MIN_VALUE;
				for (int t = 0; t < j; t++) {
					maxProfitWithToday = Math.max(maxProfitWithToday, dp[i - 1][t] + prices[i] - prices[t]);
				}

				dp[i][j] = Math.max(dp[i][j], maxProfitWithToday);
			}
		}

		return dp[k][prices.length - 1];
	}

}
