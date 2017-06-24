package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;
/**
 * 462. Minimum Moves to Equal Array Elements II
 * 
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 *
 */
public class MinimumMovestoEqualArrayElementsII {

	public static void main(String[] args) {

		System.out.println(minMoves2(new int[] { 1, 2, 3, 4, 5 }));
	}

	/**
	 * Assume you have 1 2 3 4 5
	 * Moving all elements to mid 3 is optimal solution
	 * Bringing 1 to 3 and Bringing 5 to 3 is same as Bringing 5 to 1
	 * Bringing 2 to 3 and Bringing 4 to 3 is same as Bringing 4 to 2
	 */
	public static int minMoves2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		Arrays.sort(nums);
		int res = 0;
		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			res += nums[j] - nums[i];
			i++;
			j--;
		}
		return res;
	}

	// (lowerNum * k - (sum of lower) ) + ((sum of higher) - higherNum * k )
	public static int minMoves2LongSolution(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		long moves = Integer.MAX_VALUE;
		Arrays.sort(nums);
		long totalSum = 0L;
		long sum = 0L;
		for (int i = 0; i < nums.length; i++) {
			totalSum += (long) nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			long sumLower = (long) sum;
			long sumHigher = totalSum - sum - nums[i];

			long m = (i - (nums.length - i - 1)) * nums[i] + (sumHigher - sumLower);
			moves = Math.min(m, moves);
			sum += nums[i];
		}
		return (int) moves;
	}

}
