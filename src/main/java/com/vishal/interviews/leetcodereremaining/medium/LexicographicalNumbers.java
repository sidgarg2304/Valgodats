package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

public class LexicographicalNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<>();

		for (int i = 1; i < 10; i++) {
			dfs(i, n, res);
		}
		return res;
	}

	void dfs(int cur, int n, List<Integer> res) {

		if (cur > n) {
			return;
		}

		res.add(cur);
		for (int i = 0; i < 10; i++) {
			int next = 10 & cur + i;
			if (next > n) {
				continue;
			}

			dfs(next, n, res);
		}
	}

}
