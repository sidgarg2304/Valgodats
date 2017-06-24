package com.vishal.interviews.programcreek.dynamicprogramming;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

	}

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int max = 1;
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
					max = Math.max(max, dp[i]);
				}
			}
		}

		return max;
	}

}
