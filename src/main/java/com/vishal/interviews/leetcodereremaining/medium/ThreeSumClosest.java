package com.vishal.interviews.leetcodereremaining.medium;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {

	}

	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);

		int res = 0;
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];

				if (sum == target) {
					return 0;
				}

				if (Math.abs(sum - target) < minDiff) {
					minDiff = Math.abs(sum - target);
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
