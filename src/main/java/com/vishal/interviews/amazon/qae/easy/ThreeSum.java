package com.vishal.interviews.amazon.qae.easy;

import java.util.*;

/**
 * 15. 3Sum
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSum {

	public static void main(String[] args) {

	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			// to avoid duplicates
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					List<Integer> cur = new ArrayList<>();
					cur.add(nums[i]);
					cur.add(nums[j]);
					cur.add(nums[k]);
					res.add(cur);

					// to avoid duplicates
					while (j < k && nums[j] == nums[j + 1]) {
						j++;
					}
					// to avoid duplicates
					while (k > j && nums[k] == nums[k - 1]) {
						k--;
					}
					j++;
					k--;
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}

		return res;
	}

}
