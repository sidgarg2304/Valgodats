package com.vishal.interviews.top100linkedquestions.easy;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {

	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}

		int res = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			res = Math.max(res, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		return res;
	}

}
