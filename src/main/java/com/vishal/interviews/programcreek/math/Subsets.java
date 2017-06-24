package com.vishal.interviews.programcreek.math;

import java.util.*;

public class Subsets {

	public static void main(String[] args) {

		System.out.println(subsets(new int[]{1,2,3}));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		dfs(nums, 0, new ArrayList<>(), res);

		return res;
	}

	static void dfs(int[] nums, int pos, List<Integer> temp, List<List<Integer>> res) {

		res.add(new ArrayList<>(temp));

		for (int i = pos; i < nums.length; i++) {
			temp.add(nums[i]);
			dfs(nums, i + 1, temp, res);
			temp.remove(temp.size() - 1);
		}
	}

}
