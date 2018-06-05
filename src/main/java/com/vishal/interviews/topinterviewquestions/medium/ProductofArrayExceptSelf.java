package com.vishal.interviews.topinterviewquestions.medium;

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {

	}

	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0) {
			return nums;
		}

		int[] res = new int[nums.length];
		res[0] = 1;

		for (int i = 1; i < nums.length; i++) {
			res[i] = nums[i - 1] * res[i - 1];
		}

		int right = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			right *= nums[i + 1];
			res[i] *= right;			
		}
		return res;
	}

}
