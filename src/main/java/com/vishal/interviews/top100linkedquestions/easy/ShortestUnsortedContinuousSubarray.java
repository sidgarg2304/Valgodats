package com.vishal.interviews.top100linkedquestions.easy;

public class ShortestUnsortedContinuousSubarray {

	public static void main(String[] args) {

		findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 });
	}

	public static int findUnsortedSubarray(int[] nums) {

		if (nums == null || nums.length <= 1) {
			return 0;
		}

		int max = nums[0];
		int min = nums[nums.length - 1];

		int en = -2;
		int st = -1;

		for (int i = 1; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			if (nums[i] < max) {
				en = i;
			}
		}

		for (int i = nums.length - 2; i >= 0; i--) {
			min = Math.min(min, nums[i]);
			if (nums[i] > min) {
				st = i;
			}
		}
		
		return en - st + 1;

	}

}
