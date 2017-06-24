package com.vishal.interviews.amazon.qae.easy;

/**
 * 334. Increasing Triplet Subsequence
 * 
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.


 *
 */
public class IncreasingTripletSubsequence {

	public static void main(String[] args) {

	}

	public boolean increasingTriplet(int[] nums) {
		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] <= x) {
				// got a number less than x so , reset the increasing sequence
				x = nums[i];
			} else if (nums[i] <= y) {
				// got a number less than y
				y = nums[i];
			} else {
				// got a number greater than y and hence triplet found
				return true;
			}
		}

		return false;
	}

}
