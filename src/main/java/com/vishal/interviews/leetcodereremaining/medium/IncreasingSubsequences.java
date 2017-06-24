package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

public class IncreasingSubsequences {

	public static void main(String[] args) {

		System.out.println(findSubsequences(new int[] { 4, 6, 7, 7 }));
	}

	public static List<List<Integer>> findSubsequences(int[] nums) {

		Set<List<Integer>> res = new HashSet<>();

		dfs(nums, 0, new ArrayList<>(), res);
		return new ArrayList<>(res);
	}

	static void dfs(int[] nums, int pos, List<Integer> temp, Set<List<Integer>> res) {

		if (temp.size() >= 2) {
			res.add(new ArrayList<>(temp));
		}

		for (int i = pos; i < nums.length; i++) {
			if (temp.size() == 0 || temp.get(temp.size() - 1) <= nums[i]) {
				temp.add(nums[i]);
				dfs(nums, i + 1, temp, res);
				temp.remove(temp.size() - 1);
			}
		}
	}

}
