package com.vishal.interviews.linkedin.easy;

import java.util.*;
/**
 * 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.


 */
public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static boolean isomorphic(String s, String t) {
		if (s == null && t == null) {
			return true;
		}

		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}

		Map<Character, Character> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char p = s.charAt(i);
			char q = t.charAt(i);

			if (map.containsKey(p)) {
				if (map.get(p) != q) {
					return false;
				}
			} else if (map.containsValue(q)) {
				return false;
			} else {
				map.put(p, q);
			}
		}
		
		return true;
	}

}
