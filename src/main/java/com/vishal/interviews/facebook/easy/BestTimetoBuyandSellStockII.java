package com.vishal.interviews.facebook.easy;

public class BestTimetoBuyandSellStockII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}

		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			int curDiff = prices[i] - prices[i-1];
			if(curDiff > 0){
				res += curDiff;
			}
		}

		return res;
	}

}
