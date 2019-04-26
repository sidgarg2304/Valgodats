package com.vishal.interviews.facebook.medium;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	
	public boolean canJumpDP(int[] nums) {
      boolean[] dp = new boolean[nums.length];
		dp[0] = true;

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (j + nums[j] >= i) {
					dp[i] |= dp[j];
				}
			}
		}

		return dp[nums.length - 1];
  }

}
