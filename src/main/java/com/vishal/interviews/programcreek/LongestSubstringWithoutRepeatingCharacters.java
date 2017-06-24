package com.vishal.interviews.programcreek;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

		System.out.println(lengthOfLongestSubstring("abcade"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap<>();

		int max = 0;
		int st = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				//Math.max is needed for cases like abba
				st = Math.max(st, map.get(c) + 1);
			}
			map.put(c, i);
			max = Math.max(max, i - st + 1);
		}
		return max;
	}

	public static int lengthOfLongestSubstringUsingHashSet(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Set<Character> set = new HashSet<>();

		int max = 0;
		int st = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			while (st < s.length() && set.contains(c)) {
				set.remove(s.charAt(st));
				st++;
			}

			max = Math.max(max, i - st + 1);
			set.add(c);
		}
		return max;
	}

}
