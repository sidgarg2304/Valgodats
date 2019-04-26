package com.vishal.interviews.facebook.easy;

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxSubArray(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int maxSum = Integer.MIN_VALUE;
		int curSum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (curSum < 0) {
				curSum = nums[i];
			} else {
				curSum += nums[i];
			}
			maxSum = Math.max(curSum, maxSum);
		}
		return maxSum;

	}
}
