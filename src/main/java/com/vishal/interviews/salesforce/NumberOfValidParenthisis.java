package com.vishal.interviews.salesforce;

import java.util.*;

/**
 * 1.Write a program to find the number of valid parenthesis in a given
 * expression. 
 * For eg:
 * ((()))) contains 3 valid parenthesis 
 * hj()(i()) contain 2 valid parenthesis. 
 *
 */
public class NumberOfValidParenthisis {

	public static void main(String[] args) {
		System.out.println(numberOfValidParenthisis("((())))"));
		System.out.println(numberOfValidParenthisis("hj()(i())"));

	}

	public static int numberOfValidParenthisis(String s) {
		int res = 0;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(')');
			} else if (c == '[') {
				stack.push(']');
			} else if (c == '{') {
				stack.push('}');
			} else {
				if (!stack.isEmpty() && stack.pop() == c) {
					res++;
				} else {
					if (!stack.isEmpty()) {
						stack.pop();
					}
				}
			}
		}
		return res;
	}
}
