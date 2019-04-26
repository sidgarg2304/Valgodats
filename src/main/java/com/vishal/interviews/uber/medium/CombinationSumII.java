package com.vishal.interviews.uber.medium;

import java.util.*;

public class CombinationSumII {

	public static void main(String[] args) {

	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(candidates, 0, target, new ArrayList<>(), res);
		return res;
	}

	void dfs(int[] candidates, int st, int target, List<Integer> temp, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}

		if (target < 0) {
			return;
		}

		for (int i = st; i < candidates.length; i++) {
			if (i > st && candidates[i] == candidates[i - 1]) {
				continue;
			}
			temp.add(candidates[i]);
			dfs(candidates, i + 1, target - candidates[i], temp, res);
			temp.remove(temp.size() - 1);
		}
	}

}
