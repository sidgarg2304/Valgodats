package com.vishal.algorithms.dynamicprogramming.cuttingrod;

public class DPCuttingRodAlgorithms {

	public static void main(String[] args) {
		testmaxProfit();
	}

	public static void testmaxProfit() {
		System.out.println("Max profit that can be made from the rod is "
				+ maxProfit(5, new int[] { 1, 2, 3, 4 }, new int[] { 2, 5, 7, 8 }));
	}

	public static int maxProfit(int rodLength, int[] rodLengths, int[] costOfRods) {

		int[][] dp = new int[rodLengths.length][rodLength + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (i == 0) {
					if (j >= rodLengths[i]) {
						dp[i][j] = costOfRods[i] + dp[i][j - rodLengths[i]];
					}
				} else {
					if (j >= rodLengths[i]) {
						dp[i][j] = Math.max(dp[i - 1][j], costOfRods[i] + dp[i][j - rodLengths[i]]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
		}

		printDPMatrix(rodLengths, dp);

		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static void printDPMatrix(int[] rodLengths, int[][] dp) {

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
			System.out.print(rodLengths[i] + "| ");
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
