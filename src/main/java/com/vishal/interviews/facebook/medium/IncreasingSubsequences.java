package com.vishal.interviews.facebook.medium;

import java.util.*;

public class IncreasingSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> findSubsequences(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();

		dfs(nums, 0, new ArrayList<>(), res);
		return new ArrayList<>(res);
	}

	void dfs(int[] nums, int pos, List<Integer> temp, Set<List<Integer>> res) {

		if (temp.size() >= 2) {
			res.add(new ArrayList<>(temp));
		}

		for (int i = pos; i < nums.length; i++) {
			if (temp.isEmpty() || (temp.get(temp.size() - 1) <= nums[i])) {
				temp.add(nums[i]);
				dfs(nums, i + 1, temp, res);
				temp.remove(temp.size() - 1);
			}
		}
	}

}
