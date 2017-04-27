package com.vishal.interviews.amazon.easy;

/**
 * 121. Best Time to Buy and Sell Stock
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {

	}
	
	/**
	 * Kadane's Algorithm - Since no one has mentioned about this so far :) (In case if interviewer twists the input)
	 * 
	 * The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm. Since no body has mentioned this so far, I thought it's a good thing for everybody to know.

All the straight forward solution should work, but if the interviewer twists the question slightly by giving the difference array of prices, Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7}, you might end up being confused.

Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.


	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int maxCur = 0, maxSoFar = 0;
		for (int i = 1; i < prices.length; i++) {
			maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
			maxSoFar = Math.max(maxCur, maxSoFar);
		}
		return maxSoFar;
	}
	
	/**
	 * The idea is to find so far min price.
	 * @param prices
	 * @return
	 */
	public int maxProfitAccepted(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int max = 0;
		int sofarMin = prices[0];
		for (int i = 0; i < prices.length; ++i) {
			if (prices[i] > sofarMin) {
				max = Math.max(max, prices[i] - sofarMin);
			} else {
				sofarMin = prices[i];
			}
		}
		return max;
	}
	
	/**
	 * A O(1*n) solution
1.for prices[0] .... prices[n], prices[n+1].....
if (prices[n] < prices[0]) then, the max profit is in prices[0]...prices[n], or begin from prices[n+1],
otherwise, suppose prices[n+1] > prices[0], and max profit is happened between prices[n+1] , and
pricesn+k, then if we buy at day 0, and sell at day n+k, we get a bigger profit.

Base on logic above, we can have a O(1*n) solution:
	 * @param prices
	 * @return
	 */
	public int maxProfitO1(int[] prices) {

		if (prices.length == 0) {
			return 0;
		}

		int max = 0, min = prices[0];
		int profit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < min) {

				min = prices[i];
			} else {
				if (prices[i] - min > profit) {
					profit = prices[i] - min;
				}

			}
		}

		return profit;

	}

}
