package com.vishal.interviews.netflix.medium;

import java.util.*;

public class RemoveDuplicatesInAString {

	public static void main(String[] args) {

		System.out.println(removeDuplicatesInAString("agffba"));
	}

	public static String removeDuplicatesInAString(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		StringBuilder res = new StringBuilder();
		Set<Character> set = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (set.add(c)) {
				res.append(c);
			}
		}
		return res.toString();

	}

}
