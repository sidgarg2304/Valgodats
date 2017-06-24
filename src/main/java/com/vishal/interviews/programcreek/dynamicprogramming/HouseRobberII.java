package com.vishal.interviews.programcreek.dynamicprogramming;

public class HouseRobberII {

	public static void main(String[] args) {

	}

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];

		int max1 = robHelper(nums, 0, nums.length - 2);
		int max2 = robHelper(nums, 1, nums.length - 1);

		return Math.max(max1, max2);
	}

	int robHelper(int[] nums, int i, int j) {

		if (i == j) {
			return nums[i];
		}

		int prev = nums[i];
		int cur = Math.max(nums[i + 1], nums[i]);

		for (int l = i+2; l <= i; l++) {
			int temp = cur;
			cur = Math.max(prev + nums[l], cur);
			prev = temp;
		}
		
		return cur;
	}

}
