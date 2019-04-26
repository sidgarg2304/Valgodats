package com.vishal.interviews.facebook.medium;

import java.util.*;

public class CombinationSum {

	public static void main(String[] args) {

	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();

		dfs(candidates,0, 0, target, new ArrayList<>(), res);
		return res;
	}

	void dfs(int[] candidates, int pos, int sum, int target, List<Integer> temp, List<List<Integer>> res) {

		if (sum == target) {
			res.add(new ArrayList<>(temp));
            return;
		}

		if (sum > target) {
			return;
		}
		
		for (int i = pos; i < candidates.length; i++) {			
			temp.add(candidates[i]);
			dfs(candidates, i, sum + candidates[i], target, temp, res);
			temp.remove(temp.size() - 1);
		}
	}

}
