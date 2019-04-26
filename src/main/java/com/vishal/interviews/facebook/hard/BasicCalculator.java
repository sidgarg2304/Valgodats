package com.vishal.interviews.facebook.hard;

import java.util.Stack;

public class BasicCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int calculateEasy(String s) {
		int res = 0;

		if (s == null || s.length() == 0) {
			return res;
		}

		int sign = 1;
		Stack<Integer> stack = new Stack<>();

		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (c == '(') {
				int cnt = 1;
				int j = i + 1;
				while (j < s.length() && cnt > 0) {
					if (s.charAt(j) == '(') {
						cnt++;
					}

					if (s.charAt(j) == ')') {
						cnt--;
					}
					j++;
				}
				int block = calculateEasy(s.substring(i + 1, j - 1));
				i = j;

				stack.push(sign * block);
			} else if (Character.isDigit(c)) {
				int j = i;
				int val = 0;
				while (j < s.length() && Character.isDigit(s.charAt(j))) {
					val *= 10;
					val += s.charAt(j) - '0';
					j++;
				}
				stack.push(sign * val);
				i = j;
			} else {
				sign = c == '+' ? 1 : -1;
				i++;
			}
		}

		System.out.println(stack);
		while (!stack.isEmpty()) {
			res += stack.pop();
		}

		return res;
	}
	
	public int calculate(String s) {
		int res = 0;

		if (s == null || s.length() == 0) {
			return res;
		}

		int sign = 1;

		int num = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
			} else if (c == '+') {
				res += num * sign;
				num = 0;
				sign = 1;
			} else if (c == '-') {
				res += num * sign;
				num = 0;
				sign = -1;
			} else if (c == '(') {
				stack.push(res);
				stack.push(sign);
				res = 0;
				sign = 1;
				num = 0;
			} else if (c == ')') {
				res += num * sign;
				res *= stack.pop();
				res += stack.pop();
				num = 0;
			}
		}

		if (num != 0) {
			res += num * sign;
		}

		return res;
	}

}
