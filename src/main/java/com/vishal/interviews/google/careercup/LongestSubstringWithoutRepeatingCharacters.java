package com.vishal.interviews.google.careercup;

import java.util.*;

/**
 * Find longest m distinct character substrings from main string. aba - Answer
 * is ab 0 and 2 O(n) solution - sliding window
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

		System.out.println(longestSubStringWithAllDistinctCharacters("abba"));
	}

	static int longestSubStringWithAllDistinctCharacters(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int st = 0;
		int res = 1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				st = Math.max(st,map.get(c) + 1);
			}

			map.put(c, i);
			res = Math.max(res, i - st + 1);
		}
		
		return res;
	}
}
