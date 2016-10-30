package com.vishal.algorithms.dynamicprogramming.stock;

import java.util.Arrays;

public class DPStockAlgorithms {

	public static void main(String[] args) {
		testFindMaxProfitByOneTransaction();
		testFindMaxProfitByMultipleTransactions();
		testfindMaxProfitByTwoTransactions();
		testFindMaxProfitByAtmostKTransactions();
	}

	public static void testFindMaxProfitByOneTransaction() {
		int[] stockPrice = new int[] { 10, 11, 12, 10, 9, 8, 12 };
		System.out
				.println("max profit that can be made by performing one complete transaction of the following stock prices "
						+ Arrays.toString(stockPrice) + " is " + findMaxProfitByOneTransaction(stockPrice));
	}

	public static void testFindMaxProfitByMultipleTransactions() {
		int[] stockPrice = new int[] { 10, 11, 12, 10, 9, 8, 12 };
		System.out.println(
				"max profit that can be made by performing many complete transaction of the following stock prices "
						+ Arrays.toString(stockPrice) + " is " + findMaxProfitByMultipleTransactions(stockPrice));
	}

	public static void testfindMaxProfitByTwoTransactions() {
		int[] stockPrice = new int[] { 1, 4, 5, 7, 6, 3, 2, 9 };
		System.out.println(
				"max profit that can be made by performing only 2 complete transaction of the following stock prices "
						+ Arrays.toString(stockPrice) + " is " + findMaxProfitByTwoTransactions(stockPrice));

		System.out.println(
				"max profit that can be made by performing only 2 complete transaction of the following stock prices "
						+ Arrays.toString(stockPrice) + " using generic solution is "
						+ findMaxProfitByAtmostKTransactions(stockPrice, 2));
	}

	public static void testFindMaxProfitByAtmostKTransactions() {
		int[] stockPrice = new int[] { 2, 5, 7, 1, 4, 3, 1, 3 };
		System.out.println(
				"Max profit that can be made by performing only 3 complete transaction of the following stock prices "
						+ Arrays.toString(stockPrice) + " is " + findMaxProfitByAtmostKTransactions(stockPrice, 3));
	}

	public static int findMaxProfitByOneTransaction(int[] stockPrice) {

		int maxProfit = 0;
		int minStockPriceUntilNow = stockPrice[0];

		for (int i = 1; i < stockPrice.length; i++) {
			int curProfit = stockPrice[i] - minStockPriceUntilNow;
			maxProfit = Math.max(curProfit, maxProfit);
			minStockPriceUntilNow = Math.min(stockPrice[i], minStockPriceUntilNow);
		}

		return maxProfit;
	}

	public static int findMaxProfitByMultipleTransactions(int[] stockPrice) {

		int maxProfit = 0;

		for (int i = 1; i < stockPrice.length; i++) {
			int curProfit = stockPrice[i] - stockPrice[i - 1];

			if (curProfit > 0) {
				maxProfit += curProfit;
			}
		}

		return maxProfit;
	}

	public static int findMaxProfitByTwoTransactions(int[] stockPrice) {

		int maxLeftSideProfit[] = new int[stockPrice.length];
		int maxRightSideProfit[] = new int[stockPrice.length];

		int minStockPriceUntilNow = stockPrice[0];
		maxLeftSideProfit[0] = 0;
		for (int i = 1; i < stockPrice.length; i++) {
			maxLeftSideProfit[i] = stockPrice[i] - minStockPriceUntilNow;
			maxLeftSideProfit[i] = Math.max(maxLeftSideProfit[i], maxLeftSideProfit[i - 1]);
			minStockPriceUntilNow = Math.min(minStockPriceUntilNow, stockPrice[i]);
		}

		int maxStockPriceUntilNow = stockPrice[stockPrice.length - 1];
		maxRightSideProfit[0] = 0;
		for (int i = stockPrice.length - 2; i >= 0; i--) {
			maxRightSideProfit[i] = maxStockPriceUntilNow - stockPrice[i];
			maxRightSideProfit[i] = Math.max(maxRightSideProfit[i], maxRightSideProfit[i + 1]);
			minStockPriceUntilNow = Math.max(maxStockPriceUntilNow, stockPrice[i]);
		}

		int maxProfit = 0;
		for (int i = 0; i < stockPrice.length; i++) {
			maxProfit = Math.max(maxProfit, maxLeftSideProfit[i] + maxRightSideProfit[i]);
		}

		return maxProfit;
	}

	public static int findMaxProfitByAtmostKTransactions(int[] stockPrice, int k) {

		int[][] dp = new int[k + 1][stockPrice.length];

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < stockPrice.length; j++) {

				// Considering Jth Day
				// find all possible profits by buying stock on all days before
				// today and selling on today
				int profitWithJthDay = 0;
				for (int m = 0; m < j; m++) {
					profitWithJthDay = stockPrice[j] - stockPrice[m] + dp[i - 1][m];
					dp[i][j] = Math.max(dp[i][j], profitWithJthDay);
				}

				// Without Jth Day
				int profitWithoutJthday = dp[i][j - 1];

				// final max profit on this jth day
				dp[i][j] = Math.max(dp[i][j], profitWithoutJthday);
			}
		}

		printDPMatrix(dp, stockPrice);
		return dp[k][stockPrice.length - 1];
	}

	public static void printDPMatrix(int[][] dp, int[] stockPrice) {

		System.out.println();
		System.out.print(" ");
		for (int i = 0; i < stockPrice.length; i++) {
			System.out.print(stockPrice[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < dp.length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

	}
}
