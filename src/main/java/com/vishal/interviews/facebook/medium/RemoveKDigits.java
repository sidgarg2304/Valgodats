package com.vishal.interviews.facebook.medium;

import java.util.*;

public class RemoveKDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String removeKdigits(String num, int k) {
      Stack<Character> stack = new Stack<>();

		for (int i = 0; i < num.length(); i++) {

			while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
		}

		while (k > 0) {
			stack.pop();
			k--;
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		sb.reverse();

		int i = 0;
		while (i < sb.length() && sb.charAt(i) == '0') {
			i++;
		}
		String res = sb.substring(i);

		if (res.equals("")) {
			return "0";
		}
		return res;
  }

}
