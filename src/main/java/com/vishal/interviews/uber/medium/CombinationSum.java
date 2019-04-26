package com.vishal.interviews.uber.medium;

import java.util.*;

public class CombinationSum {

	public static void main(String[] args) {

	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(candidates, target, 0, new ArrayList<>(), res);
		return res;
	}

	void dfs(int[] candidates, int target, int st, List<Integer> temp, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<>(temp));
		}
		if (target <= 0) {
			return;
		}

		for (int i = st; i < candidates.length; i++) {
			temp.add(candidates[i]);
			dfs(candidates, target - candidates[i], i, temp, res);
			temp.remove(temp.size() - 1);
		}
	}

}
