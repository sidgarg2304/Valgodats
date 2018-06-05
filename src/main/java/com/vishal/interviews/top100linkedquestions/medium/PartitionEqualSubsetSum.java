package com.vishal.interviews.top100linkedquestions.medium;

public class PartitionEqualSubsetSum {

	public static void main(String[] args) {

	}

	public boolean canPartition(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return false;
		}

		int sum = 0;
		for (int i : nums) {
			sum += i;
		}

		sum /= 2;

		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		for (int i = 0; i < nums.length; i++) {
			for (int s = sum; s > 0; s++) {
				if (s - nums[i] > 0) {
					dp[s] = dp[s] || dp[s - nums[i]];
				}
			}
		}
		return dp[sum];
	}
}
