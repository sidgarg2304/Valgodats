package com.vishal.interviews.uber.hard;

public class FirstMissingPositive {

	public static void main(String[] args) {

	}

	public int firstMissingPositive(int[] nums) {

		boolean contains1 = false;
		for (int i : nums) {
			if (i == 1) {
				contains1 = true;
				break;
			}
		}

		if (!contains1) {
			return 1;
		}

		if (nums.length == 1) {
			return 2;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0 || nums[i] > nums.length) {
				nums[i] = 1;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			int pos = Math.abs(nums[i]) - 1;
			nums[pos] = -Math.abs(nums[pos]);
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

}
