package com.vishal.interviews.topinterviewquestions.medium;

public class FindtheDuplicateNumber {

	public static void main(String[] args) {

	}

	public int findDuplicate(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return -1;
		}
		for (int i = 0; i < nums.length; i++) {
			int pos = Math.abs(nums[i]) - 1;
			if (nums[pos] < 0) {
				return Math.abs(nums[i]);
			} else {
				nums[pos] = -nums[pos];
			}
		}
		return -1;
	}

}
