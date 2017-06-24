package com.vishal.interviews.programcreek;

public class SearchInsertPosition {

	public static void main(String[] args) {

	}

	public int searchInsert(int[] nums, int target) {
		if (nums == null) {
			return -1;
		}

		if (nums.length == 0) {
			return 0;
		}

		if (target > nums[nums.length - 1]) {
			return nums.length;
		}

		int i = 0;
		int j = nums.length - 1;

		while (i <= j) {
			int m = (i + j) / 2;
			if (nums[m] == target) {
				return m;
			} else if (target < nums[m]) {
				j = m - 1;
			} else {
				i = m + 1;
			}
		}

		return target < nums[i] ? i : i + 1;
	}

}
