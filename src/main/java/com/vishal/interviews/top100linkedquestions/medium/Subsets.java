package com.vishal.interviews.top100linkedquestions.medium;

import java.util.*;

public class Subsets {

	public static void main(String[] args) {

	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(nums, new ArrayList<>(), res, 0);
		return res;
	}

	void dfs(int[] nums, List<Integer> temp, List<List<Integer>> res, int p) {

		res.add(new ArrayList<>(temp));

		for (int i = p; i < nums.length; i++) {
			temp.add(nums[i]);
			dfs(nums, temp, res, i + 1);
			temp.remove(temp.size() - 1);
		}
	}

}
