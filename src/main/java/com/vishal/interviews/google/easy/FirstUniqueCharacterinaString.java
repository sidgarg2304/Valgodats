package com.vishal.interviews.google.easy;

import java.util.*;

/**
 * 387. First Unique Character in a String
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int firstUniqCharHashMap(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}

		return -1;
	}

	public int firstUniqChar(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (count[c - 'a'] == 1) {
				return i;
			}
		}

		return -1;
	}

}
