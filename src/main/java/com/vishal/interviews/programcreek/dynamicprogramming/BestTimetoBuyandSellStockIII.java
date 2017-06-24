package com.vishal.interviews.programcreek.dynamicprogramming;

public class BestTimetoBuyandSellStockIII {

	public static void main(String[] args) {

	}

	public int maxProfit(int[] prices) {

		if (prices == null || prices.length < 2) {
			return 0;
		}

		int[] left = new int[prices.length];
		int[] right = new int[prices.length];

		left[0] = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			left[i] = Math.max(left[i - 1], prices[i] - min);
			min = Math.min(min, prices[i]);
		}

		right[right.length - 1] = 0;
		int max = prices[right.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], max - prices[i]);
			max = Math.max(max, prices[i]);
		}

		int res = 0;
		for (int i = 0; i < prices.length; i++) {
			res = Math.max(left[i] + right[i], res);
		}

		return res;

	}

}
