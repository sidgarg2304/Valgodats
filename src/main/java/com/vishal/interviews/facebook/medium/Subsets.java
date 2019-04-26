package com.vishal.interviews.facebook.medium;

import java.util.*;

/**
 * 78. Subsets
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 *
 */
public class Subsets {

	public static void main(String[] args) {

	}
	
	public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		dfs(nums, res, temp, 0);
		return res;
  }
  
  void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, int st) {

		res.add(new ArrayList<>(temp));

		for (int i = st; i < nums.length; i++) {
			temp.add(nums[i]);
			dfs(nums, res, temp, i + 1);
			temp.remove(temp.size() - 1);
		}

	}

}
