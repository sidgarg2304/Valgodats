package com.vishal.interviews.linkedin.careercup;

import java.util.*;

/**
 * There is a particular sequence that only uses numbers 1, 2, 3, 4 and no two
 * adjacent numbers are the same. Write a program that given n1 1s, n2 2s, n3
 * 3s, n4 4s will output the number of such sequences using all these numbers.
 * Output your answer modulo 1000000007 (10^9 + 7).
 *
 */
public class NonAdjacentIntegerSequence {

	public static void main(String[] args) {

		System.out.println(nonAdjacentIntegerSequence(new int[] { 2, 1, 2, 1 }));
	}

	public static List<List<Integer>> nonAdjacentIntegerSequence(int[] counts) {
		List<List<Integer>> res = new ArrayList<>();

		int n = counts[0] + counts[1] + counts[2] + counts[3];
		dfs(counts, n, new ArrayList<>(), res);
		return res;
	}

	static void dfs(int[] counts, int n, List<Integer> temp, List<List<Integer>> res) {
		if (n == temp.size()) {
			res.add(new ArrayList<>(temp));
			return;
		}

		for (int i = 1; i <= 4; i++) {

			if (counts[i - 1] > 0 && (temp.isEmpty() || temp.get(temp.size() - 1) != i)) {
				temp.add(i);
				counts[i - 1]--;
				dfs(counts, n, temp, res);
				counts[i - 1]++;
				temp.remove(temp.size() - 1);
			}
		}
	}

}
