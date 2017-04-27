package com.vishal.interviews.facebook.medium;

import java.util.*;

/**
 * 71. Simplify Path
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 *
 */
public class SimplifyPath {

	public static void main(String[] args) {

		System.out.println(simplifyPath("/a/./b/../../c/"));
		System.out.println(simplifyPath("/home"));
		System.out.println(simplifyPath("/"));
	}

	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();

		int i = 0;
		int st = 0;
		while (i < path.length()) {
			char c = path.charAt(i);
			if (c == '/' && i > 0) {
				stack.push(path.substring(st, i));

				st = i;
			} else if (i == path.length() - 1) {
				stack.push(path.substring(st));
			}
			i++;
		}

		List<String> res = new ArrayList<>();
		int ct = 0;
		while (!stack.isEmpty()) {

			String cur = stack.pop();
			if(cur.equals("/") || cur.equals("/.")){
				continue;
			}
			if (cur.equals("/..")) {
				ct++;
			} else {
				if (ct > 0) {
					ct--;
				} else {
					res.add(cur);
				}
			}

		}
		if(res.isEmpty()){
			return "/";
		}
		StringBuilder sb = new StringBuilder();
		for (int r = res.size() - 1; r >= 0; r--) {
			sb.append(res.get(r));
		}

		return sb.toString();
	}

}
