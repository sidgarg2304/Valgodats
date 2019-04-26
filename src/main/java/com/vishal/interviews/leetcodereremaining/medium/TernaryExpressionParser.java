package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

public class TernaryExpressionParser {

	public static void main(String[] args) {

	}
	
	public String parseTernary(String expression) {

		if (expression == null || expression.isEmpty() || expression.length() == 1) {
			return expression;
		}

		int i = 0;
		int cnt = 0;

		while (i < expression.length()) {
			char c = expression.charAt(i);
			if (c == '?') {
				cnt++;
			} else if (c == ':') {
				cnt--;
				if (cnt == 0) {
					break;
				}
			}			
			i++;
		}				

		char f = expression.charAt(0);		
		if (f == 'T') {
			return parseTernary(expression.substring(2, i));
		} else {
			return parseTernary(expression.substring(i + 1));
		}

	}

	// "F?1:T?4:5"
	public String parseTernaryUsingStack(String expression) {
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
