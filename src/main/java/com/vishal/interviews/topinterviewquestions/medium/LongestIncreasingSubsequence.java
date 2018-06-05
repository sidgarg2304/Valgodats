package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

	}

	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int res = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
					res = Math.max(res, dp[i]);
				}
			}
		}
		return res;
	}

}
