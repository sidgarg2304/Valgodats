package com.vishal.interviews.uber.medium;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {

	}

	public int threeSumClosest(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int res = 0;
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == target) {
					return sum;
				}

				int diff = Math.abs(sum - target);
				if (diff < minDiff) {
					minDiff = diff;
					res = sum;
				}

				if (sum < target) {
					j++;
				} else {
					k--;
				}
			}
		}
		return res;
	}

}
