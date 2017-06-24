package com.vishal.interviews.programcreek;

import java.util.*;

public class SimplifyPath {

	public static void main(String[] args) {

	}

	public String simplifyPath(String path) {

		Stack<String> stack = new Stack<>();

		int st = 0;
		for (int i = 0; i <= path.length(); i++) {
			if (i == path.length() || path.charAt(i) == '/') {
				stack.push(path.substring(st, i));
				st = i;
			}
		}

		List<String> temp = new ArrayList<>();
		int back = 0;
		while (!stack.isEmpty()) {
			String s = stack.pop();
			if (s.equals("") || s.equals("/") || s.equals("/.")) {
				continue;
			}

			if (s.equals("/..")) {
				back++;
			} else {
				if (back == 0) {
					temp.add(s);
				} else {
					back--;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int r = temp.size() - 1; r >= 0; r--) {
			sb.append(temp.get(r));
		}

		return sb.toString();
	}

}
