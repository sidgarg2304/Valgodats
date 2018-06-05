package com.vishal.interviews.leetcodereremaining;

import java.util.*;

/**
 * 628. Maximum Product of Three Numbers
 * 
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
Example 2:
Input: [1,2,3,4]
Output: 24
 *
 */
public class MaximumProductofThreeNumbers {

	public static void main(String[] args) {

	}

	public int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		return Math.max(nums[0] * nums[1] * nums[n - 1], 
				nums[n - 1] * nums[n - 2] * nums[n - 3]);
	}

}
