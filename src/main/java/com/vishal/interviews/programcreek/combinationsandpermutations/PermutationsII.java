package com.vishal.interviews.programcreek.combinationsandpermutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

	public static void main(String[] args) {
		System.out.println(permute(new int[] { 1, 1, 2 }));
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		dfs(nums, new ArrayList<>(), res, used);
		return res;
	}

	static void dfs(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] used) {

		if (temp.size() == nums.length) {
			res.add(new ArrayList<>(temp));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
				continue;
			}
			temp.add(nums[i]);
			used[i] = true;
			dfs(nums, temp, res, used);
			temp.remove(temp.size() - 1);
			used[i] = false;
		}

	}

}
