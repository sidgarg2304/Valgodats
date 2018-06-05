package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class GenerateParentheses {

	public static void main(String[] args) {

	}

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();

		dfs("", n, res, 0, 0);
		return res;
	}

	void dfs(String s, int n, List<String> res, int leftCnt, int rightCnt) {

		if (leftCnt == n && rightCnt == n) {
			res.add(s);
			return;
		}

		if (leftCnt < n) {
			dfs(s + "(", n, res, leftCnt + 1, rightCnt);
		}

		if (rightCnt < leftCnt) {
			dfs(s + ")", n, res, leftCnt, rightCnt + 1);
		}
	}

}
