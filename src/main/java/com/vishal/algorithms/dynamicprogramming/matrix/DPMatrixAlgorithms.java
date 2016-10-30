package com.vishal.algorithms.dynamicprogramming.matrix;

import com.vishal.algorithms.matrix.MatrixBasicAlgorithms;

public class DPMatrixAlgorithms {

	public static void main(String[] args) {

		testMinCostToPaintHouses();
	}

	public static void testMinCostToPaintHouses() {
		int[][] cost = new int[4][3];
		cost[0] = new int[] { 1, 2, 3 };
		cost[1] = new int[] { 3, 1, 2 };
		cost[2] = new int[] { 1, 2, 3 };
		cost[3] = new int[] { 4, 3, 1 };

		MatrixBasicAlgorithms.printMatrix(cost);

		System.out
				.println("Min cost to paint all houses with adjacent houses not having same color is " + paintHouse(cost));
	}

	/**
	 * calculates min cost to paint all houses with adjacet houses not having
	 * same colors columns in cost matrix represent colors rows in cost matrix
	 * represent houses
	 * 
	 * @param cost
	 * @return
	 */
	public static int minCostToPaintHouses(int[][] cost) {
		int[][] dp = new int[cost.length][cost[0].length];

		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];

		for (int i = 1; i < cost.length; i++) {
			dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		MatrixBasicAlgorithms.printMatrix(dp);
		return Math.min(Math.min(dp[cost.length - 1][0], dp[cost.length - 1][1]), dp[cost.length - 1][2]);
	}

	public static int paintHouse(int[][] arr) {
		int[][] tmp = new int[arr.length][arr[0].length];
		
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[0].length; j++) {				
				tmp[i][j] = arr[i][j];
				if (i != 0) {
					int val = Integer.MAX_VALUE;
					for (int k = 0; k < arr[0].length; k++) {
						if (k != j) {
							val = Math.min(val, tmp[i - 1][k]);
						}
					}					
					tmp[i][j] = arr[i][j] + val;
				}
			}
		}

		MatrixBasicAlgorithms.printMatrix(tmp);
		int res = tmp[arr.length - 1][0];
		for (int i = 1; i < arr[0].length; i++) {
			res = Math.min(tmp[arr.length - 1][i], res);
		}
		return res;

	}

	public static int minCostII(int[][] costs) {
		if (costs == null || costs.length == 0)
			return 0;

		int preMin = 0;
		int preSecond = 0;
		int preIndex = -1;

		for (int i = 0; i < costs.length; i++) {
			int currMin = Integer.MAX_VALUE;
			int currSecond = Integer.MAX_VALUE;
			int currIndex = 0;

			for (int j = 0; j < costs[0].length; j++) {
				if (preIndex == j) {
					costs[i][j] += preSecond;
				} else {
					costs[i][j] += preMin;
				}

				if (currMin > costs[i][j]) {
					currSecond = currMin;
					currMin = costs[i][j];
					currIndex = j;
				} else if (currSecond > costs[i][j]) {
					currSecond = costs[i][j];
				}
			}

			preMin = currMin;
			preSecond = currSecond;
			preIndex = currIndex;
		}

		int result = Integer.MAX_VALUE;
		for (int j = 0; j < costs[0].length; j++) {
			if (result > costs[costs.length - 1][j]) {
				result = costs[costs.length - 1][j];
			}
		}
		return result;
	}

}
