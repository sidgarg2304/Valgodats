package com.vishal.interviews.top100linkedquestions.medium;

public class FindtheDuplicateNumber {

	public static void main(String[] args) {

	}

	public int findDuplicate(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			int p = Math.abs(nums[i]) - 1;
			if (nums[p] < 0) {
				return Math.abs(nums[i]);
			} else {
				nums[p] *= -1;
			}
		}

		return -1;
	}

}
