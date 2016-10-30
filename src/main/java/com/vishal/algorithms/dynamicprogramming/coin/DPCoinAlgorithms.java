package com.vishal.algorithms.dynamicprogramming.coin;

import java.util.ArrayList;
import java.util.List;

public class DPCoinAlgorithms {

	public static void main(String[] args) {
		testMinNumOfCoins();
		testnumOfCombinations();
	}

	public static void testMinNumOfCoins() {
		System.out.println(minNumOfCoins(13, new int[] { 7, 2, 3, 6 }));

	}

	public static void testnumOfCombinations() {
		System.out.println("Number of combinations to get the given sum using given elements only one time is "
				+ numOfCombinations(7, new int[] { 2, 3, 4, 5 }));
		System.out.println("Number of combinations to get the given sum using given elements any number of times is "
				+ numOfCombinationsInfiniteTimes(7, new int[] { 2, 3, 4, 5 }));
	}

	public static List<Integer> minNumOfCoins(int n, int[] coins) {
		int[] num = new int[n + 1];
		int[] c = new int[n + 1];
		c[0] = -1;
		for (int i = 1; i <= n; i++) {
			num[i] = Integer.MAX_VALUE - 1;
			c[i] = -1;
		}

		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= n; j++) {
				if (j >= coins[i]) {
					if (num[j] > 1 + num[j - coins[i]]) {
						num[j] = 1 + num[j - coins[i]];
						c[j] = i;
					}
				}
			}
		}

		List<Integer> coinsRequired = new ArrayList<>();

		int tmp = n;
		while (c[tmp] != -1) {
			coinsRequired.add(coins[c[tmp]]);
			tmp = tmp - coins[c[tmp]];
		}
		return coinsRequired;
	}

	public static int numOfCombinations(int sum, int[] coins) {

		int[][] dp = new int[coins.length][sum + 1];

		dp[0][0] = 1;
		for (int i = 0; i <= sum; i++) {
			if (i == coins[0]) {
				dp[0][i] = 1;
			}
		}

		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= sum; j++) {
				if (j - coins[i] >= 0) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - coins[i]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		printDPMatrix(coins, dp);

		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static int numOfCombinationsInfiniteTimes(int sum, int[] coins) {

		int[][] dp = new int[coins.length][sum + 1];

		dp[0][0] = 1;
		for (int i = 0; i <= sum; i++) {
			if (i % coins[0] == 0) {
				dp[0][i] = 1;
			}
		}

		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = 1;
			for (int j = 1; j < dp[0].length; j++) {
				for (int k = 0; k <= i; k++) {
					if (j - coins[k] >= 0) {
						dp[i][j] += dp[i][j - coins[k]];
					}
				}

			}
		}

		printDPMatrix(coins, dp);

		return dp[dp.length - 1][dp[0].length - 1];

	}

	public static void printDPMatrix(int[] coins, int[][] dp) {

		System.out.println();
		System.out.print("   ");

		for (int j = 0; j < dp[0].length; j++) {
			System.out.print(j + " ");
		}

		System.out.println();
		System.out.print("   ");
		for (int j = 0; j < dp[0].length; j++) {
			System.out.print("--");
		}
		System.out.println();
		for (int i = 0; i < dp.length; i++) {
			System.out.print(coins[i] + "| ");
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}

}
