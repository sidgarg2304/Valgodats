package com.vishal.interviews.top100linkedquestions.medium;

import java.util.*;

public class DecodeString {

	public static void main(String[] args) {

	}

	public String decodeString(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		Stack<Integer> numstack = new Stack<>();
		Stack<String> stack = new Stack<>();

		String cur = "";
		int i = 0;

		while (i < s.length()) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				int en = i;
				while (s.charAt(en) >= '0' && s.charAt(en) <= '9') {
					en++;
				}
				int num = Integer.valueOf(s.substring(i, en));
				numstack.push(num);
				i = en - 1;
			} else {
				if (c == '[') {
					stack.push(cur);
					cur = "";
				} else if (c == ']') {
					StringBuilder sb = new StringBuilder(stack.pop());
					int cnt = numstack.pop();
					for (int j = 0; j < cnt; j++) {
						sb.append(cur);
					}
					cur = sb.toString();
				} else {
					cur += c;
				}
			}
			i++;
		}
		return cur;
	}

}
