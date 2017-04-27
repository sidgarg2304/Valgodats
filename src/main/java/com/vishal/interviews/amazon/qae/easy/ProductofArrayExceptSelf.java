package com.vishal.interviews.amazon.qae.easy;

/**
 * Given an array of numbers, return a new array where each element contains the
 * product of all other numbers. Given [3, 2, 3, 0, 5, 0 8 , 0 , 9], return the
 * array [120, 60, 40, 30, 24]
 *
 */
public class ProductofArrayExceptSelf {

	public static void main(String[] args) {

	}

	public int[] productExceptSelf(int[] nums) {

		if (nums == null) {
			return nums;
		}

		int res[] = new int[nums.length];
		if (nums.length == 0) {
			return res;
		}

		res[0] = 1;

		for (int i = 1; i < nums.length; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}

		int right = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			int curRes = right * nums[i + 1];
			res[i] *= curRes;
			right = curRes;
		}

		return res;

	}

}
