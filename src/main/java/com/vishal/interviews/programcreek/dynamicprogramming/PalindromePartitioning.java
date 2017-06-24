package com.vishal.interviews.programcreek.dynamicprogramming;

import java.util.*;

public class PalindromePartitioning {

	public static void main(String[] args) {

		System.out.println(palindromePartitioning("abbab"));
	}

	public static List<List<String>> palindromePartitioning(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> temp = new ArrayList<>();

		dfs(s, 0, temp, res);
		return res;
	}

	static void dfs(String s, int pos, List<String> temp, List<List<String>> res) {
		if (pos == s.length()) {
			List<String> cur = new ArrayList<>(temp);
			res.add(cur);
		}

		for (int i = pos + 1; i <= s.length(); i++) {
			String sub = s.substring(pos, i);
			if (isPalindrome(sub)) {
				temp.add(sub);
				dfs(s, i, temp, res);
				temp.remove(temp.size() - 1);
			}
		}
	}

	static boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static List<List<String>> palindromePartitioningDP(String s) {

		List<String>[] res = new List[s.length() + 1];

		res[0] = new ArrayList<>();

		boolean[][] dp = new boolean[s.length()][s.length()];

		for (int l = 1; l <= s.length(); l++) {
			res[l] = new ArrayList<>();

			for (int i = 0; i <= s.length() - l; i++) {
				int j = i + l - 1;

				if (l == 1) {

					res[l].add(s.substring(i, j + 1));

					dp[i][j] = true;
				} else {
					if ((s.charAt(i) == s.charAt(j)) && (l == 2 || dp[i + 1][j - 1])) {
						dp[i][j] = true;
						String cur = s.substring(i, j + 1);
						List<String> temp = new ArrayList<>();
						for (String r : res[i]) {
							temp.add(r);
						}
						temp.add(cur);
						res[l].addAll(temp);
					}
				}
			}
		}

		List<List<String>> result = new ArrayList<>();
		for (int i = 1; i < res.length; i++) {
			result.add(res[i]);
		}
		return result;
	}

}
