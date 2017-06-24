package com.vishal.interviews.programcreek.combinationsandpermutations;

import java.util.*;

public class FactorCombinations {

	public static void main(String[] args) {

	}

	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> res = new ArrayList<>();

		dfs(n, 2, new ArrayList<>(), res);
		return res;
	}

	void dfs(int n, int st, List<Integer> temp, List<List<Integer>> res) {

		if (n == 1) {
			if (temp.size() > 1) {
				res.add(new ArrayList<>(temp));
			}

			return;
		}

		for (int i = st; i <= n; i++) {
			if (n % i == 0) {
				temp.add(i);

				dfs(n / i, i, temp, res);
				temp.remove(temp.size() - 1);
			}
		}
	}

}
