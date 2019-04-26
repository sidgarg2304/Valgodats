package com.vishal.interviews.facebook.medium;

import java.util.Arrays;

public class ThreeSumSmaller {

	public static void main(String[] args) {

	}

	public int threeSumSmaller(int[] nums, int target) {

		int res = 0;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < target) {
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
