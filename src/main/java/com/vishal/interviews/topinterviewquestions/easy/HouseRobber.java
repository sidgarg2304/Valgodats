package com.vishal.interviews.topinterviewquestions.easy;

public class HouseRobber {

	public static void main(String[] args) {

	}

	public int rob(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int p = nums[0];
		int c = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			int cur = Math.max(p + nums[i], c);
			p = c;
			c = cur;
		}
		return Math.max(p, c);

	}

}
