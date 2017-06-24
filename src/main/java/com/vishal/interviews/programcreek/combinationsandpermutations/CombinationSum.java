package com.vishal.interviews.programcreek.combinationsandpermutations;

import java.util.*;

public class CombinationSum {

	public static void main(String[] args) {

		System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));
	}

	public static List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();

		Arrays.sort(nums);
		dfs(nums, target, 0, new ArrayList<>(), res);

		return res;
	}

	static void dfs(int[] nums, int target, int pos, List<Integer> temp, List<List<Integer>> res) {

		if (0 == target) {
			res.add(new ArrayList<>(temp));
			return;
		}

		if (target < 0) {
			return;
		}

		for (int i = pos; i < nums.length; i++) {

			temp.add(nums[i]);
			dfs(nums, target - nums[i], i, temp, res);
			temp.remove(temp.size() - 1);
		}
	}

}
