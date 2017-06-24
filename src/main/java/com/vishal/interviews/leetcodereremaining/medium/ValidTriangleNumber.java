package com.vishal.interviews.leetcodereremaining.medium;

import java.util.Arrays;

/**
 * 611. Valid Triangle Number
 *
 */
public class ValidTriangleNumber {

	public static void main(String[] args) {

	}

	public int triangleNumber(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);

		int res = 0;
		for (int i = nums.length - 1; i >= 2; i--) {
			int l = 0;
			int r = i - 1;

			while (l < r) {
				if (nums[l] + nums[r] > nums[i]) {
					res += r - l;
					r--;
				} else {
					l++;
				}
			}
		}
		return res;
	}

}
