package com.vishal.interviews.uber.hard;

import java.util.*;

public class RemoveInvalidParentheses {

	public static void main(String[] args) {

	}

	int maxLen = Integer.MIN_VALUE;

	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();

		dfs(s, 0, 0, 0, "", res);
		return res;

	}

	void dfs(String s, int pos, int leftCnt, int rightCnt, String cur, List<String> res) {
		if (pos == s.length()) {
			if (leftCnt == rightCnt) {
				int curLen = cur.length();
				if (curLen > maxLen) {
					maxLen = curLen;
				}

				if (curLen == maxLen) {
					res.add(cur);
				}
			}
			return;
		}

		if (pos > s.length()) {
			return;
		}

		char c = s.charAt(pos);
		if (c == '(') {
			dfs(s, pos + 1, leftCnt + 1, rightCnt, cur + "(", res);
			dfs(s, pos + 1, leftCnt, rightCnt, cur, res);
		}
		if (c == ')') {
			if (rightCnt < leftCnt) {
				dfs(s, pos + 1, leftCnt, rightCnt + 1, cur + "(", res);
			}
			dfs(s, pos + 1, leftCnt, rightCnt, cur, res);
		}
		dfs(s, pos + 1, leftCnt, rightCnt, cur + c, res);

	}

}
