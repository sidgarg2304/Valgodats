package com.vishal.interviews.programcreek.combinationsandpermutations;

public class CombinationSumIV {

	public static void main(String[] args) {

	}

	public int combinationSum4(int[] nums, int target) {

		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int sum = 1; sum <= target; sum++) {
			for (int j = 0; j < nums.length; j++) {
				if (j - nums[j] >= 0) {
					dp[sum] += dp[j - nums[j]];
				}
			}
		}

		return dp[target];
	}

}
