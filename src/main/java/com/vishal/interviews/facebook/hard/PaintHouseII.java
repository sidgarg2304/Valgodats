package com.vishal.interviews.facebook.hard;

/**
 * 265. Paint House II
 * 
 * There are a row of n houses, each house can be painted with one of the k
 * colors. The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the
 * same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x
 * k cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * color 0; costs[1][2] is the cost of painting house 1 with color 2, and so
 * on... Find the minimum cost to paint all houses.
 * 
 * Note:
 * 
 * All costs are positive integers.
 * 
 * Follow up:
 * 
 * Could you solve it in O(nk) runtime?
 */
public class PaintHouseII {

	public static void main(String[] args) {

	}

	/**
	 * AC Java solution without extra space The idea is similar to the problem
	 * Paint House I, for each house and each color, the minimum cost of painting
	 * the house with that color should be the minimum cost of painting previous
	 * houses, and make sure the previous house doesn't paint with the same
	 * color.
	 * 
	 * We can use min1 and min2 to track the indices of the 1st and 2nd smallest
	 * cost till previous house, if the current color's index is same as min1,
	 * then we have to go with min2, otherwise we can safely go with min1.
	 * 
	 * The code below modifies the value of costs[][] so we don't need extra
	 * space.
	 * 
	 * @param costs
	 * @return
	 */
	public int minCostIIACSolution(int[][] costs) {
		if (costs == null || costs.length == 0)
			return 0;

		int n = costs.length, k = costs[0].length;
		// min1 is the index of the 1st-smallest cost till previous house
		// min2 is the index of the 2nd-smallest cost till previous house
		int min1 = -1, min2 = -1;

		for (int i = 0; i < n; i++) {
			int last1 = min1, last2 = min2;
			min1 = -1;
			min2 = -1;

			for (int j = 0; j < k; j++) {
				if (j != last1) {
					// current color j is different to last min1
					costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
				} else {
					costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
				}

				// find the indices of 1st and 2nd smallest cost of painting current
				// house i
				if (min1 < 0 || costs[i][j] < costs[i][min1]) {
					min2 = min1;
					min1 = j;
				} else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
					min2 = j;
				}
			}
		}

		return costs[n - 1][min1];
	}

	/**
	 * Fast DP Java solution Runtime O(nk) space O(1) Explanation: dp[i][j]
	 * represents the min paint cost from house 0 to house i when house i use
	 * color j; The formula will be dp[i][j] = Math.min(any k!= j| dp[i-1][k]) +
	 * costs[i][j].
	 * 
	 * Take a closer look at the formula, we don't need an array to represent
	 * dp[i][j], we only need to know the min cost to the previous house of any
	 * color and if the color j is used on previous house to get prev min cost,
	 * use the second min cost that are not using color j on the previous house.
	 * So I have three variable to record: prevMin, prevMinColor, prevSecondMin.
	 * and the above formula will be translated into:
	 * dp[currentHouse][currentColor] = (currentColor == prevMinColor?
	 * prevSecondMin: prevMin) + costs[currentHouse][currentColor].
	 * 
	 * @param costs
	 * @return
	 */
	public int minCostIIDP(int[][] costs) {
		if (costs == null || costs.length == 0 || costs[0].length == 0)
			return 0;

		int n = costs.length, k = costs[0].length;
		if (k == 1)
			return (n == 1 ? costs[0][0] : -1);

		int prevMin = 0, prevMinInd = -1, prevSecMin = 0;// prevSecMin always >=
																		 // prevMin
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE, minInd = -1, secMin = Integer.MAX_VALUE;
			for (int j = 0; j < k; j++) {
				int val = costs[i][j] + (j == prevMinInd ? prevSecMin : prevMin);
				if (minInd < 0) {
					min = val;
					minInd = j;
				} // when min isn't initialized
				else if (val < min) {// when val < min,
					secMin = min;
					min = val;
					minInd = j;
				} else if (val < secMin) { // when min<=val< secMin
					secMin = val;
				}
			}
			prevMin = min;
			prevMinInd = minInd;
			prevSecMin = secMin;
		}
		return prevMin;
	}

	/**
	 * Easiest O(1) space JAVA solution
	 * 
	 * To solve this DP problem:
	 * 
	 * If there's no constraint, we choose min cost for each house.
	 * 
	 * Since house[i] and house[i - 1] cannot have the same color j, we should
	 * choose 2nd min color for house[i - 1].
	 * 
	 * If we choose the 3rd min color for house[i - 1], we might miss potential
	 * min cost.
	 * 
	 * min(i) = min(cost[i][j] + 1st min / 2nd min), 0 < j < n.
	 * 
	 * Since current row only relies on last row for getting mins and avoiding
	 * same color, O(1) space is enough.
	 * 
	 * @param costs
	 * @return
	 */
	public int minCostIIEasy(int[][] costs) {
		if (costs.length == 0) {
			return 0;
		}
		int min1 = 0, min2 = 0, index1 = -1;

		for (int i = 0; i < costs.length; i++) {
			int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, idx1 = -1;

			for (int j = 0; j < costs[0].length; j++) {
				int cost = costs[i][j] + (j != index1 ? min1 : min2);

				if (cost < m1) { // cost < m1 < m2
					m2 = m1;
					m1 = cost;
					idx1 = j;

				} else if (cost < m2) { // m1 < cost < m2
					m2 = cost;
				}
			}

			min1 = m1;
			min2 = m2;
			index1 = idx1;
		}
		return min1;
	}

	/**
	 * Accepted Simple JAVA O(NK) solution
	 * 
	 * @param costs
	 * @return
	 */
	public int minCostIIAccepted(int[][] costs) {
		if (costs.length == 0 || costs[0].length == 0) {
			return 0;
		}
		int m = costs.length, n = costs[0].length, m1 = 0, m2 = 0;
		int[] dp = new int[n];
		for (int i = 0; i < m; i++) {
			int t1 = m1, t2 = m2;
			m1 = Integer.MAX_VALUE;
			m2 = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				dp[j] = (dp[j] == t1 ? t2 : t1) + costs[i][j];
				if (m1 <= dp[j]) {
					m2 = Math.min(dp[j], m2);
				} else {
					m2 = m1;
					m1 = dp[j];
				}
			}
		}

		return m1;
	}
}
