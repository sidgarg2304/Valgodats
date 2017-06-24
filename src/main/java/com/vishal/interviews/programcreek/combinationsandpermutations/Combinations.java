package com.vishal.interviews.programcreek.combinationsandpermutations;

import java.util.*;

public class Combinations {

	public static void main(String[] args) {
		
		System.out.println(combine(20,16));

	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();

		dfs(n, k, 1, new ArrayList<>(), res);
		return res;
	}

	static void dfs(int n, int k, int pos, List<Integer> temp, List<List<Integer>> res) {

		if (temp.size() == k) {
			res.add(new ArrayList<>(temp));			
		}
		
		for (int i = pos; i <= n; i++) {
			temp.add(i);
			dfs(n, k, i + 1, temp, res);
			temp.remove(temp.size() - 1);
		}
	}

}
