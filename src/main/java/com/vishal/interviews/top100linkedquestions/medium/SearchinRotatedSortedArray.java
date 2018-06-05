package com.vishal.interviews.top100linkedquestions.medium;

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {

	}

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int i = 0;
		int j = nums.length - 1;

		while (i <= j) {
			int m = i + (j - i) / 2;
			if (target == nums[m]) {
				return m;
			}

			if (nums[m] > nums[i]) {
				if (target >= nums[i] && target < nums[m]) {
					j = m - 1;
				} else {
					i = m + 1;
				}
			} else if (nums[m] < nums[i]) {
				if (target > nums[m] && target <= nums[j]) {
					i = m + 1;
				} else {
					j = m - 1;
				}
			} else {
				i++;
			}
		}
		return -1;
	}

}
