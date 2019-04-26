package com.vishal.interviews.facebook.medium;

public class SearchinRotatedSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean search(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return false;
		}

		int i = 0;
		int j = nums.length - 1;

		while (i <= j) {
			int m = i + (j - i) / 2;
			if (nums[m] == target) {
				return true;
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
		return false;
	}

}
