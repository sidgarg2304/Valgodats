package com.vishal.interviews.uber.medium;

public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findDuplicate(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			int pos = Math.abs(nums[i]) - 1;
			if (nums[pos] < 0) {
				return pos + 1;
			}
			nums[pos] = -nums[pos];
		}
		return -1;
	}

}
