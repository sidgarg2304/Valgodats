package com.vishal.interviews.top100linkedquestions.medium;

public class JumpGame {

	public static void main(String[] args) {

	}

	public boolean canJump(int[] nums) {

		if (nums == null || nums.length <= 1) {
			return true;
		}

		int p = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0 && p <= i) {
				return false;
			}

			p = Math.max(p, i + nums[i]);
			if (p >= nums.length - 1) {
				return true;
			}
		}
		return false;
	}

}
