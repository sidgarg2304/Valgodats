package com.vishal.interviews.programcreek.combinationsandpermutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {

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
			if (i > pos && nums[i] == nums[i - 1]) {
				continue;
			}
			temp.add(nums[i]);
			dfs(nums, target - nums[i], i + 1, temp, res);
			temp.remove(temp.size() - 1);
		}
	}

}
