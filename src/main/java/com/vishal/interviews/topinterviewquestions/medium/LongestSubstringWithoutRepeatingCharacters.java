package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap<>();
		int maxLen = 1;
		int st = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				st = Math.max(st, map.get(c) + 1);	
			}
			map.put(c, i);
			maxLen = Math.max(maxLen, i - st + 1);
		}

		return maxLen;
	}
}
