package com.vishal.interviews.facebook.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		dfs(nums, new ArrayList<>(), res, used);
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
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
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
