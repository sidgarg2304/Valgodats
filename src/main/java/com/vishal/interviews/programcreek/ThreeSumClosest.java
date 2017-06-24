package com.vishal.interviews.programcreek;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {

	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		int min = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];

				int diff = Math.abs(sum - target);
				if (diff == 0) {
					return sum;
				}
				if (diff < min) {
					res = sum;
					min = diff;
				}

				if (sum <= target) {
					res += k - j;
					j++;
				} else {
					k--;
				}
			}
		}

		return res;
	}

}
