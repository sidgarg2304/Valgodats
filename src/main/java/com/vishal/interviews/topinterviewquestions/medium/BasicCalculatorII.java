package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class BasicCalculatorII {

	public static void main(String[] args) {

	}

	public int calculate(String s) {
		char sign = '+';

		Stack<Integer> stack = new Stack<>();
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				num = num * 10 + (c - '0');
			}

			if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
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
