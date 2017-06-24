package com.vishal.interviews.programcreek.math;

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {

	}

	public int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];

		result[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			result[i] = result[i - 1] * nums[i - 1];
		}

		int right = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			int curVal = right * nums[i + 1];
			result[i] *= curVal;
			right = curVal;
		}

		return result;
	}

}
