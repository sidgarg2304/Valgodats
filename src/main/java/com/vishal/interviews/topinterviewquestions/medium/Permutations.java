package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class Permutations {

	public static void main(String[] args) {

	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		dfs(nums, new ArrayList<>(), res, new boolean[nums.length]);

		return res;
	}

	void dfs(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] used) {

		if (temp.size() == nums.length) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			used[i] = true;
			temp.add(nums[i]);
			dfs(nums, temp, res, used);
			temp.remove(temp.size() - 1);
			used[i] = false;
		}

	}

}
