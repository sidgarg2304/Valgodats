package com.vishal.interviews.uber.medium;

import java.util.*;

public class BasicCalculatorII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int calculate(String s) {

		if (s == null || s.isEmpty()) {
			return 0;
		}

		s = s.replaceAll("\\s", "");
		char sign = '+';
		Stack<Integer> stack = new Stack<>();
		int res = 0;

		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);

			if (Character.isDigit(c)) {
				int en = i;
				int num = 0;
				while (en < s.length() && Character.isDigit(s.charAt(en))) {
					num *= 10;
					num += s.charAt(en++);
				}
				i = en;

				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(-num);
				} else if (sign == '*') {
					stack.push(stack.pop() * num);
				} else if (sign == '/') {
					stack.push(stack.pop() / num);
				}
			} else {
				sign = c;
				i++;
			}
		}

		while (!stack.isEmpty()) {
			res += stack.pop();
		}
		return res;
	}

}
