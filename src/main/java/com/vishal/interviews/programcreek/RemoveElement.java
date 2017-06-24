package com.vishal.interviews.programcreek;

public class RemoveElement {

	public static void main(String[] args) {

	}

	public int removeElement(int[] nums, int elem) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int r = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != elem) {
				nums[r++] = nums[i];
			}
		}
		return r;
	}

}
