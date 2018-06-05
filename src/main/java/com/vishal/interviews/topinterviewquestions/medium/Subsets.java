package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class Subsets {

	public static void main(String[] args) {

	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		dfs(nums, 0, new ArrayList<>(), res);
		return res;

	}

	void dfs(int[] nums, int p, List<Integer> temp, List<List<Integer>> res) {

		if (p > nums.length) {
			return;
		}

		res.add(new ArrayList<>(temp));

		for (int i = p; i < nums.length; i++) {
			temp.add(nums[i]);
			dfs(nums, i + 1, temp, res);
			temp.remove(temp.size() - 1);
		}
	}

}
