package com.vishal.interviews.google.medium;

import java.util.Stack;

/**
 * 503. Next Greater Element II
 * 
 * Given a circular array (the next element of the last element is the first
 * element of the array), print the Next Greater Number for every element.
 * 
 * The Next Greater Number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, output -1 for this
 * number.
 * 
 * Example 1:
 * 
 * Input: [1,2,1]
 * 
 * Output: [2,-1,2]
 * 
 * Explanation: The first 1's next greater number is 2;
 * 
 * The number 2 can't find next greater number;
 * 
 * The second 1's next greater number needs to search circularly, which is also
 * 2.
 * 
 * Note: The length of given array won't exceed 10000.
 */
public class NextGreaterElementII {

	public static void main(String[] args) {

	}

	/**
	 * The first typical way to solve circular array problems is to extend the
	 * original array to twice length, 2nd half has the same element as first
	 * half. Then everything become simple. Naive by simple solution, just look
	 * for the next greater element directly. Time complexity: O(n^2).
	 * 
	 * @param nums
	 * @return
	 */
	public int[] nextGreaterElementsSolution1(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			max = Math.max(max, num);
		}

		int n = nums.length;
		int[] result = new int[n];
		int[] temp = new int[n * 2];

		for (int i = 0; i < n * 2; i++) {
			temp[i] = nums[i % n];
		}

		for (int i = 0; i < n; i++) {
			result[i] = -1;
			if (nums[i] == max)
				continue;

			for (int j = i + 1; j < n * 2; j++) {
				if (temp[j] > nums[i]) {
					result[i] = temp[j];
					break;
				}
			}
		}

		return result;
	}

	/**
	 * The second way is to use a stack to facilitate the look up. First we put
	 * all indexes into the stack, smaller index on the top. Then we start from
	 * end of the array look for the first element (index) in the stack which is
	 * greater than the current one. That one is guaranteed to be the Next
	 * Greater Element. Then put the current element (index) into the stack.
	 * 
	 * Time complexity: O(n).
	 * 
	 * @param nums
	 * @return
	 */
	public int[] nextGreaterElementsSolution2(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];

		Stack<Integer> stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			stack.push(i);
		}

		for (int i = n - 1; i >= 0; i--) {
			result[i] = -1;
			while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				result[i] = nums[stack.peek()];
			}
			stack.add(i);
		}

		return result;
	}

	/**
	 * Short normal soltuion 200ms
	 * 
	 * @param nums
	 * @return
	 */
	public int[] nextGreaterElements2SolutionAC(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = -1;
			for (int k = i + 1; k < i + n; k++) {
				if (nums[k % n] > nums[i]) {
					res[i] = nums[k % n];
					break;
				}
			}
		}
		return res;
	}

	/**
	 * DP solution 45ms
	 * 
	 * @param nums
	 * @return
	 */
	public int[] nextGreaterElementsDP(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			int cur = nums[i];
			res[i] = -1;
			dp[i] = -1;
			for (int j = i + 1; j < n; j++) {
				if (nums[j] > cur) {
					res[i] = nums[j];
					dp[i] = j;
					break;
				}
			}
			if (dp[i] == -1) {
				if (cur < nums[0])
					res[i] = nums[0];
				else {
					int k = 0;
					while (cur >= res[k] && k < i) {
						if (dp[k] == -1)
							break;
						k = dp[k];
					}
					if (k < i && cur < res[k])
						res[i] = res[k];
				}
			}
		}
		return res;
	}

}
