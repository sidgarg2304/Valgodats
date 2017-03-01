package com.vishal.interviews.google.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 494. Target Sum
 * 
 * https://leetcode.com/problems/target-sum/?tab=Solutions
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target,
 * S. Now you have 2 symbols + and -. For each integer, you should choose one
 * from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.
 * 
 * Example 1:
 * 
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * 
 * Output: 5
 * 
 * Explanation:
 * 
 * -1+1+1+1+1 = 3
 * 
 * +1-1+1+1+1 = 3
 * 
 * +1+1-1+1+1 = 3
 * 
 * +1+1+1-1+1 = 3
 * 
 * +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * 
 * Note:
 * 
 * 1. The length of the given array is positive and will not exceed 20. 2. The
 * sum of elements in the given array will not exceed 1000. 3. Your output
 * answer is guaranteed to be fitted in a 32-bit integer.
 * 
 */
public class TargetSum {

	public static void main(String[] args) {

	}

	/**
	 * Short Java DP Solution with Explanation
	 * 
	 * @param nums
	 * @param s
	 * @return
	 */
	public int findTargetSumWaysDP(int[] nums, int s) {
		int sum = 0;
		for (int i : nums)
			sum += i;
		if (s > sum || s < -sum)
			return 0;
		int[] dp = new int[2 * sum + 1];
		dp[0 + sum] = 1;
		for (int i = 0; i < nums.length; i++) {
			int[] next = new int[2 * sum + 1];
			for (int k = 0; k < 2 * sum + 1; k++) {
				if (dp[k] != 0) {
					next[k + nums[i]] += dp[k];
					next[k - nums[i]] += dp[k];
				}
			}
			dp = next;
		}
		return dp[sum + s];
	}

}

/**
 * Java simple DFS with memorization
 * 
 * I'm quite surprised that simple DFS could pass the test since for DFS
 * solution there are obvious a lot of overlap subproblems. So I used a map to
 * record the intermediate result while we are walking along the recursion tree.
 *
 */
class TargetSumDFS {
	public int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		return helper(nums, 0, 0, S, new HashMap<>());
	}

	private int helper(int[] nums, int index, int sum, int S, Map<String, Integer> map) {
		String encodeString = index + "->" + sum;
		if (map.containsKey(encodeString)) {
			return map.get(encodeString);
		}
		if (index == nums.length) {
			if (sum == S) {
				return 1;
			} else {
				return 0;
			}
		}
		int curNum = nums[index];
		int add = helper(nums, index + 1, sum - curNum, S, map);
		int minus = helper(nums, index + 1, sum + curNum, S, map);
		map.put(encodeString, add + minus);
		return add + minus;
	}
}

/**
 * This is a pretty easy problem. Just do DFS and try both "+" and "-" at every
 * position. Easy version of Expression Add Operators
 * https://leetcode.com/problems/expression-add-operators/
 * 
 * @author vkotha
 *
 */
class TargetSumDFSShort {
	int result = 0;

	public int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length == 0)
			return result;
		helper(nums, S, 0, 0);
		return result;
	}

	public void helper(int[] nums, int target, int pos, long eval) {
		if (pos == nums.length) {
			if (target == eval)
				result++;
			return;
		}
		helper(nums, target, pos + 1, eval + nums[pos]);
		helper(nums, target, pos + 1, eval - nums[pos]);
	}
}

/**
 * Optimization: The idea is If the sum of all elements left is smaller than
 * absolute value of target, there will be no answer following the current path.
 * Thus we can return.
 *
 */
class TargetSumDFSShortOptimized {
	int result = 0;

	public int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length == 0)
			return result;

		int n = nums.length;
		int[] sums = new int[n];
		sums[n - 1] = nums[n - 1];
		for (int i = n - 2; i >= 0; i--)
			sums[i] = sums[i + 1] + nums[i];

		helper(nums, sums, S, 0);
		return result;
	}

	public void helper(int[] nums, int[] sums, int target, int pos) {
		if (pos == nums.length) {
			if (target == 0)
				result++;
			return;
		}

		if (sums[pos] < Math.abs(target))
			return;

		helper(nums, sums, target + nums[pos], pos + 1);
		helper(nums, sums, target - nums[pos], pos + 1);
	}
}