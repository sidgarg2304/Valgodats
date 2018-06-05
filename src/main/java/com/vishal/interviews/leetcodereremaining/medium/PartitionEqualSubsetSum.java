package com.vishal.interviews.leetcodereremaining.medium;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * 
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 *
 */
public class PartitionEqualSubsetSum {

	public static void main(String[] args) {

		System.out.println(canPartition(new int[] { 1, 5, 11, 5 }));
	}

	public static boolean canPartition(int[] nums) {

		if (nums == null || nums.length <= 1) {
			return false;
		}

		int sum = 0;
		for (int i : nums) {
			sum += i;
		}

		if (sum % 2 != 0) {
			return false;
		}

		sum /= 2; // can there be 2 possible ways to get this sum from all the
					 // given numbers

		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;

		for (int num : nums) {
			for (int j = sum; j >= 0; j--) {
				if (j - num >= 0) {
					dp[j] = dp[j] || dp[j - num];
				}
			}
			System.out.println(Arrays.toString(dp));
		}
		return dp[sum];

	}

}
