package com.vishal.interviews.programcreek;

import java.util.*;

public class BasicCalculator {

	public static void main(String[] args) {

	}

	public int calculate(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}
		int sign = 1;
		int num = 0;
		int res = 0;
		Stack<Integer> stack = new Stack<>();

		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);

			if (c == '+') {
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
				num = 0;
				sign = 1;
			} else if (c == ')') {
				res += num * sign;
				res *= stack.pop();
				res += stack.pop();
				num = 0;
			} else {
				num = num * 10 + (c - '0');
			}
		}
		
		if(num != 0){
			res += num * sign;
		}

		return res;

	}

}
