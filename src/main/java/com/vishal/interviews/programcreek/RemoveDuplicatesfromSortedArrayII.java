package com.vishal.interviews.programcreek;

public class RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {

	}

	public int removeDuplicates(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int r = 1;
		int cnt = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				cnt++;
			} else {
				cnt = 1;
			}
			if (cnt <= 2) {
				nums[r++] = nums[i];
			}
		}
		return r;
	}

}
