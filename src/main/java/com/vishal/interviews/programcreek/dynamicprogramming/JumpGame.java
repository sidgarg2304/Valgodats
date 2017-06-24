package com.vishal.interviews.programcreek.dynamicprogramming;

public class JumpGame {

	public static void main(String[] args) {

	}

	public boolean canJump(int[] nums) {

		if (nums == null || nums.length <= 1) {
			return true;
		}

		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			
			if (max <= i && nums[i] == 0) {
				return false;
			}
			
			max = Math.max(max, nums[i] + i);
			if (max >= nums.length - 1) {
				return true;
			}
		}
		return false;
	}

}
