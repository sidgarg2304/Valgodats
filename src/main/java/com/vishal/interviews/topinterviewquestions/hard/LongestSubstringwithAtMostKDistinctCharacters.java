package com.vishal.interviews.topinterviewquestions.hard;

import java.util.*;

public class LongestSubstringwithAtMostKDistinctCharacters {

	public static void main(String[] args) {

	}

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap<>();
		int st = 0;

		int maxLen = 1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);

			while (map.size() > k) {
				char p = s.charAt(st);
				map.put(p, map.get(p) - 1);
				if (map.get(p) == 0) {
					map.remove(p);
				}
				st++;
			}

			maxLen = Math.max(maxLen, i - st + 1);

		}

		return maxLen;
	}

}
