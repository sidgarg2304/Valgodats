package com.vishal.interviews.uber.medium;

import java.util.*;

public class Subsets {

	public static void main(String[] args) {

	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return res;
		}
		
		dfs(nums, 0, new ArrayList<>(), res);
		
		return res;

	}

	void dfs(int[] nums, int st, List<Integer> temp, List<List<Integer>> res) {

		res.add(new ArrayList<>(temp));
		for(int i = st; i< nums.length; i++) {
			temp.add(nums[i]);
			dfs(nums, i + 1, temp, res);
			temp.remove(temp.size()-1);
		}
	}

}
