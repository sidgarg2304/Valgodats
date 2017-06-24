package com.vishal.interviews.programcreek.dynamicprogramming;

public class MaximumProductSubarray {

	public static void main(String[] args) {

	}

	public int maxProduct(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int min = nums[0];
		int max = nums[0];
		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int minCopy = min;
			min = Math.min(max * nums[i], Math.min(min * nums[i], nums[i]));
			max = Math.max(max * nums[i], Math.max(minCopy * nums[i], nums[i]));

			res = Math.max(max, res);
		}

		return res;
	}
}
