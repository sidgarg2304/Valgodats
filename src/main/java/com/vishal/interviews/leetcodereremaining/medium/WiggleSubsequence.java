package com.vishal.interviews.leetcodereremaining.medium;

/**
 * 376. Wiggle Subsequence
 *
 */
public class WiggleSubsequence {

	public static void main(String[] args) {

	}

	public int wiggleMaxLength(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int inc = 1;
		int dec = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				inc = dec + 1;
			} else if (nums[i] < nums[i - 1]) {
				dec = inc + 1;
			}
		}

		return Math.min(inc, dec);
	}

}
