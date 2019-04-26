package com.vishal.interviews.facebook.medium;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean canPartition(int[] nums) {

		if (nums == null || nums.length <= 1) {
			return false;
		}

		int sum = 0;
		for (int i : nums) {
			sum += i;
		}

		if (sum % 2 != 0) {
			return false;
		}

		sum /= 2; // can there be 2 possible ways to get this sum from all the
					 // given numbers

		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;

		for (int num : nums) {
			for (int j = sum; j >= 0; j--) {
				if (j - num >= 0) {
					dp[j] = dp[j] || dp[j - num];
				}
			}
			System.out.println(Arrays.toString(dp));
		}
		return dp[sum];

	}

}
