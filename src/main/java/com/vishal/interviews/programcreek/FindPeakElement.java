package com.vishal.interviews.programcreek;

public class FindPeakElement {

	public static void main(String[] args) {

	}

	public int findPeakElement(int[] nums) {
		int i = 0;
		int j = nums.length - 1;

		while (i < j) {
			int m = i + (j - i) / 2;
			if (nums[m] > nums[m + 1]) {
				j = m;
			} else {
				i = m + 1;
			}
		}

		return i;
	}

}
