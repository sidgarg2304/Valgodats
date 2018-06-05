package com.vishal.interviews.top100linkedquestions.easy;

public class MoveZeroes {

	public static void main(String[] args) {

	}

	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int r = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[r++] = nums[i];
			}
		}

		while (r < nums.length) {
			nums[r++] = 0;
		}
	}

}
