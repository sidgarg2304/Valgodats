package com.vishal.interviews.linkedin.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 *
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {

	}

	static String minWindowSubString(String s, String t) {
		String res = null;

		// a - 1
		// b - 1
		// c - 1
		Map<Character, Integer> inputMap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			inputMap.put(t.charAt(i), inputMap.getOrDefault(t.charAt(i), 0) + 1);
		}

		Map<Character, Integer> map = new HashMap<>();

		int count = 0;
		int min = Integer.MAX_VALUE;
		int st = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (inputMap.containsKey(c)) {
				map.put(c, map.getOrDefault(c, 0) + 1);
				if (map.get(c) <= inputMap.get(c)) {
					count++;
				}
			}

			if (count == t.length()) {

				char p = s.charAt(st);
				while (!inputMap.containsKey(p) || map.get(p) > inputMap.get(p)) {
					if (map.containsKey(p) && map.get(p) > inputMap.get(p)) {
						map.put(p, map.get(p) - 1);
					}
					st++;
					p = s.charAt(st);
				}

				int curLen = i - st + 1;
				if (curLen < min) {
					min = curLen;
					res = s.substring(st, i + 1);
				}
			}
		}

		return res;

	}
}
