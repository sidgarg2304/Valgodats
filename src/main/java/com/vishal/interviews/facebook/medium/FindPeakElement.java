package com.vishal.interviews.facebook.medium;

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

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
