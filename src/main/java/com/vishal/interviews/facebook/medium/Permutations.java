package com.vishal.interviews.facebook.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		dfs(nums, new ArrayList<>(), res);
		return res;
	}

	void dfs(int[] nums, List<Integer> temp, List<List<Integer>> res) {
		if (temp.size() == nums.length) {
			res.add(new ArrayList<>(temp));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!temp.contains(nums[i])) {
				temp.add(nums[i]);
				dfs(nums, temp, res);
				temp.remove(temp.size() - 1);
			}
		}
	}

}
