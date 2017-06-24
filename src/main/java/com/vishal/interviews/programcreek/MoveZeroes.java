package com.vishal.interviews.programcreek;

public class MoveZeroes {

	public static void main(String[] args) {

	}

	public void moveZeroes(int[] nums) {

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
