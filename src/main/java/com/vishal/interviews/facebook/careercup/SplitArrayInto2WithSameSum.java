package com.vishal.interviews.facebook.careercup;

/**
 * Given an array of integers greater than zero, find if it is possible to split
 * it in two (without reordering the elements), such that the sum of the two
 * resulting arrays is the same. Print the resulting arrays.
 *
 */
public class SplitArrayInto2WithSameSum {

	public static void main(String[] args) {

		System.out.println(canSplit(new int[] { -1, 2, 3, 4 }));
	}

	static boolean canSplit(int[] nums) {
		int[] prefixSum = new int[nums.length];
		prefixSum[0] = nums[0];
		int totalSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i];
			totalSum += nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			int left = prefixSum[i];
			int right = totalSum - prefixSum[i];
			if (left == right) {
				System.out.println("left arr stops at " + i);
				return true;
			}
		}

		return false;
	}
}
