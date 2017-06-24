package com.vishal.interviews.programcreek.combinationsandpermutations;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	public static void main(String[] args) {

		System.out.println(combinationSum3(3, 9));
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();

		dfs(k, n, 1, new ArrayList<>(), res);

		return res;
	}

	static void dfs(int k, int target, int pos, List<Integer> temp, List<List<Integer>> res) {

		if (0 == target && temp.size() == k) {
			res.add(new ArrayList<>(temp));
			return;
		}

		if (target < 0 || temp.size() > k) {
			return;
		}

		for (int i = pos; i <= 9; i++) {

			temp.add(i);
			dfs(k, target - i, i + 1, temp, res);
			temp.remove(temp.size() - 1);
		}
	}

}
