package com.vishal.interviews.facebook.hard;

import java.util.*;

/**
 * 301. Remove Invalid Parentheses
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]

 *
 */
public class RemoveInvalidParentheses {

	public static void main(String[] args) {

		System.out.println(removeInvalidParentheses("()())()"));
	}

	public static List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();

		dfs(s, "", 0, 0, res);

		if (res.isEmpty()) {
			res.add("");
		}
		return res;

	}

	static int max;

	static void dfs(String left, String right, int leftCount, int maxLeftCount, List<String> res) {

		if (left.length() == 0) {
			if (leftCount == 0 && !right.isEmpty()) {
				if (maxLeftCount > max) {
					max = maxLeftCount;
				}

				if (max == maxLeftCount && !res.contains(right)) {

					res.add(right);
				}
			}
			return;
		}

		if (left.charAt(0) == '(') {
			dfs(left.substring(1), right + "(", leftCount + 1, maxLeftCount + 1, res);
			dfs(left.substring(1), right, leftCount, maxLeftCount, res);
		} else if (left.charAt(0) == ')') {
			if (leftCount > 0) {
				dfs(left.substring(1), right + ")", leftCount - 1, maxLeftCount, res);
			}
			dfs(left.substring(1), right, leftCount, maxLeftCount, res);
		} else {
			dfs(left.substring(1), right + String.valueOf(left.charAt(0)), leftCount, maxLeftCount, res);
		}

	}

}
