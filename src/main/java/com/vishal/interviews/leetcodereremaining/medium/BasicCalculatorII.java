package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;
/**
 * 227. Basic Calculator II
 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
 *
 */
public class BasicCalculatorII {

	public static void main(String[] args) {

	}

	public int calculate(String s) {
		char sign = '+';
		int num = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + (c - '0');
			}

			if ((!Character.isDigit(c) && ' ' != c) || s.length() - 1 == i) {
				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(-num);
				} else if (sign == '*') {
					stack.push(stack.pop() * num);
				} else if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = c;
				num = 0;
			}
		}

		int res = 0;
		while (!stack.isEmpty()) {
			res += stack.pop();
		}

		return res;
	}

}
