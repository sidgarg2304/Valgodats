package com.vishal.interviews.facebook.careercup;

/**
 * find maximum contiguous subarray sum with size (the number of the element in
 * the subarray) <= k a brute force method is very simple, can you do it better?
 *
 */
public class MaxSumSubArrayWithSize {

	public static void main(String[] args) {

	}

	public int maxSum(int[] nums, int k) {

		int curSum = 0;
		int maxSum = Integer.MIN_VALUE;
		int st = 0;

		for (int i = 0; i < nums.length; i++) {

			if (curSum < 0) {
				curSum = 0;
				st = i;
			}

			curSum += nums[i];
			
			if (i - st + 1 > k) {
				curSum -= nums[st++];
			}
			
			maxSum = Math.max(maxSum, curSum);
		}
		
		return maxSum;
	}

}
