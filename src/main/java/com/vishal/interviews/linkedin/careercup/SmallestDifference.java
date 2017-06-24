package com.vishal.interviews.linkedin.careercup;

/**
 * You have two arrays of integers, where the integers do not repeat and the two
 * arrays have no common integers.
 * 
 * Let x be any integer in the first array, y any integer in the second. Find
 * min(Abs(x-y)). That is, find the smallest difference between any of the
 * integers in the two arrays.
 * 
 * Assumptions: Assume both arrays are sorted in ascending order.
 *
 * 
 */
public class SmallestDifference {

	public static void main(String[] args) {

		System.out.println(smallestDifference(new int[] { 1, 4, 7 }, new int[] { 3, 8, 11 }));
	}

	// 1 4 7
	// 3 8 11
	static int smallestDifference(int[] nums1, int[] nums2) {

		int res = Integer.MAX_VALUE;

		int i = 0;
		int j = 0;

		while (i < nums1.length && j < nums2.length) {
			res = Math.min(res, Math.abs(nums1[i] - nums2[j]));
			if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		return res;
	}

}
