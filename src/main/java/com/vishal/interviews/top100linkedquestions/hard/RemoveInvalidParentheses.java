package com.vishal.interviews.top100linkedquestions.hard;

import java.util.*;

public class RemoveInvalidParentheses {

	public static void main(String[] args) {

	}

	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();

		dfs(s, 0, 0, 0, "", res);
		return res;
	}

	static int max = 0;

	void dfs(String s, int p, int leftCnt, int rightCnt, String cur, List<String> res) {
		if (p == s.length()) {
			if (leftCnt == rightCnt) {
				max = Math.max(max, cur.length());
				if (cur.length() == max && !res.contains(cur)) {
					res.add(cur);
				}
			}
			return;
		}

		char c = s.charAt(p);
		if (c == '(') {
			dfs(s, p + 1, leftCnt + 1, rightCnt, cur + "(", res);
			dfs(s, p + 1, leftCnt, rightCnt, cur, res);
		} else if (c == ')') {
			if (rightCnt < leftCnt) {
				dfs(s, p + 1, leftCnt, rightCnt + 1, cur + ")", res);
			}
			dfs(s, p + 1, leftCnt, rightCnt, cur, res);
		} else {
			dfs(s, p + 1, leftCnt, rightCnt, cur + c, res);
		}
	}

}
