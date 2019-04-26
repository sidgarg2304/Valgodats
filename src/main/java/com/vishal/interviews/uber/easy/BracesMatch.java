package com.vishal.interviews.uber.easy;

import java.util.*;

public class BracesMatch {

	public static void main(String[] args) {

		
		int n = scanner.nextInt();
		String[] input = new String[n + 1];
		input[0] = "" + n;
		for(int i = 0; i< n; i++) {
			input[i+1] = scanner.next();
		}
		
		braces(input);
	}

	private static final Scanner scanner = new Scanner(System.in);
	static String[] braces(String[] values) {

		
		int r = Integer.parseInt(values[0]);
		String[] res = new String[r];

		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		for (int i = 0; i < values.length; i++) {
			boolean valid = isValid(values[i], map);
			if (valid) {
				res[i-1] = "YES";
			} else {
				res[i-1] = "NO";
			}
		}
		return res;
	}

	static boolean isValid(String s, Map<Character, Character> map) {

		if (s == null || s.isEmpty()) {
			return true;
		}
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				stack.push(map.get(c));
			} else {
				if (stack.isEmpty() || c != stack.peek()) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

}
