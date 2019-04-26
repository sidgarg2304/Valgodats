package com.vishal.interviews.facebook.medium;

public class FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findMin(int[] nums) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		int st = 0;
		int en = nums.length - 1;

		while (st <= en) {
			if (nums[st] <= nums[en]) {
				return nums[st];
			}
			int m = st + (en - st) / 2;

			if (nums[m] > nums[en]) {
				st = m + 1;
			} else {
				en = m ;
			}
		}
		return -1;
	}

}
