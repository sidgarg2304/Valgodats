package com.vishal.interviews.programcreek.dynamicprogramming;

public class HouseRobber {

	public static void main(String[] args) {

	}

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int prev = nums[0];
		int cur = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			int temp = cur;
			cur = Math.max(cur, prev + nums[i]);
			prev = temp;
		}

		return cur;
	}

}
