package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class PalindromePartitioning {

	public static void main(String[] args) {

	}

	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();

		if (s == null || s.length() == 0) {
			return res;
		}

		List<String> temp = new ArrayList<>();
		dfs(s, 0, temp, res);
		return res;
	}

	void dfs(String s, int p, List<String> temp, List<List<String>> res) {

		if (p == s.length()) {
			res.add(new ArrayList<>(temp));
			return;
		}

		for (int i = p; i < s.length(); i++) {
			String sub = s.substring(p, i + 1);
			if (isPalindrome(sub)) {
				temp.add(sub);
				dfs(s, i + 1, temp, res);
				temp.remove(temp.size() - 1);
			}
		}
	}

	boolean isPalindrome(String s) {
		return true;
	}

}
