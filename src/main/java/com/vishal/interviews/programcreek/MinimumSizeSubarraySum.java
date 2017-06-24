package com.vishal.interviews.programcreek;

/**
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length of 2 under the problem constraint.
 *
 */
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {

	}

	public int minSubArrayLen(int s, int[] nums) {

		int res = Integer.MAX_VALUE;
		int st = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			while (st < nums.length && sum >= s) {
				res = Math.min(res, i - st + 1);
				sum -= nums[st++];
			}

		}

		return res == Integer.MAX_VALUE ? 0 : res;
	}

}
