package com.vishal.interviews.amazon.qae.easy;

/**
 * Find the longest running positive sequence in an array - Eg -
 * [1,2,-3,2,3,4,-6,1,2,3,4,5,-8,5,6] It should return 5, with start index : 8
 *
 */
public class LongestRunningPositiveSubarray {

	public static void main(String[] args) {

		System.out.println(longestRunningSequence(new int[] { 1, 2, -3, 2, 3, 4, -6, 1, 2, 3, 4, 5, -8, 5, 6 }));
		System.out.println(longestRunningSequence(new int[] { 1, 2, -1, 3, 4, 5 }));
		System.out.println(longestRunningSequence(new int[] { 4, 6, 1, 2, -1, 3, 4, 5 }));
	}

	static int longestRunningSequence(int[] nums) {

		int ct = nums[0] > 0 ? 1 : 0;

		int maxCt = ct;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > 0) {
				ct++;
			} else {
				maxCt = Math.max(ct, maxCt);
				ct = 0;
			}
		}

		maxCt = Math.max(ct, maxCt);

		return maxCt;
	}
}
