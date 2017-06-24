package com.vishal.interviews.programcreek.math;

import java.util.ArrayList;
import java.util.List;

public class SubsetsII {

	public static void main(String[] args) {

		System.out.println(subsetsWithDup(new int[] { 1, 2, 2 }));
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		dfs(nums, 0, new ArrayList<>(), res);

		return res;
	}

	static void dfs(int[] nums, int pos, List<Integer> temp, List<List<Integer>> res) {

		res.add(new ArrayList<>(temp));

		for (int i = pos; i < nums.length; i++) {
			if (i > pos && nums[i] == nums[i - 1]) {
				continue;
			}
			temp.add(nums[i]);
			dfs(nums, i + 1, temp, res);
			temp.remove(temp.size() - 1);
		}
	}

}
