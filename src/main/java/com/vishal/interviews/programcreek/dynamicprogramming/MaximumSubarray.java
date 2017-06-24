package com.vishal.interviews.programcreek.dynamicprogramming;

public class MaximumSubarray {

	public static void main(String[] args) {

	}

	public int maxSubArray(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int curSum = nums[0];
		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {

			curSum = Math.max(nums[i], curSum + nums[i]);

			res = Math.max(curSum, res);
		}

		return res;
	}
}
