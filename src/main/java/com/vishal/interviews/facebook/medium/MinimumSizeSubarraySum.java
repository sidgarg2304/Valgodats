package com.vishal.interviews.facebook.medium;

/**
 * 209. Minimum Size Subarray Sum
 * 
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 *
 */
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {

	}

	public int minSubArrayLen(int s, int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int res = Integer.MAX_VALUE;
		int st = 0;
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {

			sum += nums[i];

			while (sum >= s) {
				res = Math.min(res, (i - st + 1));
				if (res == 1) {
					return res;
				}
				sum -= nums[st];
				st++;
			}

		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}

	public int minSubArrayLen1(int s, int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int res = Integer.MAX_VALUE;
		int st = 0;
		int sum = 0;

		int i = 0;
		while (i < nums.length) {
			if (sum < s) {
				sum += nums[i];
				i++;
			} else {
				res = Math.min(res, (i - st));
				if (res == 1) {
					return res;
				}
				sum -= nums[st];
				st++;
			}
		}

		while (sum >= s) {
			res = Math.min(res, (i - st));
			sum -= nums[st++];
		}

		return res == Integer.MAX_VALUE ? 0 : res;
	}

}
