package com.vishal.interviews.facebook.careercup;

import java.util.*;

/**
 * A "derangement" of a sequence is a permutation where no element appears in
 * its original position. For example ECABD is a derangement of ABCDE, given a
 * string, may contain duplicate char, please out put all the derangement
 *
 */
public class DeArrangementSequence {

	public static void main(String[] args) {
		System.out.println(getDerangement(new char[] { 'a', 'b', 'c' }));

	}

	public static List<List<Character>> getDerangement(char[] arr) {

		List<List<Character>> res = new ArrayList<>();
		dfs(arr, new ArrayList<>(), res);
		return res;
	}

	static void dfs(char[] arr, List<Character> temp, List<List<Character>> res) {

		if (temp.size() == arr.length) {
			res.add(new ArrayList<>(temp));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (temp.contains(arr[i]) || i == temp.size()) {
				continue;
			}

			temp.add(arr[i]);
			dfs(arr, temp, res);
			temp.remove(temp.size() - 1);
		}

	}
}
