package com.vishal.interviews.programcreek;

public class FindMinimuminRotatedSortedArrayII {

	public static void main(String[] args) {

	}

	public int findMin(int[] nums) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		int i = 0;
		int j = nums.length - 1;

		while (i <= j) {
			while (nums[i] == nums[j] && i != j) {
				i++;
			}

			if (nums[i] <= nums[j]) {
				return nums[i];
			}
			
			int m = i + (j - i) / 2;

			if (nums[m] > nums[i]) {
				i = m + 1;
			} else {
				j = m;
			}
		}
		return -1;
	}
}
