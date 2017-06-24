package com.vishal.interviews.google.easy;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * 
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.
 * 
 * You need to find the shortest such subarray and output its length.
 * 
 * Example 1: Input: [2, 6, 4, 8, 10, 9, 15] Output: 5 Explanation: You need to
 * sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in
 * ascending order. Note: Then length of the input array is in range [1,
 * 10,000]. The input array may contain duplicates, so ascending order here
 * means <=.
 *
 */
public class ShortestUnsortedContinuousSubarray {

	public static void main(String[] args) {

	}

	public int findUnsortedSubarray(int[] nums) {

		int n = nums.length;
		int max = nums[0];
		int min = nums[nums.length - 1];

		int st = -1;
		int en = -1;

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
