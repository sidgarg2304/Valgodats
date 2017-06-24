package com.vishal.interviews.programcreek;

public class FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {

	}

	public int findMin(int[] nums) {
		int i = 0;
		int j = nums.length - 1;

		while (i <= j) {

			if (nums[i] <= nums[j]) {
				return i;
			}

			int m = i + (j - i) / 2;

			if (nums[m] > nums[j]) {
				i = m + 1;
			} else {
				j = m;
			}
		}
		return -1;
	}

}
