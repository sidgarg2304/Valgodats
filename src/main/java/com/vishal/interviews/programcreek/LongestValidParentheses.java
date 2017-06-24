package com.vishal.interviews.programcreek;

import java.util.*;

public class LongestValidParentheses {

	public static void main(String[] args) {

	}

	public static int longestValidParentheses(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		Stack<int[]> stack = new Stack<>();

		int res = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				stack.push(new int[] { i, 0 });
			} else {
				if (stack.isEmpty() || stack.peek()[1] != 0) {
					stack.push(new int[] { i, 1 });
				} else {
					stack.pop();
					int curLen = 0;
					if (stack.isEmpty()) {
						curLen = i + 1;
					} else {
						curLen = i - stack.peek()[0];
					}
					res = Math.max(res, curLen);
				}
			}
		}
		return res;
	}

}
