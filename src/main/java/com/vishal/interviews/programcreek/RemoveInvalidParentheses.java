package com.vishal.interviews.programcreek;

import java.util.*;

public class RemoveInvalidParentheses {

	public static void main(String[] args) {

	}

	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();

		dfs(s, "", 0, 0, 0, res);
		return res;
	}

	int maxLen = Integer.MIN_VALUE;

	void dfs(String s, String cur, int pos, int leftCount, int rightCount, List<String> res) {
		if (pos == s.length()) {
			if (leftCount == rightCount) {
				maxLen = Math.max(cur.length(), maxLen);
				if (cur.length() == maxLen) {
					res.add(cur);
				}
			}
			return;
		}

		char c = s.charAt(pos);
		if (c == '(') {
			dfs(s, cur + "(", pos + 1, leftCount + 1, rightCount, res);
			dfs(s, cur, pos + 1, leftCount, rightCount, res);
		} else if (c == ')') {
			if (rightCount < leftCount) {
				dfs(s, cur + ")", pos + 1, leftCount, rightCount + 1, res);
			}
			dfs(s, cur, pos + 1, leftCount, rightCount, res);
		} else {
			dfs(s, cur + c, pos + 1, leftCount, rightCount, res);
		}
	}

}
