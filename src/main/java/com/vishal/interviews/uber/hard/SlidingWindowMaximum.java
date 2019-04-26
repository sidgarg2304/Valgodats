package com.vishal.interviews.uber.hard;

public class SlidingWindowMaximum {

	public static void main(String[] args) {

	}

	public int[] maxSlidingWindow(int[] nums, int k) {

		if (nums == null || nums.length == 0) {
			return new int[] {};
		}

		int[] res = new int[nums.length - k + 1];

		int maxVal = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = 0; i < k; i++) {
			if (nums[i] > maxVal) {
				maxVal = nums[i];
				maxIndex = i;
			}
		}
		res[0] = maxVal;

		int r = 1;
		for (int i = k; i < nums.length; i++) {
			if (maxIndex <= i - k) {
				maxVal = nums[i];
				maxIndex = i;
				for (int j = i - k + 1; j <= i; j++) {
					if (nums[j] > maxVal) {
						maxVal = nums[j];
						maxIndex = j;
					}
				}
			} else {
				if (nums[i] > maxVal) {
					maxVal = nums[i];
					maxIndex = i;
				}
			}
			res[r++] = maxVal;
		}
		return res;
	}

}
