package com.vishal.interviews.facebook.careercup;

import java.util.*;

public class SubsetsOfGivenSumAndSize {

	public static void main(String[] args) {

		System.out.println(combinationSumDFS(new int[] { -3, 4, 2, 0, 1 }, 3, 3));

		System.out.println(combinationSumDFS(new int[] { -3, 4, 2, 0, 1 }, 1, 2));
	}

	public static List<List<Integer>> combinationSumDFS(int[] nums, int target, int k) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(nums, target, k, 0, new ArrayList<>(), res);

		return res;
	}

	static void dfs(int[] nums, int target, int k, int pos, List<Integer> temp, List<List<Integer>> res) {
		if (temp.size() == k && target == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}

		if (temp.size() > k) {
			return;
		}

		for (int i = pos; i < nums.length; i++) {
			temp.add(nums[i]);
			dfs(nums, target - nums[i], k, i + 1, temp, res);
			temp.remove(temp.size() - 1);
		}
	}

}
