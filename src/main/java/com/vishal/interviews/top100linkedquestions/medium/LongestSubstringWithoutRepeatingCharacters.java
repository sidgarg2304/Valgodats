package com.vishal.interviews.top100linkedquestions.medium;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int res = 1;
		Map<Character, Integer> map = new HashMap<>();
		int st = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				st = Math.max(st, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			res = Math.max(res, i - st + 1);
		}
		return res;

	}

}
