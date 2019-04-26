package com.vishal.interviews.uber.hard;

import java.util.Stack;

public class BasicCalculatorIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int calculate(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}

		Stack<Integer> stack = new Stack<>();
		char sign = '+';
		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);

			if (c == '(') {
				int cnt = 1;
				int en = i + 1;
				while (en < s.length() && cnt != 0) {
					if (s.charAt(en) == '(') {
						cnt++;
					}

					if (s.charAt(en) == ')') {
						cnt--;
					}
				}

				int block = calculate(s.substring(i + 1, en - 1));
				if (sign == '+') {
					stack.push(block);
				} else if (sign == '-') {
					stack.push(-block);
				} else if (sign == '*') {
					stack.push(stack.pop() * block);
				} else if (sign == '/') {
					stack.push(stack.pop() / block);
				}

				i = en;
			} else if (Character.isDigit(c)) {
				int en = i;
				int val = 0;
				while (en < s.length() && Character.isDigit(s.charAt(en))) {
					val *= 10;
					val += s.charAt(en) - '0';
				}

				if (sign == '+') {
					stack.push(val);
				} else if (sign == '-') {
					stack.push(-val);
				} else if (sign == '*') {
					stack.push(stack.pop() * val);
				} else if (sign == '/') {
					stack.push(stack.pop() / val);
				}
				i = en;
			} else {
				sign = c;
				i++;
			}
		}
		
		int res = 0;
		while(!stack.isEmpty()) {
			res += stack.pop();
		}
		return res;
	}

}
