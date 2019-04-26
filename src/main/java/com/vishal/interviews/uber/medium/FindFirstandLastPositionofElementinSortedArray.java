package com.vishal.interviews.uber.medium;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {

	public static void main(String[] args) {

	}

	public int[] searchRange(int[] nums, int target) {

		int[] res = new int[2];
		Arrays.fill(res, -1);

		if (nums == null || nums.length == 0) {
			return res;
		}

		int i = 0;
		int j = nums.length - 1;
		while (i <= j) {
			int m = i + (j - i) / 2;
			if (nums[m] == target) {
				int l = m;
				while (l >= 0 && nums[l] == target) {
					l--;
				}
				res[0] = l + 1;

				int r = m;
				while (r < nums.length && nums[r] == target) {
					r++;
				}
				res[1] = r - 1;

				return res;
			} else if (nums[m] < target) {
				i++;
			} else {
				j--;
			}
		}
		return res;
	}

}
