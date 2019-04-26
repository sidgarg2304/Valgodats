package com.vishal.interviews.facebook.medium;

public class MaximumSumCircularSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxSubarraySumCircular(int[] A) {

		int total = 0;
		int maxSum = Integer.MIN_VALUE;
		int curMax = 0;
		int curMin = 0;
		int minSum = Integer.MAX_VALUE;

		for (int a : A) {
			curMax = Math.max(a, a + curMax);
			maxSum = Math.max(curMax, maxSum);

			curMin = Math.min(a, a + curMin);
			minSum = Math.min(minSum, curMin);

			total += a;
		}

		return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
	}

}
