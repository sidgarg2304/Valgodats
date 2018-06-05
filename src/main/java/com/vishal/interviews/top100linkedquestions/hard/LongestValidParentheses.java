package com.vishal.interviews.top100linkedquestions.hard;

import java.util.*;

public class LongestValidParentheses {

	public static void main(String[] args) {

	}

	public int longestValidParentheses(String s) {

		if (s == null || s.length() <= 1) {
			return 0;
		}

		Stack<int[]> stack = new Stack<>();

		int res = Integer.MIN_VALUE;		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(new int[] { 0, i });				
			} else {
				if (stack.isEmpty() || stack.peek()[1] != 0) {
					stack.push(new int[] { 1, i });
				} else {
					stack.pop();
					int curLen = stack.isEmpty()? i+1 : i - stack.peek()[1];
					res = Math.max(res, curLen);					
				}
			}				
		}
		return res;
	}

}
