package com.vishal.interviews.programcreek.combinationsandpermutations;

import java.util.*;

public class Permutations {

	public static void main(String[] args) {

		System.out.println(permute(new int[] { 1, 2, 3 }));
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		dfs(nums, new ArrayList<>(), res);
		return res;
	}

	static void dfs(int[] nums, List<Integer> temp, List<List<Integer>> res) {

		if (temp.size() == nums.length) {
			res.add(new ArrayList<>(temp));
			return;
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
