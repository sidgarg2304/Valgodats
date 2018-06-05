package com.vishal.interviews.top100linkedquestions.medium;

public class BestTimetoBuyandSellStockwithCooldown {

	public static void main(String[] args) {

	}

	public int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0) {
			return 0;
		}

		int sellOnIthDay = 0;
		int notSellOnIthDay = 0;

		for (int i = 1; i < prices.length; i++) {
			int temp = sellOnIthDay;
			sellOnIthDay = Math.max(notSellOnIthDay + prices[i] - prices[i - 1], notSellOnIthDay);
			notSellOnIthDay = Math.max(notSellOnIthDay, temp);
		}

		return Math.max(sellOnIthDay, notSellOnIthDay);
	}

}
