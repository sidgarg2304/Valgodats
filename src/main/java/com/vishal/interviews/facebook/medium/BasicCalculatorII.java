package com.vishal.interviews.facebook.medium;

import java.util.Stack;

public class BasicCalculatorII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
// Input: "3+2*2"
	// Output: 7
	public int calculate(String s) {

		char sign = '+';

		int num = 0;
		int res = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + (c - '0');
			}

			if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(num * -1);
				} else if (sign == '*') {
					stack.push(stack.pop() * num);
				} else if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = c;
				num = 0;
			}
		}
		
		while(!stack.isEmpty()){
			res += stack.pop();
		}
		return res;
	}

}
