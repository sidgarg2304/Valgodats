package com.vishal.interviews.facebook.easy;

import java.util.Stack;

public class BackspaceStringCompare {

	public static void main(String[] args) {

	}

	public boolean backspaceCompare(String S, String T) {

		return buildString(S).equals(buildString(T));
	}

	String buildString(String s) {
		
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));

		int i = 1;
		while (i < s.length()) {
			if (s.charAt(i) != '#') {
				stack.push(s.charAt(i));
			} else if (!stack.isEmpty()) {
				stack.pop();
			}
			i++;
		}
		return String.valueOf(stack);
	}

}
