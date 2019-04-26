package com.vishal.interviews.uber.medium;

import java.util.*;

public class GenerateParentheses {

	public static void main(String[] args) {

	}

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();

		if (n == 0) {
			return res;
		}
		dfs(n, "", 0, 0, res);
		return res;
	}

	void dfs(int n, String cur, int leftCnt, int rightCnt, List<String> res) {
		if (leftCnt == n && rightCnt == n) {
			res.add(cur);
			return;
		}

		if (leftCnt < n) {
			dfs(n, cur + '(', leftCnt + 1, rightCnt, res);
		}

		if (rightCnt < leftCnt) {
			dfs(n, cur + ')', leftCnt, rightCnt + 1, res);
		}
	}

}
