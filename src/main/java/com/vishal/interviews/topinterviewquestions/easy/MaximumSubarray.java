package com.vishal.interviews.topinterviewquestions.easy;

public class MaximumSubarray {

	public static void main(String[] args) {

	}

	public int maxSubArray(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int maxSum = nums[0];
		int curSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			curSum = Math.max(curSum + nums[i], nums[i]);
			maxSum = Math.max(maxSum, curSum);
		}
		return maxSum;
	}

}
