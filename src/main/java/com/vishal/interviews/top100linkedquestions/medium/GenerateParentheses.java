package com.vishal.interviews.top100linkedquestions.medium;

import java.util.*;

public class GenerateParentheses {

	public static void main(String[] args) {

	}

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();

		dfs(n, "", 0, 0, res);
		return res;
	}

	void dfs(int n, String cur, int l, int r, List<String> res) {
		if (l == n && r == n) {
			res.add(cur);
			return;
		}

		if (l < n) {
			dfs(n, cur + "(", l + 1, r, res);
		}

		if (r < l) {
			dfs(n, cur + ")", l + 1, r, res);
		}
	}

}
