package com.vishal.interviews.top100linkedquestions.medium;

import java.util.*;

public class CombinationSum {

	public static void main(String[] args) {

	}

	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return res;
		}

		dfs(nums, target, new ArrayList<>(), res);

		return res;

	}

	void dfs(int[] nums, int target, List<Integer> temp, List<List<Integer>> res) {

		if (target == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			temp.add(nums[i]);
			dfs(nums, target - nums[i], temp, res);
			temp.remove(temp.size() - 1);
		}
	}

}
