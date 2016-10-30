package com.vishal.algorithms.dynamicprogramming.binarytree;

import java.util.Arrays;

public class DPBinaryTreeAlgorithms {

	public static void main(String[] args) {

		testMinCostToSearchBST();
		testNumOfBSTs();
	}

	public static void testNumOfBSTs(){
		int n = 5;
		System.out.println("number of bsts that can be formed with " + n + " keys is " + numOfBSTs(n));
	}

	public static void testMinCostToSearchBST() {
		System.out.println(minCostToSearchBST(new int[] { 10, 12, 16, 21 }, new int[] { 4, 2, 6, 3 }));
	}

	public static int minCostToSearchBST(int[] elements, int[] frequencyOfSearch) {

		int[][] dp = new int[elements.length][elements.length];

		for (int i = 0; i < dp.length; i++) {
			dp[i][i] = frequencyOfSearch[i];
		}

		for (int l = 2; l <= dp.length; l++) {
			for (int i = 0; i <= elements.length - l; i++) {
				int j = i + l - 1;
				for (int k = i; k <= j; k++) {
					dp[i][j] += frequencyOfSearch[k];
				}

				int minCostWithRoot = Integer.MAX_VALUE;
				for (int k = i; k <= j; k++) {
					int curCost = 0;
					if (k < j) {
						curCost += dp[k + 1][j];
					}
					if (k > i) {
						curCost += dp[i][k - 1];
					}
					minCostWithRoot = Math.min(minCostWithRoot, curCost);
				}
				dp[i][j] += minCostWithRoot;
			}
		}

		printDPMatrix(dp);

		return dp[0][elements.length - 1];
	}

	/**
	 * This is Catalan number
	 * 
	 * @param n
	 */
	public static int numOfBSTs(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}

	public static void printDPMatrix(int[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + "  ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

}
