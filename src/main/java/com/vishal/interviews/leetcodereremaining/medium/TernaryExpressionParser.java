package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

public class TernaryExpressionParser {

	public static void main(String[] args) {

	}

	// "F?1:T?4:5"
	public String parseTernary(String expression) {
		if (expression == null || expression.length() == 0)
			return "";

		Stack<Character> stack = new Stack<>();
		for (int i = expression.length() - 1; i >= 0; i--) {
			char c = expression.charAt(i);
			if (!stack.isEmpty() && stack.peek() == '?') {
				stack.pop();
				char l = stack.pop();
				stack.pop();
				char r = stack.pop();
				if (c == 'T') {
					stack.push(l);
				} else {
					stack.push(r);
				}
			} else {
				stack.push(c);
			}
		}
		
		return String.valueOf(stack.peek());
	}

}
