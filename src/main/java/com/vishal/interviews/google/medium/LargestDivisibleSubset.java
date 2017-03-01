package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. Largest Divisible Subset
 * 
 * Given a set of distinct positive integers, find the largest subset such that
 * every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj %
 * Si = 0.
 * 
 * If there are multiple solutions, return any subset is fine.
 * 
 * Example 1:
 * 
 * nums: [1,2,3]
 * 
 * Result: [1,2] (of course, [1,3] will also be ok) Example 2:
 * 
 * nums: [1,2,4,8]
 * 
 * Result: [1,2,4,8]
 */
public class LargestDivisibleSubset {

	public List<Integer> largestDivisibleSubsetDP(int[] nums) {
		int n = nums.length;
		int[] count = new int[n];
		int[] pre = new int[n];
		Arrays.sort(nums);
		int max = 0, index = -1;
		for (int i = 0; i < n; i++) {
			count[i] = 1;
			pre[i] = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0) {
					if (1 + count[j] > count[i]) {
						count[i] = count[j] + 1;
						pre[i] = j;
					}
				}
			}
			if (count[i] > max) {
				max = count[i];
				index = i;
			}
		}
		List<Integer> res = new ArrayList<>();
		while (index != -1) {
			res.add(nums[index]);
			index = pre[index];
		}
		return res;
	}

	/**
	 * Easy understood Java DP solution in 28ms with O(n^2) time
	 * 
	 * The basic idea is like:
	 * 
	 * 1. Sort
	 * 
	 * 2. Find the length of longest subset
	 * 
	 * 3. Record the largest element of it.
	 * 
	 * 4. Do a loop from the largest element to nums[0], add every element
	 * belongs to the longest subset.
	 * 
	 * The old version cant pass the test case [1,2,4,8,9,72] and [4,8,10,240],
	 * thanks for that @Yanning and @svc Here comes the revised version:
	 * 
	 * @param nums
	 * @return
	 */
	public static List<Integer> largestDivisibleSubsetEasyDP(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		int[] dp = new int[nums.length];
		dp[0] = 1;

		// for each element in nums, find the length of largest subset it has.
		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		// pick the index of the largest element in dp.
		int maxIndex = 0;
		for (int i = 1; i < nums.length; i++) {
			maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;
		}

		// from nums[maxIndex] to 0, add every element belongs to the largest
		// subset.
		int temp = nums[maxIndex];
		int curDp = dp[maxIndex];
		for (int i = maxIndex; i >= 0; i--) {
			if (temp % nums[i] == 0 && dp[i] == curDp) {
				res.add(nums[i]);
				temp = nums[i];
				curDp--;
			}
		}
		return res;
	}

	/**
	 * Java Solution in 32ms O(N^2) time, O(N) space
	 * 
	 * @param nums
	 * @return
	 */
	public int[] largestDivisibleSubsetSolution3(int[] nums) {
		if (nums.length < 2)
			return nums;
		else {
			Arrays.sort(nums);
			int[] parent = new int[nums.length];
			int[] count = new int[nums.length];
			int max = 0, maxind = -1;
			for (int i = nums.length - 1; i >= 0; i--) {
				for (int j = i; j < nums.length; j++) {
					if (nums[j] % nums[i] == 0 && count[i] < 1 + count[j]) {
						count[i] = 1 + count[j];
						parent[i] = j;
						if (count[i] > max) {
							max = count[i];
							maxind = i;
						}
					}
				}
			}
			int[] res = new int[max];
			for (int i = 0; i < max; i++) {
				res[i] = nums[maxind];
				maxind = parent[maxind];
			}
			return res;
		}
	}
}
