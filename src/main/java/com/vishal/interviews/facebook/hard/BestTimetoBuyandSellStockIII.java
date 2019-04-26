package com.vishal.interviews.facebook.hard;

public class BestTimetoBuyandSellStockIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0) {
			return 0;
		}

		int[] left = new int[prices.length];
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			left[i] = Math.max(left[i - 1], prices[i] - min);
			min = Math.min(min, prices[i]);
		}

		int[] right = new int[prices.length];
		int max = prices[prices.length - 1];
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
