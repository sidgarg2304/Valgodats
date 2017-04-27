package com.vishal.interviews.facebook.medium;

/**
 * 238. Product of Array Except Self
 * 
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].
 *
 */
public class ProductofArrayExceptSelf {

	public static void main(String[] args) {

	}

	public static int[] productExceptSelf(int[] nums) {

		int[] res = new int[nums.length];

		res[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}

		int right = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			int curRes = right * nums[i+1];
			res[i] *= curRes;
			right = curRes;
		}

		return res;
	}

}
