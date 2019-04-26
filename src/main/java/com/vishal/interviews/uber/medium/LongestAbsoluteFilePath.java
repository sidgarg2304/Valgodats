package com.vishal.interviews.uber.medium;

import java.util.*;

public class LongestAbsoluteFilePath {

	public static void main(String[] args) {

	}

	public int lengthLongestPath(String input) {

		String[] arr = input.split("\n");
		Stack<Integer> stack = new Stack<>();
		int res = 0;

		int len = 0;

		for (int i = 0; i < arr.length; i++) {
			String line = arr[i].replaceAll("\t", "");
			int level = arr[i].length() - line.length();
			len += line.length() + 1;
			while (stack.size() > level) {
				len -= stack.pop();
			}

			stack.push(line.length() + 1);
			if (line.contains(".")) {
				res = Math.max(res, len - 1);
			}
		}
		return res;
	}

}
