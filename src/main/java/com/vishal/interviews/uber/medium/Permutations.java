package com.vishal.interviews.uber.medium;

import java.util.*;

public class Permutations {

	public static void main(String[] args) {

	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		
		if(nums == null || nums.length == 0) {
			return res;
		}

		dfs(nums, new ArrayList<>(), res);
		return res;
	}

	void dfs(int[] nums, List<Integer> temp, List<List<Integer>> res) {

		if (temp.size() == nums.length) {
			res.add(new ArrayList<>(temp));
		}

		for (int i = 0; i < nums.length; i++) {
			if (temp.contains(nums[i])) {
				continue;
			}

			temp.add(nums[i]);
			dfs(nums, temp, res);
			temp.remove(temp.size() - 1);
		}
	}

}
