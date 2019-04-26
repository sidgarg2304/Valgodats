package com.vishal.interviews.facebook.hard;

import java.util.*;

/**
 * 76. Minimum Window Substring
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * @author vkotha
 *
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String minWindow(String s, String t) {
      if (s == null || t == null || t == null || t.length() == 0) {
			return "";
		}
		
		Map<Character, Integer> inputMap = new HashMap<>();
		for (char c : t.toCharArray()) {
			inputMap.put(c, inputMap.getOrDefault(c, 0) + 1);
		}

		Map<Character, Integer> map = new HashMap<>();
		int st = 0;
		int cnt = 0;

		int minLen = Integer.MAX_VALUE;
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (inputMap.containsKey(c)) {
				map.put(c, map.getOrDefault(c, 0) + 1);
				if (map.get(c) <= inputMap.get(c)) {
					cnt++;
				}
			}

			if (cnt == t.length()) {
				char p = s.charAt(st);
				while (!inputMap.containsKey(p) || inputMap.get(p) < map.get(p)) {
					if (map.containsKey(p) && map.get(p) > inputMap.get(p)) {
						map.put(p, map.get(p) - 1);
                  }
					st++;
					p = s.charAt(st);
					
				}
				int curLen = i - st + 1;
				if (curLen < minLen) {
					minLen = curLen;
					res = s.substring(st, i + 1);
				}
			}
		}

		return res;
  }
}
