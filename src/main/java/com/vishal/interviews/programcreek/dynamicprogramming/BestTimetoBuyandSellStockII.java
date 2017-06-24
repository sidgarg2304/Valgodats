package com.vishal.interviews.programcreek.dynamicprogramming;

public class BestTimetoBuyandSellStockII {

	public static void main(String[] args) {

	}
	
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length ==0){
			return 0;
		}
		
		int max = 0;
		for(int i = 1; i< prices.length; i++){
			int curProfit = prices[i] - prices[i-1];
			if(curProfit > 0){
				max += curProfit;
			}
		}
		return max;
	}

}
